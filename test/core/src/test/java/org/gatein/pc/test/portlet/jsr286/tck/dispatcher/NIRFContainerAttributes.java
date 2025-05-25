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
package org.gatein.pc.test.portlet.jsr286.tck.dispatcher;

import org.gatein.pc.test.unit.PortletTestCase;
import org.gatein.pc.test.unit.Assertion;
import org.gatein.pc.test.unit.annotations.TestCase;
import org.gatein.pc.api.LifeCyclePhase;

import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletContext;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

@TestCase({Assertion.JSR286_239})
public class NIRFContainerAttributes extends DispatchedContainerAttributes
{

   private static Map<String, String> buildAttributes()
   {
      Map<String, String> map = new HashMap<String, String>();
      map.put("jakarta.servlet.include.request_uri", null);
      map.put("jakarta.servlet.include.context_path", null);
      map.put("jakarta.servlet.include.servlet_path", null);
      map.put("jakarta.servlet.include.path_info", null);
      map.put("jakarta.servlet.include.query_string", null);
      map.put("jakarta.servlet.forward.request_uri", null);
      map.put("jakarta.servlet.forward.context_path", null);
      map.put("jakarta.servlet.forward.servlet_path", null);
      map.put("jakarta.servlet.forward.path_info", null);
      map.put("jakarta.servlet.forward.query_string", null);
      return Collections.unmodifiableMap(map);
   }

   private static Map<String, String> buildInfo(ServletContext ctx)
   {
      Map<String, String> map = new HashMap<String, String>();
      map.put("request_uri", null);
      map.put("context_path", ctx.getContextPath());
      map.put("servlet_path", null);
      map.put("path_info", null);
      map.put("query_string", null);
      return Collections.unmodifiableMap(map);
   }

   public NIRFContainerAttributes(PortletTestCase seq)
   {
      super(seq, buildAttributes(), buildInfo(seq.getContext()));
   }

   protected boolean performTest(LifeCyclePhase phase)
   {
      return phase != LifeCyclePhase.ACTION && phase != LifeCyclePhase.EVENT;
   }

   protected void dispatch(PortletRequest request, PortletResponse response, PortletContext portletContext) throws IOException, PortletException
   {
      PortletRequestDispatcher dispatcher = portletContext.getNamedDispatcher("RequestForwardHopServlet");
      dispatcher.include(request, response);
   }
}