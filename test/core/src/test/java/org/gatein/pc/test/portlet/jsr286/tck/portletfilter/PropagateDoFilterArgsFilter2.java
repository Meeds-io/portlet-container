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
package org.gatein.pc.test.portlet.jsr286.tck.portletfilter;

import org.gatein.pc.test.portlet.jsr286.common.AbstractPortletFilter;
import org.gatein.pc.test.portlet.jsr286.common.CustomRenderRequest;
import org.gatein.pc.test.portlet.jsr286.common.CustomRenderResponse;
import org.gatein.pc.test.portlet.jsr286.common.CustomActionRequest;
import org.gatein.pc.test.portlet.jsr286.common.CustomActionResponse;
import org.gatein.pc.test.portlet.jsr286.common.CustomEventRequest;
import org.gatein.pc.test.portlet.jsr286.common.CustomEventResponse;
import org.gatein.pc.test.portlet.jsr286.common.CustomResourceRequest;
import org.gatein.pc.test.portlet.jsr286.common.CustomResourceResponse;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventResponse;
import javax.portlet.ActionRequest;
import javax.portlet.EventRequest;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.RenderFilter;
import javax.portlet.filter.ResourceFilter;
import javax.portlet.filter.ActionFilter;
import javax.portlet.filter.EventFilter;
import java.io.IOException;

public class PropagateDoFilterArgsFilter2 extends AbstractPortletFilter
   implements RenderFilter, ResourceFilter, ActionFilter, EventFilter
{

   /** . */
   public static ActionRequest consumedActionRequest;

   /** . */
   public static ActionResponse consumedActionResponse;

   /** . */
   public static EventRequest consumedEventRequest;

   /** . */
   public static EventResponse consumedEventResponse;

   /** . */
   public static RenderRequest consumedRenderRequest;

   /** . */
   public static RenderResponse consumedRenderResponse;

   /** . */
   public static ResourceRequest consumedResourceRequest;

   /** . */
   public static ResourceResponse consumedResourceResponse;

   /** . */
   public static CustomActionRequest publishedActionRequest;

   /** . */
   public static CustomActionResponse publishedActionResponse;

   /** . */
   public static CustomEventRequest publishedEventRequest;

   /** . */
   public static CustomEventResponse publishedEventResponse;

   /** . */
   public static CustomRenderRequest publishedRenderRequest;

   /** . */
   public static CustomRenderResponse publishedRenderResponse;

   /** . */
   public static CustomResourceRequest publishedResourceRequest;

   /** . */
   public static CustomResourceResponse publishedResourceResponse;

   public void doFilter(RenderRequest req, RenderResponse resp, FilterChain chain) throws IOException, PortletException
   {
      consumedRenderRequest = req;
      consumedRenderResponse = resp;

      //
      try
      {
         chain.doFilter(publishedRenderRequest = new CustomRenderRequest(req), publishedRenderResponse = new CustomRenderResponse(resp));
      }
      finally
      {
         consumedRenderRequest = null;
         consumedRenderResponse = null;
         publishedRenderRequest = null;
         publishedRenderResponse = null;
      }
   }

   public void doFilter(ActionRequest req, ActionResponse resp, FilterChain chain) throws IOException, PortletException
   {
      consumedActionRequest = req;
      consumedActionResponse = resp;

      //
      try
      {
         chain.doFilter(publishedActionRequest = new CustomActionRequest(req), publishedActionResponse = new CustomActionResponse(resp));
      }
      finally
      {
         consumedActionRequest = null;
         consumedActionResponse = null;
         publishedActionRequest = null;
         publishedActionResponse = null;
      }
   }

   public void doFilter(EventRequest req, EventResponse resp, FilterChain chain) throws IOException, PortletException
   {
      consumedEventRequest = req;
      consumedEventResponse = resp;

      //
      try
      {
         chain.doFilter(publishedEventRequest = new CustomEventRequest(req), publishedEventResponse = new CustomEventResponse(resp));
      }
      finally
      {
         consumedEventRequest = null;
         consumedEventResponse = null;
         publishedEventRequest = null;
         publishedEventResponse = null;
      }
   }

   public void doFilter(ResourceRequest req, ResourceResponse resp, FilterChain chain) throws IOException, PortletException
   {
      consumedResourceRequest = req;
      consumedResourceResponse = resp;

      //
      try
      {
         chain.doFilter(publishedResourceRequest = new CustomResourceRequest(req), publishedResourceResponse = new CustomResourceResponse(resp));
      }
      finally
      {
         consumedResourceRequest = null;
         consumedResourceResponse = null;
         publishedResourceRequest = null;
         publishedResourceResponse = null;
      }
   }
}