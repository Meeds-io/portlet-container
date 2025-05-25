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
package org.gatein.pc.api;

import java.util.Map;

public interface ContainerURL
{
   /**
    * Returns the mode that may be null.
    *
    * @return the mode
    */
   Mode getMode();

   /**
    * Returns the window state that may be null.
    *
    * @return the window state
    */
   WindowState getWindowState();

   /**
    * Return the navigational state that may be null.
    *
    * @return the navigational state
    */
   StateString getNavigationalState();

   /**
    * Returns a set of properties associated with this URL. The returned map cannot be modified.
    *
    * @return the property map
    */
   Map<String, String> getProperties();

}
