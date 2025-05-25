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
package org.gatein.pc.portlet.impl.metadata.common;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

import org.gatein.pc.portlet.impl.metadata.PortletMetaDataConstants;

@XmlType(name = "descriptionType")
public class LocalizedDescriptionMetaData
{

   /** The lang */
   private String lang = "en";

   /** The description */
   private String description;
   
   public LocalizedDescriptionMetaData() {}
   
   public LocalizedDescriptionMetaData(String lang)
   {
      this.lang = lang;
   }

   @XmlAttribute(name = "lang", 
         namespace = PortletMetaDataConstants.NS_XML_NAMESPACE)
   public String getLang()
   {
      return this.lang;
   }

   public void setLang(String lang)
   {
      this.lang = lang;
   }

   @XmlValue
   public String getDescription()
   {
      return description;
   }

   public void setDescription(String description)
   {
      this.description = description;
   }

}
