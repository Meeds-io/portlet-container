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
package org.gatein.pc.api.state;

import java.util.Set;
import java.util.List;

/**
 * Exposes to the portlet the interface to deal with the personalization state.
 *
 */
public interface PropertyContext
{

   /** The attribute name under which the preferences can be accessed. */
   String PREFERENCES_ATTRIBUTE = "preferences";

   /**
    * Return an immutable set of keys.
    *
    * @return the set of keys
    */
   Set<String> getKeys();

   /**
    * Return for a specified key an immutable list of its values or null if the value does not exist.
    *
    * @param key the lookup key
    * @return the key value or null if it does not exist
    * @throws IllegalArgumentException if the key is null
    */
   List<String> getValue(String key) throws IllegalArgumentException;

   /**
    * Return true if the preferences are globally read only. The value returned by this method is valid only during
    * the action request. Any call to this method during the render request will produce a non accurate value.
    *
    * @return true if the preferences are read only
    * @throws IllegalStateException if this is called during render phase
    */
   boolean isReadOnly() throws IllegalStateException;

   /**
    * Update the preferences.
    *
    * @param changes the list of changes
    * @throws IllegalStateException    if the preferences is not writable
    * @throws IllegalArgumentException if any change is not valid
    */
   void update(PropertyChange[] changes) throws IllegalStateException;
}
