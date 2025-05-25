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
package org.gatein.pc.management;

import org.gatein.pc.api.Portlet;

public class LocalPortletManagement implements LocalPortletManagementMBean
{
   private Portlet portlet;
   
   private PortletContainerManagementInterceptor interceptor;
   
   public LocalPortletManagement(Portlet portlet, PortletContainerManagementInterceptor interceptor)
   {
      this.portlet = portlet;
      this.interceptor = interceptor;
   }
   
   public String getId()
   {
      return portlet.getContext().getId();
   }

   public float getAverageRenderTime()
   {
      return interceptor.getPortletInfo(getId()).getAverageRenderTime();
   }

   public float getAverageActionTime()
   {
      return interceptor.getPortletInfo(getId()).getAverageActionTime();
   }

   public long getMaxRenderTime()
   {
      return interceptor.getPortletInfo(getId()).getMaxRenderTime();
   }

   public long getMaxActionTime()
   {
      return interceptor.getPortletInfo(getId()).getMaxActionTime();
   }

   public long getRenderRequestCount()
   {
      return interceptor.getPortletInfo(getId()).getRenderRequestCount();
   }

   public long getActionRequestCount()
   {
      return interceptor.getPortletInfo(getId()).getActionRequestCount();
   }
   
   public long getActionErrorCount()
   {
      return interceptor.getPortletInfo(getId()).getActionErrorCount();
   }

   public long getRenderErrorCount()
   {
      return interceptor.getPortletInfo(getId()).getRenderErrorCount();
   }
}
