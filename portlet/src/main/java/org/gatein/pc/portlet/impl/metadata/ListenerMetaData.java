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
package org.gatein.pc.portlet.impl.metadata;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.gatein.common.i18n.LocalizedString;
import org.gatein.pc.portlet.impl.metadata.adapter.LocalizedStringAdapter;
import org.gatein.pc.portlet.impl.metadata.common.DescribableMetaData;

@XmlType(name = "listenerType", propOrder={"description", "displayName", "listenerClass"})
public class ListenerMetaData extends DescribableMetaData
{

   /** The id */
   private String id;
   
   /** The display name */
   private LocalizedString displayName;
   
   /** The listener class */
   private String listenerClass;

   public ListenerMetaData() {}
   
   public ListenerMetaData(String id)
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

   @XmlElement(name = "display-name")
   @XmlJavaTypeAdapter(LocalizedStringAdapter.class)
   public LocalizedString getDisplayName()
   {
      return displayName;
   }

   public void setDisplayName(LocalizedString displayName)
   {
      this.displayName = displayName;
   }

   @XmlElement(name = "listener-class")
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   public String getListenerClass()
   {
      return listenerClass;
   }

   public void setListenerClass(String listenerClass)
   {
      this.listenerClass = listenerClass;
   }
   
}

