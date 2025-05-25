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

import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.gatein.pc.controller.event.EventControllerContext;
import org.gatein.pc.controller.event.WindowEvent;
import org.gatein.pc.api.invocation.response.PortletInvocationResponse;

import java.util.Collections;

/**
 * An help class to catch and log exceptions thrown by an event controller context.
 *
 */
class EventControllerContextSafeInvoker
{

   /** . */
   private final Log log = ExoLogger.getLogger(EventControllerContextSafeInvoker.class);

   public Iterable<WindowEvent> eventProduced(EventControllerContext controllerContext, EventPhaseContext phaseContext, WindowEvent sourceEvent, WindowEvent producedEvent)
   {
      try
      {
         return controllerContext.eventProduced(phaseContext, producedEvent, sourceEvent);
      }
      catch (Exception e)
      {
         log.error("Cannot deliver produced event " + producedEvent + " because the event " +
            "controller context threw a runtime exception", e);

         //
         return Collections.emptyList();
      }
   }

   public boolean eventConsumed(EventControllerContext controllerContext, EventPhaseContext phaseContext, WindowEvent consumedEvent, PortletInvocationResponse consumerResponse)
   {
      try
      {
         controllerContext.eventConsumed(phaseContext, consumedEvent, consumerResponse);

         //
         return true;
      }
      catch (Exception e)
      {
         log.error("Event consumed callback threw an exception that is ignored by the controller", e);

         //
         return false;
      }
   }

   public boolean eventFailed(EventControllerContext controllerContext, EventPhaseContext phaseContext, WindowEvent failedEvent, Throwable throwable)
   {
      try
      {
         controllerContext.eventFailed(phaseContext, failedEvent, throwable);

         //
         return true;
      }
      catch (Exception e1)
      {
         log.error("Event delivery failed callback threw an exception that is ignored by the controller", e1);

         //
         return false;
      }
   }

   public boolean eventDiscarded(EventControllerContext controllerContext, EventPhaseContext phaseContext, WindowEvent discardedEvent, int cause)
   {
      try
      {
         controllerContext.eventDiscarded(phaseContext, discardedEvent, cause);

         //
         return true;
      }
      catch (Exception e1)
      {
         log.error("Event delivery failed callback threw an exception that is ignored by the controller", e1);

         //
         return false;
      }
   }
}
