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
package org.gatein.pc.controller.request;

import org.gatein.common.util.ParameterMap;
import org.gatein.pc.api.PortletInvokerException;
import org.gatein.pc.api.StateString;
import org.gatein.pc.api.WindowState;
import org.gatein.pc.api.invocation.ActionInvocation;
import org.gatein.pc.api.invocation.response.PortletInvocationResponse;
import org.gatein.pc.api.spi.PortletInvocationContext;
import org.gatein.pc.controller.ControllerContext;
import org.gatein.pc.controller.state.PageNavigationalState;
import org.gatein.pc.controller.state.WindowNavigationalState;

import java.util.Map;

public class PortletActionRequest extends PortletRequest
{

   /** . */
   private final StateString interactionState;

   /** . */
   private final Map<String, String[]> bodyParameters;

   /**
    * Build a new portlet action request.
    *
    * @param windowId the window id
    * @param interactionState the interaction state
    * @param bodyParameters the body parameters
    * @param windowNavigationalState the window navigational state
    * @param pageNavigationalState the page navigational state
    * @throws IllegalArgumentException if the window id or the interaction state is null
    */
   public PortletActionRequest(
      String windowId,
      StateString interactionState,
      Map<String, String[]> bodyParameters,
      WindowNavigationalState windowNavigationalState,
      PageNavigationalState pageNavigationalState) throws IllegalArgumentException
   {
      super(windowId, windowNavigationalState, pageNavigationalState);

      //
      if (interactionState == null)
      {
         throw new IllegalArgumentException("No null interaction state accepted");
      }

      //
      this.interactionState = interactionState;
      this.bodyParameters = bodyParameters;
   }

   public StateString getInteractionState()
   {
      return interactionState;
   }

   public Map<String, String[]> getBodyParameters()
   {
      return bodyParameters;
   }

   @Override
   public PortletInvocationResponse invoke(ControllerContext context) throws PortletInvokerException
   {
      org.gatein.pc.api.Mode mode = windowNavigationalState.getMode();
      if (mode == null)
      {
         mode = org.gatein.pc.api.Mode.VIEW;
      }

      //
      WindowState windowState = windowNavigationalState.getWindowState();
      if (windowState == null)
      {
         windowState = WindowState.NORMAL;
      }

      //
      Map<String, String[]> publicNS = null;
      if (pageNavigationalState != null)
      {
         publicNS = context.getStateControllerContext().getPublicWindowNavigationalState(context, pageNavigationalState, windowId);
      }

      PortletInvocationContext portletInvocationContext = context.createPortletInvocationContext(windowId, pageNavigationalState);
      ActionInvocation actionInvocation = new ActionInvocation(portletInvocationContext);

      //
      actionInvocation.setMode(mode);
      actionInvocation.setWindowState(windowState);
      actionInvocation.setNavigationalState(windowNavigationalState.getPortletNavigationalState());
      actionInvocation.setPublicNavigationalState(publicNS);
      actionInvocation.setInteractionState(interactionState);
      actionInvocation.setForm(bodyParameters != null ? ParameterMap.clone(bodyParameters) : null);

      //
      return context.invoke(windowId, actionInvocation);
   }
}
