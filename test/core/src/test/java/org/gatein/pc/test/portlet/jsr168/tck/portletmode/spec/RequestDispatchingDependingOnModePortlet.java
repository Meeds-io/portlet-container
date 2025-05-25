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
package org.gatein.pc.test.portlet.jsr168.tck.portletmode.spec;

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
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.PortletMode;
import javax.portlet.PortletURL;
import java.io.IOException;

@TestActor(id=RequestDispatchingDependingOnModePortlet.NAME)
public class RequestDispatchingDependingOnModePortlet extends AbstractTestGenericPortlet
{

   /** . */
   public static final String NAME = "RequestDispatchingDependingOnModePortlet";

   /** . */
   private String methodCall;

   /** . */
   private PortletTestContext context;

   protected void doView(final RenderRequest request, RenderResponse response) throws PortletException, IOException
   {
      if (context.getRequestCount() == 1)
      {
         methodCall = "doView";
      }
   }

   protected void doEdit(final RenderRequest request, RenderResponse response) throws PortletException, IOException
   {
      if (context.getRequestCount() == 2)
      {
         methodCall = "doEdit";
      }
   }

   protected void doHelp(final RenderRequest request, RenderResponse response) throws PortletException, IOException
   {
      if (context.getRequestCount() == 3)
      {
         methodCall = "doHelp";
      }
   }

   protected void preRender(RenderRequest req, RenderResponse resp, PortletTestContext context) throws PortletException, IOException
   {
      this.context = context;
      this.methodCall = null;
   }

   protected Response postRender(RenderRequest req, RenderResponse resp, PortletTestContext context) throws PortletException, IOException
   {
      try
      {
         switch(context.getRequestCount())
         {
            case 0:
            {
               // Invoking VIEW mode
               PortletURL url = resp.createRenderURL();
               url.setPortletMode(PortletMode.VIEW);
               return new InvokeGetResponse(url.toString());
            }
            case 1:
            {
               assertEquals("doView", methodCall);

               // Invoking EDIT mode
               PortletURL url = resp.createRenderURL();
               url.setPortletMode(PortletMode.EDIT);
               return new InvokeGetResponse(url.toString());
            }
            case 2:
            {
               assertEquals("doEdit", methodCall);

               // Invoking HELP mode
               PortletURL url = resp.createRenderURL();
               url.setPortletMode(PortletMode.HELP);
               return new InvokeGetResponse(url.toString());
            }
            case 3:
            {
               assertEquals("doHelp", methodCall);

               //
               return new EndTestResponse();
            }
            default:
               return new FailureResponse(Failure.createAssertionFailure(""));
         }
      }
      finally
      {
         this.context = null;
         this.methodCall = null;
      }
   }
}

