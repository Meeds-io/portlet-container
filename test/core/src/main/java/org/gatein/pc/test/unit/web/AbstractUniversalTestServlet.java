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

import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.gatein.pc.test.unit.JoinPoint;
import org.gatein.pc.test.unit.PortletTestCase;
import org.gatein.pc.test.unit.PortletTestServlet;
import org.gatein.pc.test.unit.actions.ServletServiceTestAction;
import org.gatein.pc.test.unit.TestAction;
import org.gatein.pc.test.unit.JoinPointType;
import org.gatein.pc.test.unit.PortletTestContext;
import org.gatein.pc.test.unit.protocol.DriverServlet;
import org.gatein.pc.test.unit.protocol.response.Response;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Universal test servlet that enables to reuse servlet instances across several tests
 *
 */
public abstract class AbstractUniversalTestServlet extends HttpServlet
{

   /** The logger. */
   private final Log      log              = ExoLogger.getLogger(getClass());

   /** Jointpoint for service method. */
   private final JoinPoint serviceJoinPoint = JoinPoint.createJoinPoint(getClass(), JoinPointType.SERVLET_SERVICE);

   /** Construct a test servlet with a test id computed with the method <code>getTestId(Class)</code>. */
   public AbstractUniversalTestServlet()
   {
   }

   /**
    * Standart implementation of service() method to handle requests and invoke actions from sequence
    *
    * @param request
    * @param response
    * @throws ServletException
    * @throws IOException
    */
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
      PortletTestContext ctx = DriverServlet.getPortletTestContext();

      //
      log.info("JoinPoint " + serviceJoinPoint + " invoked for '"
         + ctx.getTestName() + "' testId and '" +
         +ctx.getRequestCount() + "' request count");

      // Reset instance state
      if (ctx.getRequestCount() == 0)
      {
         reset();
      }

      PortletTestCase portletTestCase = getSequence(ctx.getTestName());
      if (portletTestCase != null)
      {
         TestAction action = portletTestCase.getAction(ctx.getRequestCount(), getServiceJointpoint());
         if (action != null && action instanceof ServletServiceTestAction)
         {
            log.info("Found Action for this jointpoint");
            Response dr = ((ServletServiceTestAction)action).execute(this, request, response, ctx);
            if (dr != null)
            {
               ctx.updateResponse(dr);
            }
         }

      }
   }

   /**
    * Returns Sequence for current testId Returns null if there is no Sequence for current testId
    *
    * @return
    * @throws jakarta.servlet.ServletException if there is no SequenceRegistry
    */
   protected PortletTestCase getSequence(String testId) throws ServletException
   {
      PortletTestCase testCase = PortletTestServlet.getTestCase(testId);
      if (testCase == null)
      {
         log.error("No test case object found in current context");
         throw new ServletException("No test case object found in context");
      }
      return testCase;
   }

   public JoinPoint getServiceJointpoint()
   {
      return serviceJoinPoint;
   }

   public abstract void reset();

}
