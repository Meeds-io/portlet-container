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

import org.gatein.pc.api.spi.RequestContext;

import jakarta.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

public class AbstractRequestContext implements RequestContext
{

   /** . */
   private final HttpServletRequest clientRequest;

   public AbstractRequestContext(HttpServletRequest clientRequest)
   {
      if (clientRequest == null)
      {
         throw new IllegalArgumentException("No client request provided");
      }

      //
      this.clientRequest = clientRequest;
   }

   public String getCharacterEncoding()
   {
      return clientRequest.getCharacterEncoding();
   }

   public BufferedReader getReader() throws IOException
   {
      return clientRequest.getReader();
   }

   public InputStream getInputStream() throws IOException
   {
      return clientRequest.getInputStream();
   }

   public int getContentLength()
   {
      return clientRequest.getContentLength();
   }

   public String getContentType()
   {
      return clientRequest.getContentType();
   }
}
