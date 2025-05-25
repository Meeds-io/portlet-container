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
package org.gatein.pc.portlet.impl.spi;

import org.gatein.pc.api.spi.ServerContext;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletContext;

public class AbstractServerContext implements ServerContext
{

   /** . */
   private HttpServletRequest clientRequest;

   /** . */
   private HttpServletResponse clientResponse;

   public AbstractServerContext(HttpServletRequest clientRequest, HttpServletResponse clientResponse)
   {
      this.clientRequest = clientRequest;
      this.clientResponse = clientResponse;
   }

   public String getScheme()
   {
      return clientRequest.getScheme();
   }

   public String getServerName()
   {
      return clientRequest.getServerName();
   }

   public int getServerPort()
   {
      return clientRequest.getServerPort();
   }

   @Override
   public void dispatch(ServletContext target, HttpServletRequest request, HttpServletResponse response, Callable callable) throws Exception
   {
      throw new UnsupportedOperationException();
   }

   public HttpServletResponse getResponse()
   {
      return clientResponse;
   }
}
