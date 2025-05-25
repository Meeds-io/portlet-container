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

import org.gatein.pc.controller.ControllerContext;
import org.gatein.pc.controller.PortletController;
import org.gatein.pc.controller.impl.AbstractControllerContext;
import org.gatein.pc.controller.state.PageNavigationalState;
import org.gatein.pc.api.invocation.response.PortletInvocationResponse;
import org.gatein.pc.api.PortletInvokerException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;
import java.util.List;

public abstract class AbstractRendererContext implements RendererContext
{

   /** . */
   private final AbstractControllerContext portletControllerContext;

   protected AbstractRendererContext(AbstractControllerContext portletControllerContext)
   {
      this.portletControllerContext = portletControllerContext;
   }

   public HttpServletRequest getClientRequest()
   {
      return portletControllerContext.getClientRequest();
   }

   public HttpServletResponse getClientResponse()
   {
      return portletControllerContext.getClientResponse();
   }

   public ControllerContext getPortletControllerContext()
   {
      return portletControllerContext;
   }

   public PortletInvocationResponse render(List<Cookie> cookies, PageNavigationalState pageNavigationalState, String windowId) throws PortletInvokerException
   {
      return new PortletController().render(portletControllerContext, cookies, pageNavigationalState, windowId);
   }
}
