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
package org.gatein.pc.portlet.impl.jsr168.api;

import org.gatein.pc.api.WindowState;
import org.gatein.common.util.Tools;
import org.gatein.pc.api.spi.PortalContext;
import org.gatein.pc.portlet.impl.jsr168.PortletUtils;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * todo : does not provide customizable values for portlet modes and window states.
 *
 */
public class PortalContextImpl implements javax.portlet.PortalContext
{

   private PortalContext portal;
   private Map properties;
   private Set supportedPortletModes;
   private Set supportedWindowStates;

   public PortalContextImpl(PortalContext portal)
   {
      if (portal == null)
      {
         throw new IllegalArgumentException("Must provide a non-null PortalContext!");
      }
      this.portal = portal;
      this.properties = portal.getProperties();
   }

   public String getPortalInfo()
   {
      return portal.getInfo();
   }

   public String getProperty(String name)
   {
      if (name == null)
      {
         throw new IllegalArgumentException("Must provide a non-null property name");
      }
      return (String)properties.get(name);
   }

   public Enumeration getPropertyNames()
   {
      return Tools.toEnumeration(properties.keySet().iterator());
   }

   public Enumeration getSupportedPortletModes()
   {
      if (supportedPortletModes == null)
      {
         Set tmp = portal.getModes();
         supportedPortletModes = new HashSet(tmp.size());
         for (Iterator i = tmp.iterator(); i.hasNext();)
         {
            org.gatein.pc.api.Mode mode = (org.gatein.pc.api.Mode)i.next();
            supportedPortletModes.add(PortletUtils.decodePortletMode(mode.toString()));
         }
      }
      return Tools.toEnumeration(supportedPortletModes.iterator());
   }

   public Enumeration getSupportedWindowStates()
   {
      if (supportedWindowStates == null)
      {
         Set tmp = portal.getWindowStates();
         supportedWindowStates = new HashSet(tmp.size());
         for (Iterator i = tmp.iterator(); i.hasNext();)
         {
            WindowState windowState = (WindowState)i.next();
            supportedWindowStates.add(PortletUtils.decodeWindowState(windowState.toString()));
         }
      }
      return Tools.toEnumeration(supportedWindowStates.iterator());
   }
}
