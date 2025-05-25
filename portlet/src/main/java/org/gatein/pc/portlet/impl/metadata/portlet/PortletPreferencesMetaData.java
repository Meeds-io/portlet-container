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
package org.gatein.pc.portlet.impl.metadata.portlet;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.gatein.pc.portlet.impl.metadata.adapter.PortletPreferencesListAdapter;

@XmlType(name = "portlet-preferencesType", propOrder={"portletPreferences", "preferenceValidator"})
public class PortletPreferencesMetaData
{

   /** The portlet preferences id */
   private String id;

   /** The portlet preferences */
   private Map<String, PortletPreferenceMetaData> portletPreferences;

   /** The portlet preference validator */
   private String preferenceValidator;

   public PortletPreferencesMetaData() {}
   
   public PortletPreferencesMetaData(String id)
   {
      this.id = id;
   }
   
   @XmlAttribute(name = "id")
   public String getId()
   {
      return id;
   }

   public void setId(String id)
   {
      this.id = id;
   }

   @XmlElement(name = "preference")
   @XmlJavaTypeAdapter(PortletPreferencesListAdapter.class)
   public Map<String, PortletPreferenceMetaData> getPortletPreferences()
   {
      return portletPreferences;
   }

   public void setPortletPreferences(Map<String, PortletPreferenceMetaData> portletPreferences)
   {
      this.portletPreferences = portletPreferences;
   }
   
   public void addPortletPreference(PortletPreferenceMetaData preference)
   {
      if(this.portletPreferences == null)
      {
         this.portletPreferences = new HashMap<String, PortletPreferenceMetaData>();
      }
      this.portletPreferences.put(preference.getName(), preference);
   }

   @XmlElement(name = "preferences-validator")
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   public String getPreferenceValidator()
   {
      return preferenceValidator;
   }

   public void setPreferenceValidator(String preferenceValidator)
   {
      this.preferenceValidator = preferenceValidator;
   }

}
