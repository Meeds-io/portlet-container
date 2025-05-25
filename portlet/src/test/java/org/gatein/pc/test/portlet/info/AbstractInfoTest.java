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
package org.gatein.pc.test.portlet.info;

public abstract class AbstractInfoTest // implements RemoteTestDriver
{
//
//   /** The test id. */
//   protected final String testCaseId;
//
//   /** The test info. */
//   protected final TestInfo testInfo;
//
//   /** . */
//   protected PortletApplicationRegistry registry;
//
//   /** The controller. */
//   protected CompositeTestDriver testDriverContainer;
//
//   /** Not really used for now, we need the concept of non http test context. */
//   private RequestContext testContext;
//
   public AbstractInfoTest(String testCaseId)
   {
//      if (testCaseId == null)
//      {
//         throw new IllegalArgumentException("No null test case id accepted");
//      }
//
//      //
//      this.testCaseId = testCaseId;
//      this.testInfo = new SimpleTestSuiteInfo(testCaseId);
   }
//
//   public void pushContext(TestId testId, RequestContext requestContext)
//   {
//      this.testContext = requestContext;
//   }
//
//   public ResponseContext popContext(TestId testId)
//   {
//      return null;
//   }
//
//   public PortletApplicationRegistry getRegistry()
//   {
//      return registry;
//   }
//
//   public void setRegistry(PortletApplicationRegistry registry)
//   {
//      this.registry = registry;
//   }
//
//   public CompositeTestDriver getTestDriverRegistry()
//   {
//      return testDriverContainer;
//   }
//
//
//   public void initDriver(DriverContext driverContext) throws DriverException
//   {
//   }
//
//   public void destroyDriver()
//   {
//   }
//
//   public void setTestDriverRegistry(CompositeTestDriver testDriverContainer)
//   {
//      this.testDriverContainer = testDriverContainer;
//   }
//
//   public void create() throws Exception
//   {
//      testDriverContainer.mount(this);
//   }
//
//   public void destroy()
//   {
//      testDriverContainer.unmount(this);
//   }
//
//   public TestInfo getInfo()
//   {
//      return testInfo;
//   }
//
//   public DriverResponse invoke(TestId testId, DriverCommand cmd)
//   {
//      if (cmd instanceof StartTestCommand)
//      {
//         try
//         {
//            execute();
//
//            //
//            return new EndTestResponse();
//         }
//         catch (Exception e)
//         {
//            return new FailureResponse(Failure.createFailure(e));
//         }
//      }
//      else
//      {
//         return new FailureResponse(Failure.createAssertionFailure("Unexpected command"));
//      }
//   }
//
//   protected abstract void execute();
//
}
