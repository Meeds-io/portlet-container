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
package org.gatein.pc.test.portlet.jsr286.ext.dispatcher;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;

public class DispatchingFilter implements Filter
{

   private FilterConfig cfg;

   public void init(FilterConfig cfg) throws ServletException
   {
      this.cfg = cfg;
   }

   public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException
   {
      RequestDispatcher rd = req.getRequestDispatcher("/DispatchedFromFilter");
      rd.include(req, resp);
   }

   public void destroy()
   {
      this.cfg = null;
   }
}