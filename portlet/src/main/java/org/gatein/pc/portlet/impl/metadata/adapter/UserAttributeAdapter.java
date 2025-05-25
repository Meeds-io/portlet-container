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
package org.gatein.pc.portlet.impl.metadata.adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.gatein.pc.portlet.impl.metadata.UserAttributeMetaData;

public class UserAttributeAdapter
      extends XmlAdapter<List<UserAttributeMetaData>, Map<String, UserAttributeMetaData>>
{

   @Override
   public List<UserAttributeMetaData> marshal(Map<String, UserAttributeMetaData> arg0) throws Exception
   {
      throw new UnsupportedOperationException();
   }

   @Override
   public Map<String, UserAttributeMetaData> unmarshal(List<UserAttributeMetaData> list) throws Exception
   {
      HashMap<String, UserAttributeMetaData> m = new HashMap<String, UserAttributeMetaData>();
      for (UserAttributeMetaData a : list)
      {
         String userAttributeName = a.getName();
         if (!m.containsKey(userAttributeName))
         {
            m.put(a.getName(), a);
         }
         else
         {
            throw new IllegalArgumentException("Duplicate user-attribute: " + userAttributeName);
         }
      }
      return m;
   }

}
