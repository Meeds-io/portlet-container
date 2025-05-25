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
package org.gatein.pc.controller.handlers;

import org.gatein.pc.portlet.support.PortletSupport;
import org.gatein.pc.api.invocation.response.PortletInvocationResponse;
import org.gatein.pc.api.invocation.response.UpdateNavigationalStateResponse;
import org.gatein.pc.api.invocation.EventInvocation;
import org.gatein.pc.api.PortletInvokerException;

import javax.xml.namespace.QName;
import java.io.Serializable;

public class NoOpEventHandler extends PortletSupport.EventHandler
{

   /** . */
   private QName name;

   /** . */
   private Serializable payload;

   protected PortletInvocationResponse invoke(EventInvocation action) throws PortletInvokerException
   {
      name = action.getName();
      payload = action.getPayload();

      //
      return new UpdateNavigationalStateResponse();
   }

   public QName getName()
   {
      return name;
   }

   public Serializable getPayload()
   {
      return payload;
   }
}
