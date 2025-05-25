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
package org.gatein.pc.test.controller;

import org.gatein.common.util.MultiValuedPropertyMap;
import org.gatein.pc.api.invocation.response.ResponseProperties;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public abstract class AbstractMarkupRenderer implements Renderer
{

   /** . */
   protected ResponseProperties properties;

   public AbstractMarkupRenderer(ResponseProperties properties)
   {
      this.properties = properties;
   }

   public void render(RendererContext context) throws IOException
   {
      prepareRendering(context);
      HttpServletResponse resp = context.getClientResponse();

      // Render the headers and cookies
      if (properties != null)
      {
         renderTransportHeaders(properties, resp);
         renderCookies(properties, resp);
      }

      renderContent(resp);
   }

   protected abstract void renderContent(HttpServletResponse resp) throws IOException;

   private void renderCookies(ResponseProperties pageProperties, HttpServletResponse resp)
   {
      List<Cookie> cookies = pageProperties.getCookies();
      for (Cookie cookie : cookies)
      {
         resp.addCookie(cookie);
      }
   }

   private void renderTransportHeaders(ResponseProperties pageProperties, HttpServletResponse resp)
   {
      MultiValuedPropertyMap<String> transportHeaders = pageProperties.getTransportHeaders();
      for (String headerName : transportHeaders.keySet())
      {
         for (String headerValue : transportHeaders.getValues(headerName))
         {
            resp.addHeader(headerName, headerValue);
         }
      }
   }

   protected void prepareRendering(RendererContext context)
   {
      // default behavior does nothing
   }
}
