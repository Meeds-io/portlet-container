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

import org.gatein.common.io.IOTools;
import org.gatein.pc.api.invocation.response.ContentResponse;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class ResourceRenderer extends AbstractMarkupRenderer
{

   /** . */
   private ContentResponse fragment;

   /** . */
   private boolean sendNoContentResponseOnEmptyResource;

   public ResourceRenderer(ContentResponse response, boolean sendNoContentResponseOnEmptyResource)
   {
      super(response.getProperties());

      //
      this.sendNoContentResponseOnEmptyResource = sendNoContentResponseOnEmptyResource;
      this.fragment = response;
   }

   protected void renderContent(HttpServletResponse resp) throws IOException
   {
      if (fragment.getType() == ContentResponse.TYPE_EMPTY)
      {
         if (sendNoContentResponseOnEmptyResource)
         {
            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
         }
         else
         {
            String contentType = fragment.getContentType();
            if (contentType != null)
            {
               resp.setContentType(contentType);
            }

            //
            ServletOutputStream out = null;
            try
            {
               out = resp.getOutputStream();
            }
            finally
            {
               IOTools.safeClose(out);
            }
         }
      }
      else
      {
         String contentType = fragment.getContentType();
         if (contentType != null)
         {
            resp.setContentType(contentType);
         }

         //
         if (fragment.getType() == ContentResponse.TYPE_BYTES)
         {
            ServletOutputStream out = null;
            try
            {
               out = resp.getOutputStream();
               out.write(fragment.getBytes());
            }
            finally
            {
               IOTools.safeClose(out);
            }
         }
         else
         {
            Writer writer = null;
            try
            {
               writer = resp.getWriter();
               writer.write(fragment.getChars());
            }
            finally
            {
               writer.close();
            }
         }
      }
   }
}
