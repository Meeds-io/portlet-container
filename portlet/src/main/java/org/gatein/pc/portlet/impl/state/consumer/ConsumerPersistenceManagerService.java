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
package org.gatein.pc.portlet.impl.state.consumer;

import org.gatein.pc.portlet.state.consumer.ConsumerStateContext;
import org.gatein.pc.api.PortletStateType;

import java.util.HashMap;
import java.util.Map;

public class ConsumerPersistenceManagerService extends AbstractConsumerPersistenceManagerService<byte[]>
{

   /** . */
   private Map<String, ConsumerStateContext<byte[]>> store = new HashMap<String, ConsumerStateContext<byte[]>>();

   public PortletStateType<byte[]> getStateType() {
      return PortletStateType.OPAQUE;
   }

   protected ConsumerStateContext<byte[]> get(String stateId)
   {
      return store.get(stateId);
   }

   protected void put(String stateId, ConsumerStateContext<byte[]> state)
   {
      store.put(stateId, state);
   }

   protected void remove(String stateId)
   {
      store.remove(stateId);
   }

   protected int size()
   {
      return store.size();
   }
}
