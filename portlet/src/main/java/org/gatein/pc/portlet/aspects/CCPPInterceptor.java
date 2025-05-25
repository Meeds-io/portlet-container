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

import org.gatein.pc.api.invocation.PortletInvocation;
import org.gatein.pc.portlet.PortletInvokerInterceptor;
import org.gatein.pc.api.invocation.response.PortletInvocationResponse;
import org.gatein.pc.api.PortletInvokerException;

import javax.ccpp.Profile;
import javax.ccpp.Attribute;
import javax.ccpp.Component;
import javax.ccpp.ProfileDescription;
import javax.ccpp.AttributeDescription;
import javax.ccpp.ComponentDescription;
import java.util.Set;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

/**
 * A simple implementation of CC/PP feature of JSR286.
 *
 */
public class CCPPInterceptor extends PortletInvokerInterceptor
{

   public PortletInvocationResponse invoke(PortletInvocation invocation) throws IllegalArgumentException, PortletInvokerException
   {
      Map<String, Object> requestAttributes = invocation.getRequestAttributes();

      //
      if (requestAttributes == null)
      {
         requestAttributes = new HashMap<String, Object>();
         invocation.setRequestAttributes(requestAttributes);
      }

      //
      requestAttributes.put("javax.portlet.ccpp", SIMPLE_PROFILE);

      //
      return super.invoke(invocation);
   }

   /**
    * A simple implementation of a profile.
    */
   private static final Profile SIMPLE_PROFILE = new Profile()
   {
      public Attribute getAttribute(String s)
      {
         return null;
      }

      public Set getAttributes()
      {
         return Collections.emptySet();
      }

      public Component getComponent(String s)
      {
         return null;
      }

      public Set getComponents()
      {
         return Collections.emptySet();
      }

      public ProfileDescription getDescription()
      {
         return SIMPLE_PROFILE_DESCRPTION;
      }
   };

   /**
    * A simple implementation of a profile description.
    */
   private static final ProfileDescription SIMPLE_PROFILE_DESCRPTION = new ProfileDescription()
   {
      public AttributeDescription getAttributeDescription(String s)
      {
         return null;
      }

      public Set getAttributeDescriptions()
      {
         return Collections.emptySet();
      }

      public ComponentDescription getComponentDescription(String s)
      {
         return null;
      }

      public Set getComponentDescriptions()
      {
         return Collections.emptySet();
      }

      public String getURI()
      {
         return null;
      }
   };
}
