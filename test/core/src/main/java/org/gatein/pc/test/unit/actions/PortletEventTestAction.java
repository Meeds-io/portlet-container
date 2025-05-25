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
package org.gatein.pc.test.unit.actions;

import org.gatein.pc.test.unit.PortletTestContext;
import org.gatein.pc.test.unit.TestAction;
import org.gatein.common.NotYetImplemented;
import org.gatein.pc.test.unit.protocol.response.Response;
import org.gatein.pc.test.unit.protocol.response.FailureResponse;
import org.gatein.pc.test.unit.Failure;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import java.io.IOException;

public abstract class PortletEventTestAction extends TestAction
{

   public final Response execute(Portlet portlet, EventRequest request, EventResponse response, PortletTestContext context) throws PortletException, IOException
   {
      try
      {
         runWithRuntimeException(portlet, request, response, context);

         //
         return null;
      }
      catch (AssertionError t)
      {
         getLogger().error("The test case failed", t);

         //
         return new FailureResponse(Failure.createFailure(t));
      }
   }

   protected void runWithRuntimeException(Portlet portlet, EventRequest request, EventResponse response, PortletTestContext context) throws PortletException, IOException
   {
      try
      {
         run(portlet, request, response, context);
      }
      catch (Exception e)
      {
         if (e instanceof PortletException)
         {
            throw (PortletException)e;
         }
         if (e instanceof IOException)
         {
            throw (IOException)e;
         }
         throw new AssertionError(e);
      }
   }

   protected void run(Portlet portlet, EventRequest request, EventResponse response, PortletTestContext context) throws PortletException, IOException
   {
      throw new NotYetImplemented();
   }
}