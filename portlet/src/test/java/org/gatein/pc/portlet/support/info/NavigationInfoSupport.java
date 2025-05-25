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
package org.gatein.pc.portlet.support.info;

import org.gatein.pc.api.info.NavigationInfo;
import org.gatein.pc.api.info.ParameterInfo;

import javax.xml.namespace.QName;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class NavigationInfoSupport implements NavigationInfo
{

   /** . */
   private final Map<String, ParameterInfo> publicParametersById;

   /** . */
   private final Map<QName, ParameterInfo> publicParametersByName;

   /** . */
   private final Collection<ParameterInfo> publicParameters;

   public NavigationInfoSupport()
   {
      this.publicParametersById = new HashMap<String, ParameterInfo>();
      this.publicParametersByName = new HashMap<QName, ParameterInfo>();
      this.publicParameters = Collections.unmodifiableCollection(publicParametersById.values());
   }

   public void addPublicParameter(ParameterInfo publicParameter)
   {
      if (publicParameter == null)
      {
         throw new IllegalArgumentException("no null public parameter accepted");
      }
      if (publicParametersById.containsKey(publicParameter.getId()))
      {
         throw new IllegalArgumentException("duplicate public parameter id " + publicParameter.getId());
      }
      if (publicParametersByName.containsKey(publicParameter.getName()))
      {
         throw new IllegalArgumentException("duplicate public parameter name " + publicParameter.getName());
      }

      //
      publicParametersById.put(publicParameter.getId(), publicParameter);
      publicParametersByName.put(publicParameter.getName(), publicParameter);
   }

   public ParameterInfo getPublicParameter(QName name)
   {
      if (name == null)
      {
         throw new IllegalArgumentException("No null name accepted");
      }

      //
      return publicParametersByName.get(name);
   }

   public ParameterInfo getPublicParameter(String id)
   {
      if (id == null)
      {
         throw new IllegalArgumentException("No null id accepted");
      }

      //
      return publicParametersById.get(id);
   }

   public Collection<ParameterInfo> getPublicParameters()
   {
      return publicParameters;
   }
}
