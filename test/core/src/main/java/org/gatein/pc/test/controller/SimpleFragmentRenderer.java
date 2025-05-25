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

import org.gatein.pc.api.invocation.response.ErrorResponse;
import org.gatein.pc.api.invocation.response.ContentResponse;

import java.io.UnsupportedEncodingException;

public class SimpleFragmentRenderer implements FragmentRenderer
{
   public String renderPortlet(ContentResponse fragment)
   {

      if (fragment.getType() != ContentResponse.TYPE_EMPTY)
      {
         String frag;

         //
         if (fragment.getType() == ContentResponse.TYPE_BYTES)
         {
            try
            {
               frag = new String(fragment.getBytes(), "UTF-8");
            }
            catch (UnsupportedEncodingException e)
            {
               throw new Error(e);
            }
         }
         else
         {
            frag = fragment.getChars();
         }

         StringBuilder builder = new StringBuilder(frag.length() + 50);
         builder.append("<div class='portlet' style='border: 1px solid #aaa; background-color: #eee;'>").append(frag).append("</div>");
         return builder.toString();
      }
      else
      {
         return "<div/>";
      }
   }

   public String renderError(ErrorResponse error)
   {
      String html = error.toHTML();
      StringBuilder builder = new StringBuilder(html.length() + 50);
      builder.append("<div class='error' style='border: 1px solid #aaa; background-color: #fee;'>").append(html).append("</div>");
      return builder.toString();
   }
}
