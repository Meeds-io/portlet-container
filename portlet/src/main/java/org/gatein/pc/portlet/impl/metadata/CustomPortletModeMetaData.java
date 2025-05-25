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

import org.gatein.pc.portlet.impl.metadata.common.DescribableMetaData;
import org.gatein.pc.portlet.impl.metadata.PortletMetaDataConstants;

@XmlType(name = "custom-portlet-modeType", propOrder={"description", "portletMode", "portalManaged"})
public class CustomPortletModeMetaData extends DescribableMetaData
{

   /** The custom portlet mode id*/
   private String id;

   /** The portlet mode */
   private String portletMode;

   /** Is portal managed */
   private boolean portalManaged = true;

   public CustomPortletModeMetaData() {}
   
   public CustomPortletModeMetaData(String id)
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

   @XmlElement(name = "portlet-mode")
   public String getPortletMode()
   {
      return portletMode;
   }

   public void setPortletMode(String portletMode)
   {
      this.portletMode = portletMode;
   }

   @XmlElement(name = "portal-managed", namespace = PortletMetaDataConstants.PORTLET_JSR_286_NS)
   public boolean isPortalManaged()
   {
      return portalManaged;
   }

   public void setPortalManaged(boolean portalManaged)
   {
      this.portalManaged = portalManaged;
   }
   
}
