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
package org.gatein.pc.federation.impl;

import org.gatein.pc.federation.FederatingPortletInvoker;
import org.gatein.pc.api.PortletInvoker;

/**
 * Register any portlet invoker into a federating portlet invoker.
 *
 */
public class PortletInvokerRegistrationService
{

   /** The registration id. */
   private String id;

   /** The portlet invoker to register. */
   private PortletInvoker portletInvoker;

   /** The federating portlet invoker. */
   private FederatingPortletInvoker federatingPortletInvoker;

   public String getId()
   {
      return id;
   }

   public void setId(String id)
   {
      this.id = id;
   }

   public PortletInvoker getPortletInvoker()
   {
      return portletInvoker;
   }

   public void setPortletInvoker(PortletInvoker portletInvoker)
   {
      this.portletInvoker = portletInvoker;
   }

   public FederatingPortletInvoker getFederatingPortletInvoker()
   {
      return federatingPortletInvoker;
   }

   public void setFederatingPortletInvoker(FederatingPortletInvoker federatingPortletInvoker)
   {
      this.federatingPortletInvoker = federatingPortletInvoker;
   }

   public void start() throws Exception
   {
      federatingPortletInvoker.registerInvoker(id, portletInvoker);
   }

   public void stop() throws Exception
   {
      federatingPortletInvoker.unregisterInvoker(id);
   }
}
