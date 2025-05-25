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

public class SecurityInfoTest extends AbstractInfoTest
{

   public SecurityInfoTest()
   {
      super("SecurityInfoTest");
   }

//   public void execute()
//   {
//      //This asserts only .isRemotable() as rest is checked in other tests
//
//      ManagedPortletContainer container = registry.getManagedPortletApplication("/test-info").getManagedPortletContainer("SecuredPortlet1");
//      PortletInfo info = container.getInfo();
//      SecurityInfo secInfo = info.getSecurity();
//
//      secInfo = info.getSecurity();
//      assertEquals(2, secInfo.getTransportGuarantees().size());
//      assertTrue(secInfo.containsTransportGuarantee(TransportGuarantee.CONFIDENTIAL));
//      //assertTrue(secInfo.containsTransportGuarantee(TransportGuarantee.INTEGRAL));
//      assertTrue(secInfo.containsTransportGuarantee(TransportGuarantee.NONE));
//
//
//      container = registry.getManagedPortletApplication("/test-info").getManagedPortletContainer("SecuredPortlet2");
//      info = container.getInfo();
//
//      secInfo = info.getSecurity();
//      assertEquals(3, secInfo.getTransportGuarantees().size());
//      assertTrue(secInfo.containsTransportGuarantee(TransportGuarantee.INTEGRAL));
//      assertTrue(secInfo.containsTransportGuarantee(TransportGuarantee.CONFIDENTIAL));
//      assertTrue(secInfo.containsTransportGuarantee(TransportGuarantee.NONE));
//
//
//      container = registry.getManagedPortletApplication("/test-info").getManagedPortletContainer("SecuredPortlet3");
//      info = container.getInfo();
//      secInfo = info.getSecurity();
//      assertEquals(2, secInfo.getTransportGuarantees().size());
//      assertTrue(secInfo.containsTransportGuarantee(TransportGuarantee.INTEGRAL));
//      assertTrue(secInfo.containsTransportGuarantee(TransportGuarantee.NONE));
//   }
}
