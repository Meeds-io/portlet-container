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

import java.util.Map;
import java.util.List;

public interface PropertyMap extends Map<String, List<String>>
{
   /**
    * Return the value for the given key or null if it does not exist.
    *
    * @param key the requested key
    * @return the requested value or null if it does not exist
    * @throws IllegalArgumentException if the key is null
    */
   List<String> getProperty(String key) throws IllegalArgumentException;

   /**
    * Update the value of the given key. If the value object is null it means that the entry must be removed.
    * Implementation can throw an unsupported operation exception when it is abnormal to perform an update.
    *
    * @param key   the key to update
    * @param value the new value
    * @throws UnsupportedOperationException if the operation is not supported
    * @throws IllegalArgumentException      if the key is null
    */
   void setProperty(String key, List<String> value) throws IllegalArgumentException, UnsupportedOperationException;
}
