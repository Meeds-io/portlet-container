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
package org.gatein.pc.test.portlet.jsr168.ext.session;

import org.gatein.pc.test.unit.PortletTestCase;
import org.gatein.pc.test.unit.PortletTestContext;
import org.gatein.pc.test.unit.Assertion;
import org.gatein.pc.test.unit.annotations.TestCase;
import org.gatein.pc.test.unit.actions.PortletRenderTestAction;
import org.gatein.pc.test.unit.web.UTP1;
import org.gatein.pc.test.unit.protocol.response.Response;
import org.gatein.pc.test.unit.protocol.response.EndTestResponse;
import static org.gatein.pc.test.unit.Assert.*;

import javax.portlet.Portlet;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import jakarta.servlet.http.HttpSessionBindingListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;

@TestCase({
   Assertion.EXT_SESSION_2
   })
public class HTTPSessionInvalidationInvalidesPortletSession implements Serializable
{

  private static final long serialVersionUID = -4129569056920464851L;

   public HTTPSessionInvalidationInvalidesPortletSession(PortletTestCase seq)
   {
      seq.bindAction(0, UTP1.RENDER_JOIN_POINT, new PortletRenderTestAction()
      {
         protected Response run(Portlet portlet, RenderRequest request, RenderResponse response, PortletTestContext context) throws PortletException, IOException
         {
            PortletSession session = request.getPortletSession();

            // Invalidates the real http session
            SessionInvalidator invalidator = new SessionInvalidator();
            invalidator.invalidate(session);

            // Now it should be null
            session = request.getPortletSession(false);
            assertNull(session);

            //
            return new EndTestResponse();
         }
      });
   }

   private static class SessionInvalidator implements HttpSessionBindingListener, Serializable
   {
      private static final long serialVersionUID = -4844795605278357322L;

      /** . */
      private HttpSession realSession;

      public void valueBound(HttpSessionBindingEvent event)
      {
         this.realSession = event.getSession();
      }

      public void valueUnbound(HttpSessionBindingEvent event)
      {
      }

      public void invalidate(PortletSession session)
      {
         session.setAttribute("foo", this);
         realSession.invalidate();
      }
   }
}