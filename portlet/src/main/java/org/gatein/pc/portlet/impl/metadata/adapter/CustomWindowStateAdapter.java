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

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.gatein.pc.portlet.impl.metadata.CustomWindowStateMetaData;

public class CustomWindowStateAdapter extends XmlAdapter<List<CustomWindowStateMetaData>, Map<String, CustomWindowStateMetaData>>
{

   @Override
   public List<CustomWindowStateMetaData> marshal(Map<String, CustomWindowStateMetaData> map) throws Exception
   {
      throw new UnsupportedOperationException();
   }

   @Override
   public Map<String, CustomWindowStateMetaData> unmarshal(List<CustomWindowStateMetaData> list) throws Exception
   {
      Map<String, CustomWindowStateMetaData> map = new LinkedHashMap<String, CustomWindowStateMetaData>();
      for(CustomWindowStateMetaData md : list)
      {
         map.put(md.getWindowState(), md);
      }
      return map;
   }

}

