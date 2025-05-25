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

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "portlet-preferenceType", propOrder={"name", "value", "readOnly"})
public class PortletPreferenceMetaData
{

   /** The portlet preference id */
   private String id;

   /** The portlet preference name */
   private String name;

   /** The portlet preference value */
   private List<String> value;

   /** Is read only */
   private boolean readOnly;
   
   public PortletPreferenceMetaData() {}
   
   public PortletPreferenceMetaData(String id)
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

   @XmlElement(name = "name")
   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   @XmlElement(name = "value")
   public List<String> getValue()
   {
      return value;
   }

   public void setValue(List<String> value)
   {
      this.value = value;
   }
   
   public void addValue(String value)
   {
      if (this.value == null)
      {
         this.value = new ArrayList<String>();
      }
      this.value.add(value);
   }

   @XmlElement(name = "read-only")
   public boolean isReadOnly()
   {
      return readOnly;
   }

   public void setReadOnly(boolean readOnly)
   {
      this.readOnly = readOnly;
   }

}
