/**
 * This file is part of the Meeds project (https://meeds.io/).
 *
 * Copyright (C) 2020 - 2025 Meeds Association contact@meeds.io
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package org.gatein.pc.portlet.impl.jsr168;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequestWrapper;
import jakarta.servlet.ServletResponseWrapper;
import java.io.IOException;

public class DispatchedRequestDispatcher implements RequestDispatcher
{

   /** . */
   private final RequestDispatcher realDispatcher;

   /** . */
   private final String path;

   public DispatchedRequestDispatcher(RequestDispatcher realDispatcher, String path)
   {
      this.realDispatcher = realDispatcher;
      this.path = path;
   }

   public void include(ServletRequest req, ServletResponse resp) throws ServletException, IOException
   {
      DispatchedHttpServletRequest dreq = unwrap(req);
      unwrap(resp);

      //
      dreq.pushDispatch(new Dispatch(DispatchType.INCLUDE, path));
      try
      {
         realDispatcher.include(req, resp);
      }
      finally
      {
         dreq.popDispatch();
      }
   }

   public void forward(ServletRequest req, ServletResponse resp) throws ServletException, IOException
   {
      DispatchedHttpServletRequest dreq = unwrap(req);
      unwrap(resp);

      //
      dreq.pushDispatch(new Dispatch(DispatchType.FORWARD, path));
      try
      {
         realDispatcher.include(req, resp);
      }
      finally
      {
         dreq.popDispatch();
      }
   }

   private static DispatchedHttpServletRequest unwrap(ServletRequest wrapped)
   {
      while (true)
      {
         if (wrapped instanceof DispatchedHttpServletRequest)
         {
            return (DispatchedHttpServletRequest)wrapped;
         }
         else if (wrapped instanceof ServletRequestWrapper)
         {
            ServletRequestWrapper wrapper = (ServletRequestWrapper)wrapped;
            wrapped = wrapper.getRequest();
         }
         else
         {
            throw new IllegalArgumentException();
         }
      }
   }

   private static DispatchedHttpServletResponse unwrap(ServletResponse wrapped)
   {
      while (true)
      {
         if (wrapped instanceof DispatchedHttpServletResponse)
         {
            return (DispatchedHttpServletResponse)wrapped;
         }
         else if (wrapped instanceof ServletResponseWrapper)
         {
            ServletResponseWrapper wrapper = (ServletResponseWrapper)wrapped;
            wrapped = wrapper.getResponse();
         }
         else
         {
            throw new IllegalArgumentException();
         }
      }
   }
}
