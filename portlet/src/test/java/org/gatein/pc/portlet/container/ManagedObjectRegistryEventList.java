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
package org.gatein.pc.portlet.container;

import junit.framework.Assert;
import org.gatein.pc.portlet.container.managed.ManagedObjectFailedEvent;
import org.gatein.pc.portlet.container.managed.ManagedObjectRegistryEventListener;
import org.gatein.pc.portlet.container.managed.ManagedObjectRegistryEvent;
import org.gatein.pc.portlet.container.managed.ManagedObject;
import org.gatein.pc.portlet.container.managed.ManagedObjectAddedEvent;
import org.gatein.pc.portlet.container.managed.LifeCycleStatus;
import org.gatein.pc.portlet.container.managed.ManagedObjectLifeCycleEvent;

import java.util.LinkedList;

public class ManagedObjectRegistryEventList implements ManagedObjectRegistryEventListener
{

   /** . */
   final LinkedList<ManagedObjectRegistryEvent> list = new LinkedList<ManagedObjectRegistryEvent>();

   public void onEvent(ManagedObjectRegistryEvent event)
   {
      list.add(event);
   }

   public void assertAddedEvent(ManagedObject managedObject)
   {
      ManagedObjectAddedEvent event = nextEvent(ManagedObjectAddedEvent.class);
      Assert.assertSame(managedObject, event.getManagedObject());
   }

   public void assertCreatedEvent(ManagedObject managedObject)
   {
      assertLifeCycleEvent(managedObject, LifeCycleStatus.CREATED);
   }

   public void assertStartedEvent(ManagedObject managedObject)
   {
      assertLifeCycleEvent(managedObject, LifeCycleStatus.STARTED);
   }

   public void assertStoppedEvent(ManagedObject managedObject)
   {
      assertLifeCycleEvent(managedObject, LifeCycleStatus.CREATED);
   }

   public void assertDestroyedEvent(ManagedObject managedObject)
   {
      assertLifeCycleEvent(managedObject, LifeCycleStatus.INITIALIZED);
   }

   public void assertFailedEvent(ManagedObject managedObject)
   {
      ManagedObjectFailedEvent event = nextEvent(ManagedObjectFailedEvent.class);
      Assert.assertSame(managedObject, event.getManagedObject());
   }

   public void assertLifeCycleEvent(ManagedObject managedObject, LifeCycleStatus status)
   {
      ManagedObjectLifeCycleEvent event = nextEvent(ManagedObjectLifeCycleEvent.class);
      Assert.assertSame(managedObject, event.getManagedObject());
      Assert.assertEquals(status, event.getStatus());
   }

   public void assertEmpty()
   {
      Assert.assertTrue("Was expecting " + list + " to be empty", list.isEmpty());
   }

   public void clear()
   {
      list.clear();
   }

   private <T extends ManagedObjectRegistryEvent> T nextEvent(Class<T> type)
   {
      Assert.assertFalse(list.isEmpty());
      ManagedObjectRegistryEvent first = list.removeFirst();
      Assert.assertTrue(type.isInstance(first));
      return type.cast(first);
   }
}
