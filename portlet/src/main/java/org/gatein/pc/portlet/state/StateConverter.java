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
package org.gatein.pc.portlet.state;

import org.gatein.pc.portlet.state.producer.PortletState;
import org.gatein.pc.api.PortletStateType;

import java.io.Serializable;

public interface StateConverter
{
   /**
    * Marshall the producer state as a byte array.
    *
    * @param stateType the state type
    * @param state the producer state
    * @return the marshalled state
    * @throws StateConversionException if marshalling cannot be performed
    * @throws IllegalArgumentException if the state is null
    */
   <S extends Serializable> S marshall(PortletStateType<S> stateType, PortletState state) throws StateConversionException, IllegalArgumentException;

   /**
    * Unmarshall the producer state from a byte array.
    *
    * @param stateType the state type
    * @param marshalledState the marshalled state
    * @return the producer state
    * @throws StateConversionException if unmarshalling cannot be performed
    * @throws IllegalArgumentException if the argument is null
    */
   <S extends Serializable> PortletState unmarshall(PortletStateType<S> stateType, S marshalledState) throws StateConversionException, IllegalArgumentException;
}
