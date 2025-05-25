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
package org.gatein.pc.portlet.impl.spi;

import org.gatein.pc.api.state.AccessMode;
import org.gatein.pc.api.PortletContext;
import org.gatein.pc.api.StateEvent;
import org.gatein.pc.api.PortletStateType;
import org.gatein.pc.api.spi.InstanceContext;

public class AbstractInstanceContext implements InstanceContext
{

   /** . */
   private final String id;

   /** . */
   private final AccessMode accessMode;

   /** . */
   private PortletContext clonedContext;

   /** . */
   private PortletContext modifiedContext;

   public AbstractInstanceContext(String id)
   {
      this(id, AccessMode.READ_ONLY);
   }

   public AbstractInstanceContext(String id, AccessMode accessMode)
   {
      if (id == null)
      {
         throw new IllegalArgumentException();
      }
      if (accessMode == null)
      {
         throw new IllegalArgumentException();
      }

      //
      this.id = id;
      this.accessMode = accessMode;
   }

   public String getId()
   {
      return id;
   }

   public AccessMode getAccessMode()
   {
      return accessMode;
   }

   public void onStateEvent(StateEvent event)
   {
      switch (event.getType())
      {
         case PORTLET_CLONED_EVENT:
            clonedContext = event.getPortletContext();
            break;
         case PORTLET_MODIFIED_EVENT:
            modifiedContext = event.getPortletContext();
            break;
      }
   }

   public PortletContext getClonedContext()
   {
      return clonedContext;
   }

   public PortletContext getModifiedContext()
   {
      return modifiedContext;
   }

   public PortletStateType<?> getStateType() {
      return null;
   }
}
