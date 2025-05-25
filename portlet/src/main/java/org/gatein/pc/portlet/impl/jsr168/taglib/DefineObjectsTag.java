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
import jakarta.servlet.jsp.JspException;

/**
 * The defineObjects tag for the JSR 168 Portlet specification.
 *
 */
public class DefineObjectsTag extends PortletTag
{

   /** The serialVersionUID */
   private static final long serialVersionUID = -8640865649772583292L;

   public int doStartTag() throws JspException
   {
      return SKIP_BODY;
   }

   public int doEndTag() throws JspException
   {

      RenderRequest rreq = (RenderRequest)getPortletRequest();
      RenderResponse rresp = (RenderResponse)getPortletResponse();
      PortletConfig portletConfig = getConfig();
      pageContext.setAttribute(DefineObjectsTagTEI.renderRequestVariableName, rreq);
      pageContext.setAttribute(DefineObjectsTagTEI.renderResponseVariableName, rresp);
      pageContext.setAttribute(DefineObjectsTagTEI.portletConfigVariableName, portletConfig);
      
      return EVAL_PAGE;
   }
}
