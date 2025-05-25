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

import org.gatein.pc.portlet.Version;
import org.gatein.pc.portlet.impl.info.ContainerPortletApplicationInfo;
import org.gatein.pc.api.info.RuntimeOptionInfo;

import javax.portlet.PortletContext;
import javax.portlet.PortletRequestDispatcher;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Set;

public class PortletContextImpl implements PortletContext
{

   /** . */
   private ServletContext servletContext;

   /** . */
   private ContainerPortletApplicationInfo info;

   public PortletContextImpl(ServletContext servletContext)
   {
      this.servletContext = servletContext;
   }

   public String getServerInfo()
   {
      return "GateInPC/" + Version.VALUE;
   }

   public PortletRequestDispatcher getRequestDispatcher(String path)
   {
      if (path == null || !path.startsWith("/"))
      {
         return null;
      }
      RequestDispatcher rd = servletContext.getRequestDispatcher(path);
      if (rd != null)
      {
         return new PortletRequestDispatcherImpl(rd, path);
      }
      else
      {
         return null;
      }
   }

   public PortletRequestDispatcher getNamedDispatcher(String name)
   {
      if (name == null)
      {
         return null;
      }
      RequestDispatcher rd = servletContext.getNamedDispatcher(name);
      if (rd != null)
      {
         return new PortletRequestDispatcherImpl(rd);
      }
      else
      {
         return null;
      }
   }

   public InputStream getResourceAsStream(String s)
   {
      return servletContext.getResourceAsStream(s);
   }

   public int getMajorVersion()
   {
      return Version.MAJOR;
   }

   public int getMinorVersion()
   {
      return Version.MINOR;
   }

   public String getMimeType(String s)
   {
      return servletContext.getMimeType(s);
   }

   public String getRealPath(String s)
   {
      return servletContext.getRealPath(s);
   }

   public Set<String> getResourcePaths(String s)
   {
      Set<String> paths = (Set<String>)servletContext.getResourcePaths(s);
      // Some container (jetty) may return an empty set instead of null
      return (paths == null || paths.isEmpty()) ? null : paths;
   }

   public URL getResource(String s) throws MalformedURLException
   {
      if (s == null || !s.startsWith("/"))
      {
         throw new MalformedURLException("Invalid resource: " + s + ". Must not be null and start with '/'.");
      }
      return servletContext.getResource(s);
   }

   public Object getAttribute(String s)
   {
      if (s == null)
      {
         throw new IllegalArgumentException("attribute name must not be null");
      }
      return servletContext.getAttribute(s);
   }

   public Enumeration<String> getAttributeNames()
   {
      return (Enumeration<String>)servletContext.getAttributeNames();
   }

   public String getInitParameter(String s)
   {
      if (s == null)
      {
         throw new IllegalArgumentException("init parameter name must not be null");
      }
      return servletContext.getInitParameter(s);
   }

   public Enumeration<String> getInitParameterNames()
   {
      return (Enumeration<String>)servletContext.getInitParameterNames();
   }

   public void log(String s)
   {
      servletContext.log(s);
   }

   public void log(String s, Throwable throwable)
   {
      servletContext.log(s, throwable);
   }

   public void removeAttribute(String s)
   {
      if (s == null)
      {
         throw new IllegalArgumentException("attribute name must not be null");
      }
      servletContext.removeAttribute(s);
   }

   public void setAttribute(String s, Object o)
   {
      if (s == null)
      {
         throw new IllegalArgumentException("attribute name must not be null");
      }
      servletContext.setAttribute(s, o);
   }

   public String getPortletContextName()
   {
      return servletContext.getServletContextName();
   }

   public Enumeration<String> getContainerRuntimeOptions()
   {
      return Collections.enumeration(RuntimeOptionInfo.SUPPORTED_OPTIONS);
   }
}
