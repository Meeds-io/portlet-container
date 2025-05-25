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

import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import jakarta.servlet.jsp.tagext.TagData;
import jakarta.servlet.jsp.tagext.TagExtraInfo;
import jakarta.servlet.jsp.tagext.VariableInfo;

/**
 * The additional variable definitions for the defineObjects tag for the JSR 168 Portlet specification.
 *
 */
public class DefineObjectsTagTEI extends TagExtraInfo
{
   public static final String portletConfigVariableName = "portletConfig";
   public static final String renderRequestVariableName = "renderRequest";
   public static final String renderResponseVariableName = "renderResponse";

   public VariableInfo[] getVariableInfo(TagData data)
   {
      VariableInfo info1 = new VariableInfo(portletConfigVariableName,
         PortletConfig.class.getName(), true, VariableInfo.AT_END);
      VariableInfo info2 = new VariableInfo(renderRequestVariableName,
         RenderRequest.class.getName(), true, VariableInfo.AT_END);
      VariableInfo info3 = new VariableInfo(renderResponseVariableName,
         RenderResponse.class.getName(), true, VariableInfo.AT_END);


      VariableInfo[] info = {info1, info2, info3};
      return info;
   }
}
