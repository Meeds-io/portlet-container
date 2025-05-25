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

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

/**
 * A property change. The class is immutable
 *
 */
public class PropertyChange
{

   /** The change is an update of the property value. */
   public static final int PREF_UPDATE = 0;

   /** The change is a reset of the property value. */
   public static final int PREF_RESET = 1;

   /** The key. */
   private final String key;

   /** The immutable value. */
   private final List<String> value;

   /**
    * Create a new property update, the list of values will be clone for safety.
    *
    * @param key   the property key
    * @param value the property value
    * @return an instance representing a property update
    */
   public static PropertyChange newUpdate(String key, String value)
   {
      return new PropertyChange(key, Collections.singletonList(value));
   }

   /**
    * Create a new property update, the list of values will be clone for safety.
    *
    * @param key   the property key
    * @param value the property value
    * @return an instance representing a property update
    */
   public static PropertyChange newUpdate(String key, String[] value)
   {
      if (value == null)
      {
         throw new IllegalArgumentException("No value provided");
      }
      return new PropertyChange(key, Collections.unmodifiableList(Arrays.asList(value.clone())));
   }

   /**
    * Create a new property update, the list of values will be clone for safety.
    *
    * @param key   the property key
    * @param value the property value
    * @return an instance representing a property update
    */
   public static PropertyChange newUpdate(String key, List<String> value)
   {
      if (value == null)
      {
         throw new IllegalArgumentException("No value provided");
      }
      return new PropertyChange(key, Collections.unmodifiableList(new ArrayList<String>(value)));
   }

   /**
    * Create a new property reset.
    *
    * @param key the property key
    * @return an instance representing a property reset
    */
   public static PropertyChange newReset(String key)
   {
      return new PropertyChange(key, null);
   }

   private PropertyChange(String key, List<String> value)
   {
      if (key == null)
      {
         throw new IllegalArgumentException("No key provided");
      }
      this.key = key;
      this.value = value;
   }

   /**
    * Return the property change type.
    *
    * @return the property change type
    */
   public int getType()
   {
      return value == null ? PREF_RESET : PREF_UPDATE;
   }

   /**
    * Return the property key
    *
    * @return the property key
    */
   public String getKey()
   {
      return key;
   }

   /**
    * Return the new value or null in case of a property reset.
    *
    * @return the property value
    */
   public List<String> getValue()
   {
      return value;
   }
}
