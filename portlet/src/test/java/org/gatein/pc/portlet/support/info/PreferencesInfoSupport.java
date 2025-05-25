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

import org.gatein.pc.api.info.PreferenceInfo;
import org.gatein.pc.api.info.PreferencesInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PreferencesInfoSupport implements PreferencesInfo
{

   private final Map preferences;

   public PreferencesInfoSupport(Map preferences)
   {
      this.preferences = preferences;
   }

   public PreferencesInfoSupport()
   {
      this(new HashMap());
   }

   public Set getKeys()
   {
      return preferences.keySet();
   }

   public PreferenceInfo getPreference(String key) throws IllegalArgumentException
   {
      return (PreferenceInfo)preferences.get(key);
   }

   public void addPreference(PreferenceInfoSupport preference)
   {
      preferences.put(preference.getKey(), preference);
   }

   public void addPreference(String key)
   {
      preferences.put(key, new PreferenceInfoSupport(key));
   }

   public void addPreference(String key, Boolean readOnly)
   {
      preferences.put(key, new PreferenceInfoSupport(key, readOnly));
   }
}
