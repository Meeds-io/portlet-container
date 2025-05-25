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
package org.gatein.pc.portlet.support;

import junit.framework.Assert;
import org.gatein.pc.api.PortletInvokerException;
import org.gatein.pc.api.PortletContext;
import org.gatein.pc.api.Portlet;
import org.gatein.pc.portlet.support.info.PortletInfoSupport;
import org.gatein.pc.api.invocation.PortletInvocation;
import org.gatein.pc.api.invocation.ActionInvocation;
import org.gatein.pc.api.invocation.EventInvocation;
import org.gatein.pc.api.invocation.RenderInvocation;
import org.gatein.pc.api.invocation.ResourceInvocation;
import org.gatein.pc.api.invocation.response.PortletInvocationResponse;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public final class PortletSupport implements Portlet
{

   /** . */
   private final PortletContext portletContext;

   /** . */
   boolean valid;

   /** . */
   final Map<String, List<String>> state;

   /** . */
   private int invocationCount;

   /** . */
   private final ArrayList<InvocationHandler> handlers = new ArrayList<InvocationHandler>();

   /** . */
   private final PortletInfoSupport info;

   public PortletSupport(String portletId, PortletInfoSupport info)
   {
      if (portletId == null)
      {
         throw new IllegalArgumentException();
      }
      if (info == null)
      {
         throw new IllegalArgumentException();
      }

      //
      this.portletContext = PortletContext.createPortletContext(portletId);
      this.valid = true;
      this.state = new HashMap<String, List<String>>();
      this.info = info;
   }

   public void addPreference(String key, List<String> value)
   {
      info.getPreferences().addPreference(key);
      state.put(key, value);
   }

   public void addPreference(String key, List<String> value, Boolean readOnly)
   {
      info.getPreferences().addPreference(key, readOnly);
      state.put(key, value);
   }

   public int getInvocationCount()
   {
      return invocationCount;
   }

   public void addHandler(InvocationHandler handler)
   {
      handlers.add(handler);
   }

   public void assertInvocationCountIs(int expectedInvocationCount)
   {
      Assert.assertEquals(expectedInvocationCount, invocationCount);
   }

   public PortletInvocationResponse invoke(PortletInvocation invocation) throws PortletInvokerException
   {
      junit.framework.Assert.assertNotNull(invocation);

      //
      if (invocationCount == handlers.size())
      {
         throw new AssertionError();
      }

      //
      InvocationHandler handler = handlers.get(invocationCount++);

      //
      return handler.invoke(invocation);
   }

   public PortletContext getContext()
   {
      return portletContext;
   }

   public PortletInfoSupport getInfo()
   {
      return info;
   }

   public boolean isRemote()
   {
      return false;
   }

   public boolean isValid()
   {
      return valid;
   }

   public static class InvocationHandler
   {
      protected PortletInvocationResponse invoke(PortletInvocation invocation) throws PortletInvokerException
      {
         throw new PortletInvokerException("No implementations");
      }
   }

   public static abstract class ActionHandler extends InvocationHandler
   {
      protected final PortletInvocationResponse invoke(PortletInvocation invocation) throws PortletInvokerException
      {
         if (invocation instanceof ActionInvocation)
         {
            return invoke((ActionInvocation)invocation);
         }

         //
         throw new AssertionError();
      }

      protected abstract PortletInvocationResponse invoke(ActionInvocation action) throws PortletInvokerException;
   }

   public static abstract class EventHandler extends InvocationHandler
   {
      protected final PortletInvocationResponse invoke(PortletInvocation invocation) throws PortletInvokerException
      {
         if (invocation instanceof EventInvocation)
         {
            return invoke((EventInvocation)invocation);
         }

         //
         throw new AssertionError();
      }

      protected abstract PortletInvocationResponse invoke(EventInvocation action) throws PortletInvokerException;
   }

   public static abstract class RenderHandler extends InvocationHandler
   {
      protected final PortletInvocationResponse invoke(PortletInvocation invocation) throws PortletInvokerException
      {
         if (invocation instanceof RenderInvocation)
         {
            return invoke((RenderInvocation)invocation);
         }

         //
         throw new AssertionError();
      }

      protected abstract PortletInvocationResponse invoke(RenderInvocation action) throws PortletInvokerException;
   }

   public static abstract class ResourceHandler extends InvocationHandler
   {
      protected final PortletInvocationResponse invoke(PortletInvocation invocation) throws PortletInvokerException
      {
         if (invocation instanceof ResourceInvocation)
         {
            return invoke((ResourceInvocation)invocation);
         }

         //
         throw new AssertionError();
      }

      protected abstract PortletInvocationResponse invoke(ResourceInvocation action) throws PortletInvokerException;
   }
}
