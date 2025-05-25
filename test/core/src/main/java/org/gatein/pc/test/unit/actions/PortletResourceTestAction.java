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

import org.gatein.pc.test.unit.TestAction;
import org.gatein.pc.test.unit.PortletTestContext;
import org.gatein.common.NotYetImplemented;
import org.gatein.common.io.IOTools;
import org.gatein.pc.test.unit.protocol.response.Response;
import org.gatein.pc.test.unit.protocol.response.FailureResponse;
import org.gatein.pc.test.unit.Failure;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;
import java.io.Writer;
import java.io.OutputStream;

public abstract class PortletResourceTestAction extends TestAction
{

   /**
    * This field is used to determine if the action will attempt to send a response after the action has been executed.
    * The attempt to send a response will be done if:
    * <ul>
    * <li>this field has a value equals to true</li>
    * <li>no content type has been set on the response during the execution of the action</li>
    * <li>the execution of the action is succesfull or is a failure (i.e it will not be done on Errors other than
    * <code>java.lang.AssertionError</code></li>
    * </ul>
    */
   private final boolean attemptToSendResponse;

   protected PortletResourceTestAction(boolean attemptToSendResponse)
   {
      this.attemptToSendResponse = attemptToSendResponse;
   }

   protected PortletResourceTestAction()
   {
      this(true);
   }

   public final Response execute(Portlet portlet, ResourceRequest request, ResourceResponse response, PortletTestContext context) throws PortletException, IOException
   {
      // We attempty to do it
      boolean sendResponse = false;

      //
      try
      {
         Response driverResponse = runWithRuntimeException(portlet, request, response, context);
         sendResponse = attemptToSendResponse;
         return driverResponse;
      }
      catch (AssertionError t)
      {
         getLogger().error("The test case failed", t);

         // We will send a response
         sendResponse = attemptToSendResponse;

         //
         return new FailureResponse(Failure.createFailure(t));
      }
      finally
      {
         if (sendResponse)
         {
            if (response.getContentType() == null)
            {
               response.setContentType("text/html");
            }

            //
            boolean gotWriter = false;
            try
            {
               Writer writer = response.getWriter();
               gotWriter = true;
               IOTools.safeClose(writer);
            }
            catch (IllegalStateException ignore)
            {
            }
            if (!gotWriter)
            {
               try
               {
                  OutputStream out = response.getPortletOutputStream();
                  IOTools.safeClose(out);
               }
               catch (IllegalStateException ignore)
               {
               }
               catch (IOException ignore)
               {
               }
            }
         }
      }
   }

   protected Response runWithRuntimeException(Portlet portlet, ResourceRequest request, ResourceResponse response, PortletTestContext context) throws PortletException, IOException
   {
      try
      {
         return run(portlet, request, response, context);
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

   protected Response run(Portlet portlet, ResourceRequest request, ResourceResponse response, PortletTestContext context) throws PortletException, IOException
   {
      throw new NotYetImplemented();
   }
}