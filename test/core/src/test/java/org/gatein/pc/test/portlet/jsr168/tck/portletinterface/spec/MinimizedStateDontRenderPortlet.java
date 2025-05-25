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
package org.gatein.pc.test.portlet.jsr168.tck.portletinterface.spec;

import org.gatein.pc.test.unit.web.AbstractTestGenericPortlet;
import org.gatein.pc.test.unit.PortletTestContext;
import org.gatein.pc.test.unit.annotations.TestActor;
import org.gatein.pc.test.unit.protocol.response.Response;
import org.gatein.pc.test.unit.protocol.response.InvokeGetResponse;
import org.gatein.pc.test.unit.protocol.response.EndTestResponse;
import org.gatein.pc.test.unit.protocol.response.FailureResponse;
import org.gatein.pc.test.unit.Failure;

import static org.gatein.pc.test.unit.Assert.*;

import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;
import java.io.IOException;

@TestActor(id=MinimizedStateDontRenderPortlet.NAME)
public class MinimizedStateDontRenderPortlet extends AbstractTestGenericPortlet
{

   /** . */
   public static final String NAME = "MinimizedStateDontRenderPortlet";

   /** . */
   private String rendered;

   protected void doView(final RenderRequest request, RenderResponse response) throws PortletException, IOException
   {
      // Shouldn't be here
      rendered = "doView";
   }

   protected void doEdit(final RenderRequest request, RenderResponse response) throws PortletException, IOException
   {
      // Shouldn't be here
      rendered = "doEdit";
   }

   protected void doHelp(final RenderRequest request, RenderResponse response) throws PortletException, IOException
   {
      // Shouldn't be here
      rendered = "doHelp";
   }

   protected void preRender(RenderRequest req, RenderResponse resp, PortletTestContext context) throws PortletException, IOException
   {
      rendered = null;
   }

   protected Response postRender(RenderRequest req, RenderResponse resp, PortletTestContext context) throws PortletException, IOException
   {
      switch(context.getRequestCount())
      {
         case 0:
         {
            // Invoking VIEW mode
            PortletURL url = resp.createRenderURL();
            url.setPortletMode(PortletMode.VIEW);
            url.setWindowState(WindowState.MINIMIZED);
            return new InvokeGetResponse(url.toString());
         }
         case 1:
         {
            assertNull(rendered);

            // Invoking EDIT mode
            PortletURL url = resp.createRenderURL();
            url.setPortletMode(PortletMode.EDIT);
            url.setWindowState(WindowState.MINIMIZED);
            return new InvokeGetResponse(url.toString());
         }
         case 2:
         {
            assertNull(rendered);

            // Invoking HELP mode
            PortletURL url = resp.createRenderURL();
            url.setPortletMode(PortletMode.HELP);
            url.setWindowState(WindowState.MINIMIZED);
            return new InvokeGetResponse(url.toString());
         }
         case 3:
         {
            assertNull(rendered);

            //
            return new EndTestResponse();
         }
         default:
            return new FailureResponse(Failure.createAssertionFailure(""));
      }
   }
}
