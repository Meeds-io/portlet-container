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
import org.gatein.pc.controller.ControllerContext;
import org.gatein.pc.controller.state.PageNavigationalState;
import org.gatein.pc.controller.state.WindowNavigationalState;

import javax.xml.namespace.QName;
import java.io.Serializable;

/**
 * An event request. The purpose of this type of request is to allow
 * the portal to fire events to a portlet.
 *
 */
public class PortletEventRequest extends PortletRequest
{

   /** . */
   private final QName name;

   /** . */
   private final Serializable payload;

   public PortletEventRequest(
      String windowId,
      WindowNavigationalState windowNavigationalState,
      PageNavigationalState pageNavigationalState,
      QName name,
      Serializable payload)
   {
      super(windowId, windowNavigationalState, pageNavigationalState);

      //
      this.name = name;
      this.payload = payload;
   }

   public QName getName()
   {
      return name;
   }

   public Serializable getPayload()
   {
      return payload;
   }

   @Override
   public PortletInvocationResponse invoke(ControllerContext controllerContext) throws PortletInvokerException
   {
      throw new UnsupportedOperationException("Not implemented");
   }
}
