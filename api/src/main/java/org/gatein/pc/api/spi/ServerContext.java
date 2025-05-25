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
package org.gatein.pc.api.spi;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Defines the request context contract. It's usage is related to the Servlet Container operational
 * environment.
 *
 */
public interface ServerContext
{
   /**
    * Return the scheme value.
    *
    * @return the scheme
    */
   String getScheme();

   /**
    * Return the server name value.
    *
    * @return the server name
    */
   String getServerName();

   /**
    * Return the server port value.
    *
    * @return the server port
    */
   int getServerPort();

   /**
    * Delegate to the request context the dispatching to the target servlet context using the specified spi elements.
    *
    * @param target the target servlet context
    * @param callable the callable
    * @throws Exception any exception
    */
   void dispatch(ServletContext target, HttpServletRequest request, HttpServletResponse response, Callable callable) throws Exception;

   /**
    * The dispatch callable contract.
    */
   interface Callable
   {

      /**
       * The callback
       *
       * @param context the servlet context
       * @param request the servlet request
       * @param response the servle response
       * @throws ServletException any exception
       */
      void call(ServletContext context, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

   }
}
