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
package org.gatein.pc.portlet.impl.metadata.filter;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "filter-mappingType", propOrder={"name", "portletNames"})
public class FilterMappingMetaData
{

   /** The filter name */
   private String name;

   /** The mapped portlet names */
   private List<String> portletNames;

   @XmlElement(name = "filter-name")
   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   @XmlElement(name = "portlet-name")
   public List<String> getPortletNames()
   {
      return portletNames;
   }

   public void setPortletNames(List<String> portletNames)
   {
      this.portletNames = portletNames;
   }
   
   public void addPortletName(String portletName)
   {
      if( this.portletNames == null)
      {
         this.portletNames = new ArrayList<String>();
      }
      this.portletNames.add(portletName);
   }

}
