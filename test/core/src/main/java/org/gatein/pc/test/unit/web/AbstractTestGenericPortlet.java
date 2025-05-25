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
package org.gatein.pc.test.unit.web;

import org.gatein.pc.test.unit.PortletTestContext;
import org.gatein.pc.test.unit.JoinPoint;
import org.gatein.pc.test.unit.JoinPointType;
import org.gatein.pc.test.unit.protocol.DriverServlet;
import org.gatein.pc.test.unit.protocol.response.Response;
import org.gatein.pc.test.unit.protocol.response.FailureResponse;
import org.gatein.pc.test.unit.Failure;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSecurityException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;

/**
 * Abstract test class for testing GenericPortlet implementation
 *
 */
public abstract class AbstractTestGenericPortlet extends GenericPortlet
{

   /** Joinpoint for render phase. */
   private final JoinPoint renderJoinPoint = JoinPoint.createJoinPoint(getClass(), JoinPointType.PORTLET_RENDER);

   /** Joinpoint for action phase. */
   private final JoinPoint actionJoinPoint = JoinPoint.createJoinPoint(getClass(), JoinPointType.PORTLET_ACTION);

   public void processAction(ActionRequest req, ActionResponse resp) throws PortletException, IOException
   {
      PortletTestContext context = DriverServlet.getPortletTestContext();

      //
      String actorId = context.getActorId(JoinPointType.PORTLET_ACTION);

      //
      Response response = new FailureResponse(Failure.createErrorFailure(""));

      //
      if (actorId != null)
      {
         JoinPoint tmp = new JoinPoint(actorId, JoinPointType.PORTLET_ACTION);

         //
         if (tmp.equals(actionJoinPoint))
         {
            try
            {
               response = doProcessAction(req, resp, context);
            }
            catch (AssertionError e)
            {
               response = new FailureResponse(Failure.createFailure(e));
            }
         }
      }

      //
      context.updateResponse(response);
   }

   public void render(RenderRequest req, RenderResponse resp) throws PortletException, IOException
   {
      PortletTestContext context = DriverServlet.getPortletTestContext();

      //
      String actorId = context.getActorId(JoinPointType.PORTLET_RENDER);

      //
      if (actorId != null)
      {
         JoinPoint tmp = new JoinPoint(actorId, JoinPointType.PORTLET_RENDER);

         //
         if (tmp.equals(renderJoinPoint))
         {
            Response response;
            try
            {
               preRender(req, resp, context);
               super.render(req, resp);
               response = postRender(req, resp, context);
            }
            catch (AssertionError e)
            {
               response = new FailureResponse(Failure.createFailure(e));
            }

            //
            if (response != null)
            {
               context.updateResponse(response);
            }
         }
      }
   }

   protected Response doProcessAction(ActionRequest req, ActionResponse resp, PortletTestContext context) throws PortletException, IOException
   {
      throw new PortletException();
   }

   /**
    * Invoked by render() method if current test is running. After this method GenericPortlet.render() will be called.
    *
    * @param req
    * @param resp
    * @param context
    * @throws PortletException
    * @throws PortletSecurityException
    * @throws IOException
    */
   protected void preRender(RenderRequest req, RenderResponse resp, PortletTestContext context) throws PortletException, IOException
   {
      throw new PortletException();
   }

   /**
    * Invoked by render() method after GenericPortlet.render() invocation.
    *
    * @param req
    * @param resp
    * @param context
    * @throws PortletException
    * @throws PortletSecurityException
    * @throws IOException
    */
   protected Response postRender(RenderRequest req, RenderResponse resp, PortletTestContext context) throws PortletException, IOException
   {
      return null;
   }
}
