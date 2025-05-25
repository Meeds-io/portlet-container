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
package org.gatein.pc.controller.event;

import org.gatein.pc.api.invocation.response.PortletInvocationResponse;
import org.gatein.pc.controller.EventPhaseContext;

import java.util.Collections;

/**
 * An implementation of the event controller context that do no ops.
 *
 */
public class AbstractEventControllerContext implements EventControllerContext
{
   public Iterable<WindowEvent> eventProduced(EventPhaseContext context, WindowEvent producedEvent, WindowEvent sourceEvent)
   {
      return Collections.emptyList();
   }

   public void eventConsumed(EventPhaseContext context, WindowEvent consumedEvent, PortletInvocationResponse consumerResponse)
   {
   }

   public void eventFailed(EventPhaseContext context, WindowEvent consumedEvent, Throwable throwable)
   {
   }

   public void eventDiscarded(EventPhaseContext context, WindowEvent discardedEvent, int cause)
   {
   }
}
