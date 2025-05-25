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
package org.gatein.pc.controller.impl.event;

import org.gatein.pc.api.Portlet;
import org.gatein.pc.api.PortletInvokerException;
import org.gatein.pc.api.PortletInvoker;
import org.gatein.pc.api.invocation.response.PortletInvocationResponse;
import org.gatein.pc.controller.event.WindowEvent;
import org.gatein.pc.controller.event.EventControllerContext;
import org.gatein.pc.controller.EventPhaseContext;
import org.gatein.pc.api.info.PortletInfo;

import java.util.LinkedList;

public class EventControllerContextImpl implements EventControllerContext
{

   /** . */
   private PortletInvoker invoker;

   public EventControllerContextImpl(PortletInvoker invoker)
   {
      this.invoker = invoker;
   }

   public Iterable<WindowEvent> eventProduced(EventPhaseContext context, WindowEvent producedEvent, WindowEvent sourceEvent)
   {
      try
      {
         LinkedList<WindowEvent> toConsume = new LinkedList<WindowEvent>();
         for (Portlet portlet : invoker.getPortlets())
         {
            PortletInfo portletInfo = portlet.getInfo();
            if (portletInfo.getEventing().getConsumedEvents().containsKey(producedEvent.getName()))
            {
               WindowEvent distributedEvent = new WindowEvent(producedEvent.getName(), producedEvent.getPayload(), portlet.getContext().getId());
               toConsume.addLast(distributedEvent);
            }
         }
         return toConsume;
      }
      catch (PortletInvokerException e)
      {
         System.out.println("e = " + e);
         return null;
      }
   }

   public void eventConsumed(EventPhaseContext context, WindowEvent consumedEvent, PortletInvocationResponse consumerResponse)
   {
   }

   public void eventFailed(EventPhaseContext context, WindowEvent failedEvent, Throwable throwable)
   {
   }

   public void eventDiscarded(EventPhaseContext context, WindowEvent discardedEvent, int cause)
   {
   }
}
