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
package org.gatein.pc.controller.response;

import org.gatein.pc.api.invocation.response.PortletInvocationResponse;

public class PortletResponse extends ControllerResponse
{

   /** The event distribution was properly done. */
   public static final int DISTRIBUTION_DONE = 0;

   /** The event distribution was interruped by the event controller context. */
   public static final int INTERRUPTED = 1;

   /** The event distribution did flood with produced events. */
   public static final int PRODUCED_EVENT_FLOODED = 2;

   /** The event distribution did flood with consumed events. */
   public static final int CONSUMED_EVENT_FLOODED = 3;

   /** . */
   private final PortletInvocationResponse response;

   /** . */
   private final int eventDistributionStatus;

   public PortletResponse(PortletInvocationResponse response, int eventDistributionStatus)
   {
      this.response = response;
      this.eventDistributionStatus = eventDistributionStatus;
   }

   public int getEventDistributionStatus()
   {
      return eventDistributionStatus;
   }

   public PortletInvocationResponse getResponse()
   {
      return response;
   }
}
