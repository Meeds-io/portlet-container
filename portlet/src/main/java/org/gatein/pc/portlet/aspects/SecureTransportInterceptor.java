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
package org.gatein.pc.portlet.aspects;

import org.gatein.pc.api.TransportGuarantee;
import org.gatein.pc.api.PortletInvokerException;
import org.gatein.pc.portlet.container.ContainerPortletInvoker;
import org.gatein.pc.portlet.container.PortletContainer;
import org.gatein.pc.api.info.PortletInfo;
import org.gatein.pc.api.info.SecurityInfo;
import org.gatein.pc.api.invocation.PortletInvocation;
import org.gatein.pc.portlet.PortletInvokerInterceptor;
import org.gatein.pc.api.invocation.response.InsufficientTransportGuaranteeResponse;
import org.gatein.pc.api.invocation.response.PortletInvocationResponse;
import org.gatein.pc.api.spi.SecurityContext;

/**
 * Implement security constaint defined by the portlet spec.
 *
 */
public class SecureTransportInterceptor extends PortletInvokerInterceptor
{

   public PortletInvocationResponse invoke(PortletInvocation invocation) throws IllegalArgumentException, PortletInvokerException
   {
      PortletContainer container = (PortletContainer)invocation.getAttribute(ContainerPortletInvoker.PORTLET_CONTAINER);
      PortletInfo containerInfo = container.getInfo();
      SecurityInfo securityInfo = containerInfo.getSecurity();
      SecurityContext securityContext = invocation.getSecurityContext();
      boolean invoke = true;
      if (!securityContext.isSecure())
      {
         if (securityInfo.containsTransportGuarantee(TransportGuarantee.CONFIDENTIAL))
         {
            invoke = false;
         }
         else if (securityInfo.containsTransportGuarantee(TransportGuarantee.INTEGRAL))
         {
            invoke = false;
         }
      }

      //
      if (invoke)
      {
         // Invoke
         return super.invoke(invocation);
      }
      else
      {
         // Significate to the caller that this component should be executed with an higher security level
         return new InsufficientTransportGuaranteeResponse();
      }
   }
}
