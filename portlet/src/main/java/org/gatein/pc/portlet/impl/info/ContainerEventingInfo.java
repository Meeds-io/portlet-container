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
package org.gatein.pc.portlet.impl.info;

import org.gatein.pc.api.info.EventingInfo;

import javax.xml.namespace.QName;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ContainerEventingInfo implements EventingInfo
{

   /** . */
   private final Map<QName, ContainerEventInfo> producedEvents;

   /** . */
   private final Map<QName, ContainerEventInfo> consumedEvents;

   public ContainerEventingInfo()
   {
      producedEvents = new HashMap<QName, ContainerEventInfo>();
      consumedEvents = new HashMap<QName, ContainerEventInfo>();
   }

   public void addProducedEvent(ContainerEventInfo producedEvent)
   {
      producedEvents.put(producedEvent.getName(), producedEvent);
   }

   public void addConsumedEvent(ContainerEventInfo consumedEvent)
   {
      consumedEvents.put(consumedEvent.getName(), consumedEvent);
   }

   public Map<QName, ContainerEventInfo> getProducedEvents()
   {
      return Collections.unmodifiableMap(producedEvents);
   }

   public Map<QName, ContainerEventInfo> getConsumedEvents()
   {
      return Collections.unmodifiableMap(consumedEvents);
   }
}
