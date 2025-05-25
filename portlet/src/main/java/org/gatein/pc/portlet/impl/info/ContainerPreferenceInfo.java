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
package org.gatein.pc.portlet.impl.info;

import org.gatein.common.i18n.LocalizedString;
import org.gatein.pc.api.info.PreferenceInfo;

import java.util.List;

public class ContainerPreferenceInfo implements PreferenceInfo
{

   private String key;
   private LocalizedString displayName;
   private LocalizedString description;
   private Boolean readOnly;
   private List<String> value;

   public ContainerPreferenceInfo(String key, LocalizedString displayName, LocalizedString description, boolean readOnly, List<String> value)
   {
      this.key = key;
      this.displayName = displayName;
      this.description = description;
      this.readOnly = Boolean.valueOf(readOnly);
      this.value = value;
   }

   public String getKey()
   {
      return key;
   }

   public LocalizedString getDisplayName()
   {
      return displayName;
   }

   public LocalizedString getDescription()
   {
      return description;
   }

   public Boolean isReadOnly()
   {
      return readOnly;
   }

   /**
    * Return the value provided by the portlet.xml deployment descriptor.
    *
    * @return the preference value associated with this preference meta data
    */
   public List<String> getDefaultValue()
   {
      return value;
   }
}