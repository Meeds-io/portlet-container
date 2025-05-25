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

import org.gatein.pc.portlet.impl.info.ContainerFilterInfo;

import javax.portlet.filter.FilterConfig;
import javax.portlet.PortletContext;
import java.util.Enumeration;
import java.util.Collections;

public class FilterConfigImpl implements FilterConfig
{

   /** . */
   private final ContainerFilterInfo filterInfo;

   /** . */
   private final PortletContext context;

   public FilterConfigImpl(ContainerFilterInfo filterInfo, PortletContext context)
   {
      this.filterInfo = filterInfo;
      this.context = context;
   }

   public String getFilterName()
   {
      return filterInfo.getName();
   }

   public PortletContext getPortletContext()
   {
      return context;
   }

   public String getInitParameter(String name)
   {
      if (name != null)
      {
         return filterInfo.getParameters().get(name);
      }
      else
      {
         return null;
      }
   }

   public Enumeration getInitParameterNames()
   {
      return Collections.enumeration(filterInfo.getParameters().keySet());
   }
}
