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

import org.gatein.pc.portlet.impl.metadata.PortletMetaDataConstants;

@XmlType(name = "supportsType", propOrder={"mimeType", "portletModes", "windowStates"})
public class SupportsMetaData
{

   /** The supports id */
   @XmlAttribute(name = "id")
   private String id;

   /** The mime type */
   private String mimeType;

   /** The portletModes */
   private List<PortletModeMetaData> portletModes;

   /** The window states */
   private List<WindowStateMetaData> windowStates;
   
   public SupportsMetaData() {}
   
   public SupportsMetaData(String id)
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

   @XmlElement(name = "mime-type")
   public String getMimeType()
   {
      return mimeType;
   }

   public void setMimeType(String mimeType)
   {
      this.mimeType = mimeType;
   }

   @XmlElement(name = "portlet-mode")
   public List<PortletModeMetaData> getPortletModes()
   {
      return this.portletModes;
   }

   public void setPortletModes(List<PortletModeMetaData> portletModes)
   {
      this.portletModes = portletModes;
   }
   
   public void addPortletMode(PortletModeMetaData portletMode)
   {
      if (this.portletModes == null)
      {
         this.portletModes = new ArrayList<PortletModeMetaData>();
      }
      this.portletModes.add(portletMode);
   }

   @XmlElement(name = "window-state",
         namespace = PortletMetaDataConstants.PORTLET_JSR_286_NS)
   public List<WindowStateMetaData> getWindowStates()
   {
      return this.windowStates;
   }

   public void setWindowStates(List<WindowStateMetaData> windowStates)
   {
      this.windowStates = windowStates;
   }

   public void addWindowState(WindowStateMetaData windowState)
   {
      if (this.windowStates == null)
      {
         this.windowStates = new ArrayList<WindowStateMetaData>();
      }
      this.windowStates.add(windowState);
   }
}
