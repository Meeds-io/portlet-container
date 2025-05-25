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
package org.gatein.pc.portlet.impl.metadata.event;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;

import org.gatein.pc.portlet.impl.metadata.common.DescribableMetaData;

@XmlType(name = "event-definitionType", propOrder={"description", "qname", "name", "alias", "valueType"})
public class EventDefinitionMetaData extends DescribableMetaData
{
   /** The event definition id */
   private String id;

   /** The QName */
   private QName qname;
   
   /** The name */
   private String name;

   /** The value-type */
   private String valueType;

   /** The alias */
   private List<QName> alias;
   
   public EventDefinitionMetaData() {}
   
   public EventDefinitionMetaData(String id)
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

   @XmlElement(name = "qname")
   public QName getQname()
   {
      return qname;
   }

   public void setQname(QName qname)
   {
      this.qname = qname;
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
   
   @XmlElement(name = "value-type")
   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
   public String getValueType()
   {
      return valueType;
   }

   public void setValueType(String valueType)
   {
      this.valueType = valueType;
   }

   @XmlElement(name = "alias")
   public List<QName> getAlias()
   {
      return alias;
   }

   public void setAlias(List<QName> alias)
   {
      this.alias = alias;
   }
   
   public void addAlias(QName alias)
   {
      if (this.alias == null)
      {
         this.alias = new ArrayList<QName>();
      }
      this.alias.add(alias);
   }
}
