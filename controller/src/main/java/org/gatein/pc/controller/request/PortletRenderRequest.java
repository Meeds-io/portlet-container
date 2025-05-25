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

import org.gatein.pc.api.PortletInvokerException;
import org.gatein.pc.api.invocation.response.PortletInvocationResponse;
import org.gatein.pc.api.invocation.response.UpdateNavigationalStateResponse;
import org.gatein.pc.controller.ControllerContext;
import org.gatein.pc.controller.state.PageNavigationalState;
import org.gatein.pc.controller.state.WindowNavigationalState;

import java.util.Map;

public class PortletRenderRequest extends PortletRequest
{

   /** . */
   private final Map<String, String[]> publicNavigationalStateChanges;

   public PortletRenderRequest(
      String windowId,
      WindowNavigationalState windowNavigationalState,
      Map<String, String[]> publicNavigationalStateChanges,
      PageNavigationalState pageNavigationalState)
   {
      super(windowId, windowNavigationalState, pageNavigationalState);

      //
      this.publicNavigationalStateChanges = publicNavigationalStateChanges;
   }

   public Map<String, String[]> getPublicNavigationalStateChanges()
   {
      return publicNavigationalStateChanges;
   }

   @Override
   public PortletInvocationResponse invoke(ControllerContext controllerContext) throws PortletInvokerException
   {
      UpdateNavigationalStateResponse updateNavigationalState = new UpdateNavigationalStateResponse();
      updateNavigationalState.setMode(windowNavigationalState.getMode());
      updateNavigationalState.setWindowState(windowNavigationalState.getWindowState());
      updateNavigationalState.setNavigationalState(windowNavigationalState.getPortletNavigationalState());
      updateNavigationalState.setPublicNavigationalStateUpdates(publicNavigationalStateChanges);
      return updateNavigationalState;
   }
}
