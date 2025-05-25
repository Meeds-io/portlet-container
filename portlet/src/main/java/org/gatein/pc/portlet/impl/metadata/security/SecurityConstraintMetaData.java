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
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.gatein.common.i18n.LocalizedString;
import org.gatein.pc.portlet.impl.metadata.adapter.LocalizedStringAdapter;

@XmlType(name = "security-constraintType", propOrder={"displayName", "portletList", "userDataConstraint"})
public class SecurityConstraintMetaData
{

   /** The security constraint id */
   private String id;

   /** The security constraint display name */
   private LocalizedString displayName;

   /** The portlet collection */
   private PortletCollectionMetaData portletList;

   /** The user data constraints */
   private UserDataConstraintMetaData userDataConstraint;
   
   public SecurityConstraintMetaData() {}
   
   public SecurityConstraintMetaData(String id)
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

   @XmlElement(name = "portlet-collection")
   public PortletCollectionMetaData getPortletList()
   {
      return portletList;
   }

   public void setPortletList(PortletCollectionMetaData portletList)
   {
      this.portletList = portletList;
   }

   @XmlElement(name = "user-data-constraint")
   public UserDataConstraintMetaData getUserDataConstraint()
   {
      return userDataConstraint;
   }

   public void setUserDataConstraint(UserDataConstraintMetaData userDataConstraint)
   {
      this.userDataConstraint = userDataConstraint;
   }
}
