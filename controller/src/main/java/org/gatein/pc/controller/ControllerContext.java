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
package org.gatein.pc.controller;

import org.gatein.pc.api.PortletInvokerException;
import org.gatein.pc.controller.event.EventControllerContext;
import org.gatein.pc.controller.state.PageNavigationalState;
import org.gatein.pc.controller.state.StateControllerContext;
import org.gatein.pc.api.info.PortletInfo;
import org.gatein.pc.api.invocation.ActionInvocation;
import org.gatein.pc.api.invocation.EventInvocation;
import org.gatein.pc.api.invocation.ResourceInvocation;
import org.gatein.pc.api.invocation.RenderInvocation;
import org.gatein.pc.api.invocation.response.PortletInvocationResponse;
import org.gatein.pc.api.spi.PortletInvocationContext;

import jakarta.servlet.http.Cookie;
import java.util.List;

/**
 * The context provided to call the portlet controller.
 *
 */
public interface ControllerContext
{

   EventControllerContext getEventControllerContext();

   StateControllerContext getStateControllerContext();

   /**
    * Returns the portet info for a specified window.
    *
    * @param windowId the window id
    * @return the portlet info or null if none can be found
    */
   PortletInfo getPortletInfo(String windowId);

   /**
    * Create a portlet invocation context for the specified window id.
    *
    * @param windowId the window id
    * @param pageNavigationalState the page navigational state
    * @return the portlet invocation context
    */
   PortletInvocationContext createPortletInvocationContext(String windowId, PageNavigationalState pageNavigationalState);

   PortletInvocationResponse invoke(String windowId, ActionInvocation actionInvocation) throws PortletInvokerException;

   PortletInvocationResponse invoke(String windowId, List<Cookie> requestCookies, EventInvocation eventInvocation) throws PortletInvokerException;

   PortletInvocationResponse invoke(String windowId, List<Cookie> requestCookies, RenderInvocation renderInvocation) throws PortletInvokerException;

   PortletInvocationResponse invoke(String windowId, ResourceInvocation resourceInvocation) throws PortletInvokerException;

}
