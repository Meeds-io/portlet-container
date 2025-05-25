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
package org.gatein.pc.test.unit;

import org.apache.commons.httpclient.Header;
import org.gatein.common.NotYetImplemented;
import org.gatein.pc.test.unit.protocol.DriverContext;
import org.gatein.pc.test.unit.protocol.response.Response;
import org.gatein.pc.test.unit.protocol.response.FailureResponse;

import java.net.MalformedURLException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class PortletTestContext
{

   /** . */
   final String testName;

   /** . */
   final PortletTestCase portletTestCase;

   /** . */
   final Set<JoinPoint> invoked;

   /** . */
   final DriverContext driverContext;

   public PortletTestContext(String testName, PortletTestCase portletTestCase, DriverContext driverContext)
   {
      if (driverContext == null)
      {
         throw new IllegalArgumentException("No request context to wrap");
      }
      this.testName = testName;
      this.portletTestCase = portletTestCase;
      this.driverContext = driverContext;
      this.invoked = new HashSet<JoinPoint>();
   }

   public String getTestName()
   {
      return testName;
   }

   private static class JoinPointInvocation
   {

      /** . */
      private final int requestCount;

      /** . */
      private final JoinPoint joinPoint;

      private JoinPointInvocation(int requestCount, JoinPoint joinPoint)
      {
         this.requestCount = requestCount;
         this.joinPoint = joinPoint;
      }

      public boolean equals(Object obj)
      {
         if (obj == this)
         {
            return true;
         }
         if (obj instanceof JoinPointInvocation)
         {
            JoinPointInvocation that = (JoinPointInvocation)obj;
            return requestCount == that.requestCount && joinPoint.equals(that.joinPoint);
         }
         return false;
      }

      public int hashCode()
      {
         return requestCount + joinPoint.hashCode();
      }
   }

   public void setInvoked(JoinPoint joinPoint)
   {
//      invocations.add(new JoinPointInvocation(requestCount, joinPoint));
      invoked.add(joinPoint);
   }

   public String getActorId(JoinPointType joinPointType)
   {
      return portletTestCase.getActorId(driverContext.getRequestCount(), joinPointType);
   }

   public Response getResponse()
   {
      return driverContext.getResponse();
   }

   /**
    * Update the context response with the provided response. The update will occur
    * if there is no previous existing response. If there is an existing response
    * this one will be overwrited only if it is not a failure and the provided
    * response is a failure.
    *
    * @param response the new response
    */
   public void updateResponse(Response response)
   {
      if (response == null)
      {
         throw new IllegalArgumentException();
      }

      Response existingResponse = driverContext.getResponse();

      //
      if (existingResponse instanceof FailureResponse)
      {
         // We keep the existing failure, since we want it reported
      }
      else if (response instanceof FailureResponse || existingResponse == null)
      {
         // We have a failure response and the context contains no response or a non failure response
         driverContext.setResponse(response);
      }
   }

   public int getRequestCount()
   {
      return driverContext.getRequestCount();
   }

   public String rewriteURLForNode(String url/*, NodeId nodeId*/) throws MalformedURLException
   {
      throw new NotYetImplemented("todo");
   }

   public Map<String, Serializable> getPayload()
   {
      return driverContext.getPayload();
   }

   public byte[] getResponseBody()
   {
      return (byte[])getPayload().get("http.response.body");
   }

   public HashMap<String, Header> getResponseHeaders()
   {
      return (HashMap<String, Header>)getPayload().get("http.response.headers");
   }
}
