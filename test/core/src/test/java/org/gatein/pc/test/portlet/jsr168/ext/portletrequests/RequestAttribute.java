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
package org.gatein.pc.test.portlet.jsr168.ext.portletrequests;

import org.gatein.pc.test.unit.PortletTestCase;
import org.gatein.pc.test.unit.PortletTestContext;
import org.gatein.pc.test.unit.Assertion;
import org.gatein.pc.test.unit.actions.PortletRenderTestAction;
import org.gatein.pc.test.unit.web.UTP1;
import org.gatein.common.util.Tools;
import org.gatein.pc.test.unit.annotations.TestCase;
import org.gatein.pc.test.unit.protocol.response.Response;
import org.gatein.pc.test.unit.protocol.response.EndTestResponse;
import static org.gatein.pc.test.unit.Assert.assertNotNull;
import static org.gatein.pc.test.unit.Assert.assertNull;
import static org.gatein.pc.test.unit.Assert.assertEquals;

import javax.portlet.Portlet;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.Set;
import java.util.HashSet;

/**
 * This case works with two portlets involved in the same render request. To pass the test, the assert result of the
 * two portlets must pass.
 *
 */
@TestCase({
   Assertion.EXT_PORTLET_REQUESTS_5
   })
public class RequestAttribute
{
   public RequestAttribute(PortletTestCase seq)
   {
      seq.bindAction(0, UTP1.RENDER_JOIN_POINT, new PortletRenderTestAction()
      {
         protected Response run(Portlet portlet, RenderRequest request, RenderResponse response, PortletTestContext context)
         {
            // Take a snapshot of the attribute names
            Set snapshot = Tools.toSet(request.getAttributeNames());

            // Test that we can remove an attribute without affecting the incoming request, i.e
            // the same attribute will be present in other render request
            assertNotNull(request.getAttribute("javax.portlet.config"));
            request.removeAttribute("javax.portlet.config");
            assertNull(request.getAttribute("javax.portlet.config"));

            // Test addition of an attribute
            request.setAttribute("bar", "bar");
            assertEquals("bar", request.getAttribute("bar"));

            // Test the portlet request names are what we expect
            HashSet expectedNames = new HashSet(snapshot);
            expectedNames.remove("javax.portlet.config");
            expectedNames.add("bar");
            assertEquals(expectedNames, Tools.toSet(request.getAttributeNames()));
            return new EndTestResponse();
         }
      });
   }
}
