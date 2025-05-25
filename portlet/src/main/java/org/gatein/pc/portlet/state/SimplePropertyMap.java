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

import org.gatein.pc.api.state.PropertyMap;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class SimplePropertyMap extends AbstractPropertyMap<String, List<String>>
{

   private static final Converter<String, String> KEY_CONVERTER = new Converter<String, String>()
   {
      protected String getInternal(String s) throws IllegalArgumentException, ClassCastException
      {
         return s;
      }
      protected String getExternal(String s)
      {
         return s;
      }
      protected boolean equals(String s, String s1)
      {
         return s.equals(s1);
      }
   };

   private static Converter<List<String>, List<String>> VALUE_CONVERTER = new Converter<List<String>, List<String>>()
   {
      protected List<String> getInternal(List<String> value) throws IllegalArgumentException, ClassCastException
      {
         return value;
      }
      protected List<String> getExternal(List<String> value)
      {
         return value;
      }
      protected boolean equals(List<String> value, List<String> value1)
      {
         return value.equals(value1);
      }
   };

   public SimplePropertyMap()
   {
      this(new HashMap<String, List<String>>());
   }

   public SimplePropertyMap(int size)
   {
      this(new HashMap<String, List<String>>(size));
   }

   public SimplePropertyMap(PropertyMap that)
   {
      this(new HashMap<String, List<String>>());

      //
      if (that == null)
      {
         throw new IllegalArgumentException();
      }

      //
      putAll(that);
   }

   public SimplePropertyMap(Map<String, List<String>> map)
   {
      super(map, KEY_CONVERTER, VALUE_CONVERTER);
   }
}
