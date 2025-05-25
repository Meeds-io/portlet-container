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
package org.gatein.pc.test.portlet.jsr168.tck.portletresponses;

import org.gatein.pc.test.unit.PortletTestCase;
import org.gatein.pc.test.unit.PortletTestContext;
import org.gatein.pc.test.unit.actions.PortletRenderTestAction;
import org.gatein.pc.test.unit.web.UTP1;
import org.gatein.pc.test.unit.annotations.TestCase;
import org.gatein.pc.test.unit.Assertion;
import org.gatein.pc.test.unit.protocol.response.Response;
import org.gatein.pc.test.unit.protocol.response.EndTestResponse;
import static org.gatein.pc.test.unit.Assert.fail;
import org.gatein.pc.test.unit.protocol.response.InvokeGetResponse;

import javax.portlet.Portlet;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;
import java.io.OutputStream;

@TestCase({Assertion.JSR168_79})
public class OutputStreamOrWriter
{
   public OutputStreamOrWriter(PortletTestCase seq)
   {
      seq.bindAction(0, UTP1.RENDER_JOIN_POINT, new PortletRenderTestAction()
      {
         protected Response run(Portlet portlet, RenderRequest request, RenderResponse response, PortletTestContext context) throws IOException
         {
            response.setContentType("text/html");
            response.getWriter();
            try
            {
               response.getPortletOutputStream();
               fail();
            }
            catch (IllegalStateException e)
            {
               //expected
            }
            return new InvokeGetResponse(response.createRenderURL().toString());
         }
      });

      seq.bindAction(1, UTP1.RENDER_JOIN_POINT, new PortletRenderTestAction()
      {
         protected Response run(Portlet portlet, RenderRequest request, RenderResponse response, PortletTestContext context) throws IOException
         {
            //we need this to be able to marshal the result
            response.setContentType("text/html");
            OutputStream os = response.getPortletOutputStream();

            //and now the test
            try
            {
               response.getWriter();
               fail();
            }
            catch (IllegalStateException e)
            {
               //expected
            }

            //workaroud to correctly end this test:
            //we can't use AbstractTestPortet.marshalle() because we cannot obtain
            //writer from response as OutputStream was used.
//            Writer writer = new OutputStreamWriter(os);
//            ServerResultMarshaller.marshall(, writer, TestCaseContext.getCurrentTestCaseId());
//            writer.close();
            return new EndTestResponse();
         }
      });
   }
}
