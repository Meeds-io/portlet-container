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
package org.gatein.pc.test.portlet.jsr168.tck.portletsession;

import org.gatein.pc.test.unit.annotations.TestCase;
import org.gatein.pc.test.unit.Assertion;
import org.gatein.pc.test.unit.PortletTestCase;

@TestCase(value = {Assertion.JSR168_120}, enabled = false)
public class SessionInvalidation
{
   public SessionInvalidation(PortletTestCase seq)
   {
//      seq.addAction(0, UTP1.RENDER_JOINPOINT, new PortletRenderTestAction()
//      {
//         protected Result run(Portlet portlet, RenderRequest request, RenderResponse response)
//         {
//            UTP1.holder = response.createRenderURL().toString();
//
//            request.getPortletSession().setAttribute("key1", "k1value1", PortletSession.APPLICATION_SCOPE);
//
//            //invalidate session
//            request.getPortletSession().invalidate();
//
//            request.getPortletSession().setAttribute("key2", "k2value1", PortletSession.APPLICATION_SCOPE);
//
//            String path = request.getContextPath();
//            return new InvokeGetResult(path + "/universalServletA");
//         }
//      });
//
//      seq.addAction(1, UTS1.SERVICE_JOINPOINT, new ServletServiceTestAction()
//      {
//         protected Result run(Servlet servlet, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
//         {
//            //assert that we can't access attributest stored in PortletSession as it was invalidated
//            assertNull(request.getSession().getAttribute("key1"));
//
//            //set some attributes in HttpSession to assert them in Portlet
//            request.getSession().setAttribute("key3", "k2value1");
//
//            request.getSession().invalidate();
//
//            request.getSession().setAttribute("key4", "k4value1");
//
//            //invoke portlet
//            return new InvokeGetResult((String)UTP1.holder);
//         }
//      });
//
//      seq.addAction(2, UTP1.RENDER_JOINPOINT, new PortletRenderTestAction()
//      {
//         protected Result run(Portlet portlet, RenderRequest request, RenderResponse response)
//         {
//            //assert that we can't access attributest stored in HttpSession as it was invalidated
//            assertNull(request.getPortletSession().getAttribute("key1", PortletSession.APPLICATION_SCOPE));
//            assertNull(request.getPortletSession().getAttribute("key2", PortletSession.APPLICATION_SCOPE));
//            assertNull(request.getPortletSession().getAttribute("key3", PortletSession.APPLICATION_SCOPE));
//            assertEquals("k4value1", request.getPortletSession().getAttribute("key4", PortletSession.APPLICATION_SCOPE));
//
//            return new EndTestResult();
//         }
//      });
   }
}
