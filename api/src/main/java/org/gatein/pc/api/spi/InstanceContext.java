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
package org.gatein.pc.api.spi;

import org.gatein.pc.api.StateEvent;
import org.gatein.pc.api.PortletStateType;
import org.gatein.pc.api.state.AccessMode;

public interface InstanceContext
{
   /**
    * Return an id that can differenciate instances.
    *
    * @return the instance id
    */
   String getId();

   /**
    * Return the access mode to this portlet instance.
    *
    * @return the access mode
    */
   AccessMode getAccessMode();

   /**
    * A state event occured.
    *
    * @param event the event
    */
   void onStateEvent(StateEvent event);

   /**
    * Returns the state type managed by the consumer. If the consumer cannot manage
    * state by itself, then null must be returned.
    *
    * @return the consumer state type
    */
   PortletStateType<?> getStateType();
}
