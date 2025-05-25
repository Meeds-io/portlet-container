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
package org.gatein.pc.portlet.impl.jsr168;

import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.WindowState;
import javax.portlet.filter.PortletRequestWrapper;
import javax.portlet.filter.PortletResponseWrapper;
import jakarta.servlet.http.HttpServletRequest;

public class PortletUtils
{
   public static final String PREFIX = "jbpns";
   public static final String SUFFIX = "snpbj";
   private static final String SLASH = "/";

   /**
    * Creates a <code>WindowState</code> object based on the specified name.
    *
    * @param windowStateName the name of the window state
    * @return one of the standard WindowStates if the specified name matches one of them or a new WindowState.
    * @see javax.portlet.WindowState
    */
   public static WindowState decodeWindowState(String windowStateName)
   {
      if (WindowState.NORMAL.toString().equalsIgnoreCase(windowStateName))
      {
         return WindowState.NORMAL;
      }
      else if (WindowState.MINIMIZED.toString().equalsIgnoreCase(windowStateName))
      {
         return WindowState.MINIMIZED;
      }
      else if (WindowState.MAXIMIZED.toString().equalsIgnoreCase(windowStateName))
      {
         return WindowState.MAXIMIZED;
      }
      else
      {
         return new WindowState(windowStateName);
      }
   }

   /**
    * Creates a <code>PortletMode</code> object based on the specified name.
    *
    * @param portletModeName the name of the portlet mode
    * @return one of the standard PortletModes if the specified name matches one of them or a new PortletMode.
    * @see javax.portlet.PortletMode
    */
   public static PortletMode decodePortletMode(String portletModeName)
   {
      if (PortletMode.EDIT.toString().equalsIgnoreCase(portletModeName))
      {
         return PortletMode.EDIT;
      }
      else if (PortletMode.HELP.toString().equalsIgnoreCase(portletModeName))
      {
         return PortletMode.HELP;
      }
      else if (PortletMode.VIEW.toString().equalsIgnoreCase(portletModeName))
      {
         return PortletMode.VIEW;
      }
      else
      {
         return new PortletMode(portletModeName);
      }
   }

   /**
    * Generates a namespace suitable for Portlet prefixing of tokens that need to be unique in an aggregated page.
    *
    * @param windowId the window id
    * @return the namespace value
    * @since 2.6
    */
   public static String generateNamespaceFrom(String windowId)
   {
      int length = windowId.length();
      StringBuffer tmp = new StringBuffer(length + 10);
      tmp.append('G');
      for (int i = windowId.lastIndexOf(SLASH) + 1; i < length; i++)
      {
         char c = windowId.charAt(i);
         if (((int)c >= 65 && (int)c <= 90) || ((int)c >= 97 && (int)c <= 122) || ((int)c >= 48 && (int)c <= 57) || ((int)c == 95) || (int)c == 36)
         {
            tmp.append(c);
         }
         else
         {
            tmp.append('_');
            tmp.append(Character.forDigit((((int)c) & 0XF0) >> 4, 16));
            tmp.append(Character.forDigit((((int)c) & 0X0F), 16));
         }
      }
      return tmp.toString();
   }

   /**
    * Returns the original context path before dispatch is made
    * This will ensure to get the original root path
    * in all Servlet Containers (Tomcat / JBoss / Wildfly)
    *
    * @param request HTTP Request
    * @return the root path retrieved from HTTP request URI
    */
   public static String getPortalContextPath(HttpServletRequest request) {
     String requestContext = request.getContextPath();
     if (!request.getRequestURI().contains(request.getContextPath())) {
       if(request.getRequestURI().indexOf("/", 2) > 0) {
         // URI is of type /CONTEXT/PATH
         requestContext = request.getRequestURI().substring(0, request.getRequestURI().indexOf("/", 2));
       } else {
         // URI is of type /CONTEXT
         requestContext = request.getRequestURI();
       }
     }
     return requestContext;
   }

   public static <U extends PortletRequest> U unwrap(PortletRequest wrapped, Class<U> unwrapped)
   {
      while (true)
      {
         if (wrapped instanceof PortletRequestWrapper)
         {
            PortletRequestWrapper wrapper = (PortletRequestWrapper)wrapped;
            wrapped = wrapper.getRequest();
         }
         else if (unwrapped.isInstance(wrapped))
         {
            return unwrapped.cast(wrapped);
         }
         else
         {
            throw new IllegalArgumentException();
         }
      }
   }

   public static <U extends PortletResponse> U unwrap(PortletResponse wrapped, Class<U> unwrapped)
   {
      while (true)
      {
         if (wrapped instanceof PortletResponseWrapper)
         {
            PortletResponseWrapper wrapper = (PortletResponseWrapper)wrapped;
            wrapped = wrapper.getResponse();
         }
         else if (unwrapped.isInstance(wrapped))
         {
            return unwrapped.cast(wrapped);
         }
         else
         {
            throw new IllegalArgumentException();
         }
      }
   }
}