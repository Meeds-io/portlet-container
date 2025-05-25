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
package org.gatein.pc.portlet.impl.metadata.security;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.gatein.pc.api.TransportGuarantee;
import org.gatein.pc.portlet.impl.metadata.common.DescribableMetaData;

@XmlType(name = "user-data-constraint", propOrder={"description", "transportGuarantee"})
public class UserDataConstraintMetaData extends DescribableMetaData
{

   /** The user data constraint id */
   private String id;

   /** The user transport quarantee */
   private TransportGuarantee transportQuarantee;
   
   public UserDataConstraintMetaData() {}
   
   public UserDataConstraintMetaData(String id)
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

   @XmlElement(name = "transport-guarantee")
   public TransportGuarantee getTransportGuarantee()
   {
      return transportQuarantee;
   }

   public void setTransportGuarantee(TransportGuarantee transportQuarantee)
   {
      this.transportQuarantee = transportQuarantee;
   }
}