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
package org.gatein.pc.portlet.impl.jsr168.api;

import org.gatein.pc.api.invocation.ResourceInvocation;
import org.gatein.pc.portlet.impl.jsr168.ResourceRequestParameterMap;
import org.gatein.pc.portlet.impl.jsr168.PortletContainerImpl;
import org.gatein.common.util.MultiValuedPropertyMap;
import org.gatein.common.util.ParameterMap;

import javax.portlet.ResourceRequest;
import java.util.Map;
import java.util.Collections;

public class ResourceRequestImpl extends ClientDataRequestImpl implements ResourceRequest
{

   /** . */
   private final ResourceInvocation resourceInvocation;

   public ResourceRequestImpl(PortletContainerImpl container, ResourceInvocation invocation)
   {
      super(container, invocation);

      //
      this.resourceInvocation = invocation;
   }

   public String getResourceID()
   {
      return resourceInvocation.getResourceId();
   }

   public Map<String, String[]> getPrivateRenderParameterMap()
   {
      ParameterMap parameters = ((ResourceRequestParameterMap)requestParameterMap).getPrivateRenderParameters();

      //
      if (parameters != null)
      {
         return Collections.unmodifiableMap(parameters);
      }
      else
      {
         return Collections.emptyMap();
      }
   }

   public String getCacheability()
   {
      return ResourceURLImpl.toJSR168(resourceInvocation.getCacheLevel());
   }

   public String getETag()
   {
      return resourceInvocation.getValidationToken();
   }

   protected void initProperties(MultiValuedPropertyMap<String> properties)
   {
      if (resourceInvocation.getValidationToken() != null)
      {
         properties.setValue(ETAG, resourceInvocation.getValidationToken());
      }
   }
}
