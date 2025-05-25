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
package org.gatein.pc.portlet.impl.jsr286.taglib;

import org.gatein.pc.portlet.impl.jsr168.taglib.GenerateURLTagTEI;

import jakarta.servlet.jsp.tagext.TagData;

public class GenerateURL286TagTEI extends GenerateURLTagTEI
{

   public boolean isValid(TagData data)
   {
      return true;
//      if (super.isValid(data) &&
//         isEscapeXmlValid(data) &&
//         isCopyCurrentRenderParameters(data))
//      {
//         return true;
//      }
      //return false;
   }

   public boolean isEscapeXmlValid(TagData data)
   {
      Object o = data.getAttribute("escapeXml");
      if (o != null && o != TagData.REQUEST_TIME_VALUE)
      {
         String s = (String)o;
         if (s.toLowerCase().equals("true") ||
            s.toLowerCase().equals("false"))
         {
            return true;
         }
         else
         {
            return false;
         }
      }
      else
      {
         return true;
      }
   }

   public boolean isCopyCurrentRenderParameters(TagData data)
   {
      Object o = data.getAttribute("copyCurrentRenderParameters");
      if (o != null && o != TagData.REQUEST_TIME_VALUE)
      {
         String s = (String)o;
         if (s.toLowerCase().equals("true") ||
            s.toLowerCase().equals("false"))
         {
            return true;
         }
         else
         {
            return false;
         }
      }
      else
      {
         return true;
      }
   }


}
