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

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;

@XmlType(name = "event-definition-referenceType", propOrder={"name", "qname"})
public class EventDefinitionReferenceMetaData
{

   /** The reference id */
   private String id;

   /** The qname */
   private QName qname;
   
   /** The name */
   private String name;
   
   public EventDefinitionReferenceMetaData() {}
   
   public EventDefinitionReferenceMetaData(String id)
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
}
