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
package org.gatein.pc.portlet.impl.jsr168.taglib;

import jakarta.servlet.jsp.tagext.TagData;
import jakarta.servlet.jsp.tagext.TagExtraInfo;
import jakarta.servlet.jsp.tagext.VariableInfo;

/**
 * The additional variable definitions for the actionURL tag for the JSR 168 Portlet specification.
 *
 */
public class GenerateURLTagTEI extends TagExtraInfo
{

   public boolean isValid(TagData data)
   {
      return isWindowStateValid(data) &&
         isPortletModeValid(data) &&
         isSecureValid(data);
   }

   public boolean isWindowStateValid(TagData data)
   {
      return true;
   }

   public boolean isPortletModeValid(TagData data)
   {
      return true;
   }

   public boolean isSecureValid(TagData data)
   {
      Object o = data.getAttribute("secure");
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

   public VariableInfo[] getVariableInfo(TagData data)
   {
      String varName = data.getAttributeString("var");
      if (varName == null)
      {
         return null;
      }

      VariableInfo info1
         = new VariableInfo(varName,
         "String",
         true,
         VariableInfo.AT_END);
      VariableInfo[] info = {info1};
      return info;
   }
}
