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

import org.gatein.pc.portlet.impl.jsr168.taglib.PortletTag;

import jakarta.servlet.jsp.JspException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletSession;
import javax.portlet.PortletPreferences;
import java.util.Map;

public class DefineObjects286Tag extends PortletTag
{
   /** The serialVersionUID */
   private static final long serialVersionUID = -8640865649772583292L;

   public int doStartTag() throws JspException
   {
      return SKIP_BODY;
   }

   public int doEndTag() throws JspException
   {
      RenderRequest rreq = getRenderRequest();
      RenderResponse rresp = getRenderResponse();
      ActionRequest areq = getActionRequest();
      ActionResponse aresp = getActionResponse();
      EventRequest ereq = getEventRequest();
      EventResponse eresp = getEventResponse();
      ResourceRequest rsreq = getResourceRequest();
      ResourceResponse rsresp = getResourceResponse();
      PortletConfig portletConfig = getConfig();
      PortletSession portletSession = getSession();
      Map<String, Object> portletSessionScope = getPortletSessionScope();
      PortletPreferences portletPreferences = getPortletPreferences();
      Map<String, String[]> portletPreferencesValues = getPortletPreferenceValues();
      pageContext.setAttribute(DefineObjects286TagTEI.renderRequestVariableName, rreq);
      pageContext.setAttribute(DefineObjects286TagTEI.renderResponseVariableName, rresp);
      pageContext.setAttribute(DefineObjects286TagTEI.actionRequestVariableName, areq);
      pageContext.setAttribute(DefineObjects286TagTEI.actionResponseVariableName, aresp);
      pageContext.setAttribute(DefineObjects286TagTEI.eventRequestVariableName, ereq);
      pageContext.setAttribute(DefineObjects286TagTEI.eventResponseVariableName, eresp);
      pageContext.setAttribute(DefineObjects286TagTEI.resourceRequestVariableName, rsreq);
      pageContext.setAttribute(DefineObjects286TagTEI.resourceResponseVariableName, rsresp);
      pageContext.setAttribute(DefineObjects286TagTEI.portletConfigVariableName, portletConfig);
      pageContext.setAttribute(DefineObjects286TagTEI.portletSessionVariableName, portletSession);
      pageContext.setAttribute(DefineObjects286TagTEI.portletSessionScopeVariableName, portletSessionScope);
      pageContext.setAttribute(DefineObjects286TagTEI.portletPreferencesVariableName, portletPreferences);
      pageContext.setAttribute(DefineObjects286TagTEI.portletPreferencesValuesVariableName, portletPreferencesValues);

      return EVAL_PAGE;
   }
}
