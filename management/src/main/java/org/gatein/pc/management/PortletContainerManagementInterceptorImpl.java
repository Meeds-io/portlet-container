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
package org.gatein.pc.management;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.gatein.pc.api.PortletContext;
import org.gatein.pc.api.PortletInvokerException;
import org.gatein.pc.api.invocation.ActionInvocation;
import org.gatein.pc.api.invocation.PortletInvocation;
import org.gatein.pc.api.invocation.RenderInvocation;
import org.gatein.pc.api.invocation.response.PortletInvocationResponse;
import org.gatein.pc.portlet.PortletInvokerInterceptor;

public class PortletContainerManagementInterceptorImpl extends PortletInvokerInterceptor implements PortletContainerManagementInterceptor
{

   /** . */
   private final ConcurrentMap<String, PortletInfo> map = new ConcurrentHashMap<String, PortletInfo>();
   
   
   // Correctness is not insured.
   public PortletInvocationResponse invoke(PortletInvocation invocation) throws IllegalArgumentException, PortletInvokerException
   {
      PortletContext portlet = invocation.getTarget();
      String portletName = portlet.getId();
      
      boolean error = true;
      long delta = - System.currentTimeMillis();

      //
      try
      {
         PortletInvocationResponse response =  super.invoke(invocation);
         error = false;
         return response;
      }
      finally
      {
         delta += System.currentTimeMillis();

         //
         if (invocation instanceof RenderInvocation)
         {
            PortletInfo info = getPortletInfo(portletName);
            info.newRenderCall(delta, error);
         }
         else if (invocation instanceof ActionInvocation)
         {
            PortletInfo info = getPortletInfo(portletName);
            info.newActionCall(delta, error);
         }
      }
   }

   public synchronized PortletInfo getPortletInfo(String key)
   {
      PortletInfo info = map.get(key);

      //
      if (info == null)
      {
         info = map.putIfAbsent(key, new PortletInfo());
      }

      //
      return map.get(key);
   }
}
