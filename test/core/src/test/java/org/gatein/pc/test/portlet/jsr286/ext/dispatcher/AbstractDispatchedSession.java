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

import org.gatein.pc.test.unit.PortletTestCase;
import org.gatein.pc.test.unit.PortletTestContext;
import org.gatein.pc.test.unit.JoinPoint;
import org.gatein.pc.test.unit.web.AbstractUniversalTestPortlet;
import org.gatein.pc.test.unit.actions.ServletServiceTestAction;
import org.gatein.pc.test.unit.actions.PortletRenderTestAction;
import org.gatein.pc.test.unit.web.UTS1;
import org.gatein.pc.test.unit.protocol.response.Response;
import org.gatein.pc.test.unit.protocol.response.EndTestResponse;
import static org.gatein.pc.test.unit.Assert.*;
import org.gatein.pc.test.unit.protocol.response.InvokeGetResponse;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import javax.portlet.PortletException;
import javax.portlet.RenderResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.PortletSession;
import java.io.IOException;

public abstract class AbstractDispatchedSession
{
   public AbstractDispatchedSession(
      PortletTestCase seq,
      JoinPoint portletJoinPoint,
      final int sessionScope)
   {
      seq.bindAction(0, portletJoinPoint, new PortletRenderTestAction()
      {
         protected Response run(Portlet portlet, RenderRequest request, RenderResponse response, PortletTestContext context) throws PortletException, IOException
         {
            PortletRequestDispatcher dispatcher = ((AbstractUniversalTestPortlet)portlet).getPortletContext().getNamedDispatcher("UniversalServletA");
            assertNotNull(dispatcher);
            dispatcher.include(request, response);

            //
            PortletSession session = request.getPortletSession(false);
            assertNotNull(session);
            assertTrue(session.isNew());
            Object value = session.getAttribute("foo", sessionScope);
            assertEquals("foo_dispatched_value", value);

            //
            return new InvokeGetResponse(response.createRenderURL().toString());
         }
      });
      seq.bindAction(0, UTS1.SERVICE_JOIN_POINT, new ServletServiceTestAction()
      {
         public Response execute(Servlet servlet, HttpServletRequest request, HttpServletResponse response, PortletTestContext context) throws ServletException, IOException
         {
            HttpSession session = request.getSession(false);
            assertNull(session);

            //
            session = request.getSession();
            assertNotNull(session);
            assertTrue(session.isNew());
            session.setAttribute("foo", "foo_dispatched_value");
            assertEquals("foo_dispatched_value", session.getAttribute("foo"));

            //
            return null;
         }
      });
      seq.bindAction(1, portletJoinPoint, new PortletRenderTestAction()
      {
         protected Response run(Portlet portlet, RenderRequest request, RenderResponse response, PortletTestContext context) throws PortletException, IOException
         {
            PortletSession session = request.getPortletSession(false);
            assertNotNull(session);
            assertFalse(session.isNew());
            assertEquals("foo_dispatched_value", session.getAttribute("foo", sessionScope));

            //
            PortletRequestDispatcher dispatcher = ((AbstractUniversalTestPortlet)portlet).getPortletContext().getNamedDispatcher("UniversalServletA");
            assertNotNull(dispatcher);
            dispatcher.include(request, response);

            //
            try
            {
               session.isNew();
               fail();
            }
            catch (IllegalStateException ignore)
            {
            }

            //
            return new EndTestResponse();
         }
      });
      seq.bindAction(1, UTS1.SERVICE_JOIN_POINT, new ServletServiceTestAction()
      {
         public Response execute(Servlet servlet, HttpServletRequest request, HttpServletResponse response, PortletTestContext context) throws ServletException, IOException
         {
            HttpSession session = request.getSession(false);
            assertNotNull(session);
            assertFalse(session.isNew());
            assertEquals("foo_dispatched_value", session.getAttribute("foo"));

            //
            session.invalidate();

            try
            {
               session.isNew();
               fail();
            }
            catch (IllegalStateException ignore)
            {
            }

            //
            return null;
         }
      });
   }
}
