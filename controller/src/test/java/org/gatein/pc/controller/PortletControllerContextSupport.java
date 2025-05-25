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

import org.gatein.pc.api.info.PortletInfo;
import org.gatein.pc.api.spi.PortletInvocationContext;
import org.gatein.pc.controller.state.PageNavigationalState;
import org.gatein.pc.controller.state.StateControllerContext;
import org.gatein.pc.controller.state.WindowNavigationalState;
import org.gatein.pc.controller.impl.state.StateControllerContextImpl;
import org.gatein.pc.controller.event.EventControllerContext;
import org.gatein.pc.controller.request.ControllerRequest;
import org.gatein.pc.controller.request.PortletActionRequest;
import org.gatein.pc.api.invocation.response.PortletInvocationResponse;
import org.gatein.pc.api.invocation.ActionInvocation;
import org.gatein.pc.api.invocation.EventInvocation;
import org.gatein.pc.api.invocation.ResourceInvocation;
import org.gatein.pc.api.invocation.PortletInvocation;
import org.gatein.pc.api.invocation.RenderInvocation;
import org.gatein.pc.api.PortletInvokerException;
import org.gatein.pc.api.PortletContext;
import org.gatein.pc.api.OpaqueStateString;
import org.gatein.pc.portlet.support.PortletInvokerSupport;
import org.gatein.pc.portlet.support.PortletSupport;
import org.gatein.common.util.ParameterMap;

import jakarta.servlet.http.Cookie;
import java.util.List;

public final class PortletControllerContextSupport implements ControllerContext
{

   /** . */
   private final StateControllerContext stateControllerContext = new StateControllerContextImpl();

   /** . */
   private EventControllerContext eventControllerContext;

   /** . */
   private final PortletInvokerSupport invoker = new PortletInvokerSupport();

   public PortletInvokerSupport getInvoker()
   {
      return invoker;
   }

   public PortletInfo getPortletInfo(String windowId)
   {
      if (windowId == null)
      {
         throw new IllegalArgumentException();
      }

      //
      PortletSupport portlet = invoker.getPortlet(windowId);

      //
      return portlet != null ? portlet.getInfo() : null;
   }

   //
   public PortletInvocationContext createPortletInvocationContext(String windowId, PageNavigationalState pageNavigationalState)
   {
      if (windowId == null)
      {
         throw new IllegalArgumentException();
      }

      //
      return new PortletInvocationContextSupport(windowId, pageNavigationalState);
   }

   private PortletInvocationResponse invoke(PortletInvocation invocation) throws PortletInvokerException
   {
      PortletInvocationContextSupport context = (PortletInvocationContextSupport)invocation.getContext();

      //
      PortletContext target = PortletContext.createPortletContext(context.getWindowId());

      //
      invocation.setTarget(target);

      //
      return invoker.invoke(invocation);
   }

   public PortletInvocationResponse invoke(String windowId, ActionInvocation actionInvocation) throws PortletInvokerException
   {
      return invoke((PortletInvocation)actionInvocation);
   }

   public PortletInvocationResponse invoke(String windowId, List<Cookie> requestCookies, EventInvocation eventInvocation) throws PortletInvokerException
   {
      return invoke(eventInvocation);
   }

   public PortletInvocationResponse invoke(String windowId, List<Cookie> requestCookies, RenderInvocation renderInvocation) throws PortletInvokerException
   {
      return invoke((PortletInvocation)renderInvocation);
   }

   public PortletInvocationResponse invoke(String windowId, ResourceInvocation resourceInvocation) throws PortletInvokerException
   {
      return invoke((PortletInvocation)resourceInvocation);
   }

   public EventControllerContext getEventControllerContext()
   {
      return eventControllerContext;
   }

   public void setEventControllerContext(EventControllerContext eventControllerContext)
   {
      this.eventControllerContext = eventControllerContext;
   }

   public StateControllerContext getStateControllerContext()
   {
      return stateControllerContext;
   }

   public ControllerRequest createActionRequest(String windowId)
   {
      return new PortletActionRequest(
         windowId,
         new OpaqueStateString(""),
         new ParameterMap(),
         new WindowNavigationalState(),
         new PageNavigationalState(true)
      );
   }
}
