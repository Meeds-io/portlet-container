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

import org.gatein.common.util.TypedMap;
import org.gatein.pc.api.state.PropertyMap;

import java.util.Map;
import java.util.List;

public class AbstractPropertyMap<IK, IV> extends TypedMap<String, List<String>, IK, IV> implements PropertyMap
{

   public AbstractPropertyMap(Map<IK, IV> map, Converter<String, IK> keyConverter, Converter<List<String>, IV> valueConverter)
   {
      super(map, keyConverter, valueConverter);
   }

   public List<String> getProperty(String key) throws IllegalArgumentException
   {
      if (key == null)
      {
         throw new IllegalArgumentException("No null key accepted");
      }
      return get(key);
   }

   public void setProperty(String key, List<String> value) throws IllegalArgumentException
   {
      if (key == null)
      {
         throw new IllegalArgumentException("No null key accepted");
      }
      if (value != null)
      {
         put(key, value);
      }
      else
      {
         remove(key);
      }
   }
}
