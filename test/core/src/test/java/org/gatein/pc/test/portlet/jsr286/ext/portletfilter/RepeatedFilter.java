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
package org.gatein.pc.test.portlet.jsr286.ext.portletfilter;

import javax.portlet.filter.FilterConfig;
import javax.portlet.filter.RenderFilter;
import javax.portlet.filter.FilterChain;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;
import java.util.Set;
import java.util.HashSet;

public class RepeatedFilter implements RenderFilter
{

   /** . */
   public static final Set<String> names = new HashSet<String>();

   public void init(FilterConfig config) throws PortletException
   {
   }

   public void doFilter(RenderRequest req, RenderResponse resp, FilterChain chain) throws IOException, PortletException
   {
      chain.doFilter(req, resp);
      String name = (String)req.getAttribute("NAME");
      if (name != null)
      {
         names.add(name);
      }
   }

   public void destroy()
   {
   }
}
