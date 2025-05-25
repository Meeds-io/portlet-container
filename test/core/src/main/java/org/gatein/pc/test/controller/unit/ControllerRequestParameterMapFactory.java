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
package org.gatein.pc.test.controller.unit;

import org.gatein.common.io.IOTools;
import org.gatein.common.io.Serialization;
import org.gatein.common.io.SerializationFilter;
import org.gatein.common.util.Base64;
import org.gatein.pc.api.ActionURL;
import org.gatein.pc.api.ContainerURL;
import org.gatein.pc.api.PortletURL;
import org.gatein.pc.api.RenderURL;
import org.gatein.pc.api.ResourceURL;
import org.gatein.pc.api.StateString;
import org.gatein.pc.api.cache.CacheLevel;
import org.gatein.pc.controller.state.PageNavigationalState;

import java.util.HashMap;
import java.util.Map;

public class ControllerRequestParameterMapFactory
{

   /** . */
   private final Serialization<PageNavigationalState> serialization;

   public ControllerRequestParameterMapFactory(Serialization<PageNavigationalState> serialization)
   {
      this.serialization = serialization;
   }

   public Map<String, String> encode(PageNavigationalState pageNS, String windowId, ContainerURL containerURL)
   {
      // todo: optimize by removing redundant calls based on the fact that ContainerURL has mode, window state and NS now

      Map<String, String> parameters = new HashMap<String, String>();

      //
      parameters.put(ControllerRequestParameterNames.WINDOW_ID, windowId);

      //
      String type;
      if (containerURL instanceof ActionURL)
      {
         type = ControllerRequestParameterNames.ACTION_PHASE;
      }
      else if (containerURL instanceof RenderURL)
      {
         type = ControllerRequestParameterNames.RENDER_PHASE;
      }
      else if (containerURL instanceof ResourceURL)
      {
         type = ControllerRequestParameterNames.RESOURCE_PHASE;
      }
      else
      {
         throw new Error();
      }
      parameters.put(ControllerRequestParameterNames.LIFECYCLE_PHASE, type);


      //
      String pageNavigationalState = null;
      if (pageNS != null)
      {
         byte[] bytes = IOTools.serialize(serialization, SerializationFilter.COMPRESSOR, pageNS);
         pageNavigationalState = Base64.encodeBytes(bytes, Base64.EncodingOption.USEURLSAFEENCODING);
      }

      //
      if (containerURL instanceof PortletURL)
      {
         PortletURL portletURL = (PortletURL)containerURL;

         if (portletURL.getMode() != null)
         {
            parameters.put(ControllerRequestParameterNames.MODE, portletURL.getMode().toString());
         }

         //
         if (portletURL.getWindowState() != null)
         {
            parameters.put(ControllerRequestParameterNames.WINDOW_STATE, portletURL.getWindowState().toString());
         }

         //
         if (pageNavigationalState != null)
         {
            parameters.put(ControllerRequestParameterNames.PAGE_NAVIGATIONAL_STATE, pageNavigationalState);
         }

         //
         if (containerURL instanceof ActionURL)
         {
            ActionURL actionURL = (ActionURL)containerURL;

            //
            if (actionURL.getNavigationalState() != null)
            {
               parameters.put(ControllerRequestParameterNames.NAVIGATIONAL_STATE, actionURL.getNavigationalState().getStringValue());
            }

            //
            StateString interactionState = actionURL.getInteractionState();
            parameters.put(ControllerRequestParameterNames.INTERACTION_STATE, interactionState.getStringValue());
         }
         else
         {
            RenderURL renderURL = (RenderURL)containerURL;

            //
            Map<String, String[]> changes = renderURL.getPublicNavigationalStateChanges();
            byte[] bytes = IOTools.serialize(Serialization.PARAMETER_MAP, SerializationFilter.COMPRESSOR, changes);
            String ns = Base64.encodeBytes(bytes, Base64.EncodingOption.USEURLSAFEENCODING);
            parameters.put(ControllerRequestParameterNames.PUBLIC_NAVIGATIONAL_STATE_CHANGES, ns);

            //
            StateString navigationalState = renderURL.getNavigationalState();
            if (navigationalState != null)
            {
               parameters.put(ControllerRequestParameterNames.NAVIGATIONAL_STATE, navigationalState.getStringValue());
            }
         }
      }
      else
      {
         ResourceURL resourceURL = (ResourceURL)containerURL;

         //
         StateString resourceState = resourceURL.getResourceState();
         parameters.put(ControllerRequestParameterNames.RESOURCE_STATE, resourceState.getStringValue());

         //
         String resourceId = resourceURL.getResourceId();
         if (resourceId != null)
         {
            parameters.put(ControllerRequestParameterNames.RESOURCE_ID, resourceId);
         }

         //
         CacheLevel cacheability = resourceURL.getCacheability();
         parameters.put(ControllerRequestParameterNames.RESOURCE_CACHEABILITY, cacheability.name());

         //
         if (cacheability != CacheLevel.FULL)
         {
            if (resourceURL.getNavigationalState() != null)
            {
               parameters.put(ControllerRequestParameterNames.NAVIGATIONAL_STATE, resourceURL.getNavigationalState().getStringValue());
            }

            //
            if (resourceURL.getMode() != null)
            {
               parameters.put(ControllerRequestParameterNames.MODE, resourceURL.getMode().toString());
            }

            //
            if (resourceURL.getWindowState() != null)
            {
               parameters.put(ControllerRequestParameterNames.WINDOW_STATE, resourceURL.getWindowState().toString());
            }

            if (cacheability == CacheLevel.PAGE && pageNavigationalState != null)
            {
               parameters.put(ControllerRequestParameterNames.PAGE_NAVIGATIONAL_STATE, pageNavigationalState);
            }
         }
      }

      //
      return parameters;
   }
}
