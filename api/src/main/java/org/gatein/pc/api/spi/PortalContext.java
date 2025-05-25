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

import org.gatein.pc.api.WindowState;

import java.util.Map;
import java.util.Set;

/**
 * Represent the context of the portal that performs the invocation.
 *
 */
public interface PortalContext
{

   /**
    * Return info about the portal. Must conform to javax.portlet.PortalContext.getPortalInfo().
    *
    * @return portal infos
    */
   String getInfo();

   /**
    * Return the window states accepted by this portal context.
    *
    * @return the window states
    */
   Set<WindowState> getWindowStates();

   /**
    * Return the modes accepted by this portal context.
    *
    * @return the modes
    */
   Set<org.gatein.pc.api.Mode> getModes();

   /**
    * Return the set of properties of this portal context.
    *
    * @return the properties
    */
   Map<String, String> getProperties();

}
