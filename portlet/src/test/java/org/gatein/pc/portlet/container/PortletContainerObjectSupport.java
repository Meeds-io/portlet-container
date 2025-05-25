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
package org.gatein.pc.portlet.container;

import org.gatein.pc.api.PortletInvokerException;
import org.gatein.pc.api.info.PortletInfo;
import org.gatein.pc.api.invocation.InvocationException;
import org.gatein.pc.api.invocation.PortletInvocation;
import org.gatein.pc.api.invocation.response.PortletInvocationResponse;
import org.gatein.pc.portlet.container.object.PortletContainerObject;

import javax.portlet.Portlet;
import java.util.HashMap;
import java.util.Map;

public class PortletContainerObjectSupport extends ObjectSupport implements PortletContainerObject
{

   /** . */
   final Map<String, PortletFilter> filters = new HashMap<String, PortletFilter>();

   /** . */
   PortletApplication application;

   /** . */
   PortletContainerContext context;

   public PortletContainerObjectSupport(String id)
   {
      super(id);
   }

   public void setPortletApplication(PortletApplication application)
   {
      this.application = application;
   }

   public void setContext(PortletContainerContext context)
   {
      this.context = context;
   }

   public void addPortletFilter(PortletFilter filter)
   {
      if (filter == null)
      {
         throw new AssertionError();
      }
      if (filters.containsKey(filter.getId()))
      {
         throw new AssertionError();
      }
      filters.put(filter.getId(), filter);
   }

   public void removePortletFilter(PortletFilter filter)
   {
      if (filter == null)
      {
         throw new AssertionError();
      }
      if (!filters.containsKey(filter.getId()))
      {
         throw new AssertionError();
      }
      filters.remove(filter.getId());
   }

   public PortletInfo getInfo()
   {
      throw new UnsupportedOperationException();
   }

   public PortletInvocationResponse dispatch(PortletInvocation invocation) throws PortletInvokerException, InvocationException
   {
      throw new UnsupportedOperationException();
   }

   public PortletApplication getPortletApplication()
   {
      throw new UnsupportedOperationException();
   }

   public PortletContainerContext getContext()
   {
      throw new UnsupportedOperationException();
   }

   @Override
   public Portlet getPortletInstance()
   {
      throw new UnsupportedOperationException();
   }
}
