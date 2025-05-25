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

import org.gatein.pc.test.portlet.jsr286.common.AbstractRenderFilter;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.PortletException;
import javax.portlet.filter.FilterChain;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Enumeration;

public class FilterConfigFilter extends AbstractRenderFilter
{

   /** . */
   public static String name;

   /** . */
   public static Map<String, String> parameters;

   public void init(javax.portlet.filter.FilterConfig config) throws PortletException
   {
      super.init(config);

      //
      HashMap<String, String> tmp = new HashMap<String, String>();
      for (Enumeration e = config.getInitParameterNames();e.hasMoreElements();)
      {
         String name = (String)e.nextElement();
         String value = config.getInitParameter(name);
         tmp.put(name, value);
      }

      //
      name = config.getFilterName();
      parameters = tmp;
   }

   public void doFilter(RenderRequest req, RenderResponse resp, FilterChain chain) throws IOException, PortletException
   {
      chain.doFilter(req, resp);
   }
}
