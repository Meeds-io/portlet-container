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
package org.gatein.pc.portlet.impl.info;

import org.gatein.pc.api.info.PortletInfo;
import org.gatein.pc.api.info.RuntimeOptionInfo;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * For now implementation that use the portlet container directly.
 *
 */
public class ContainerPortletInfo implements PortletInfo
{

   /** . */
   private final Map<Class, Object> attachments;

   /** . */
   private final ContainerCapabilitiesInfo capabilities;

   /** . */
   private final ContainerPreferencesInfo preferences;

   /** . */
   private final ContainerMetaInfo meta;

   /** . */
   private final ContainerSecurityInfo security;

   /** . */
   private final ContainerCacheInfo cache;

   /** . */
   private final ContainerEventingInfo events;

   /** . */
   private final String name;

   /** . */
   private final String applicationName;

   /** . */
   private final String className;

   /** . */
   private final Map<String, String> initParameters;

   /** . */
   private final ResourceBundleManager bundleManager;

   /** . */
   private final ContainerNavigationInfo navigation;

   /** . */
   private final List<String> filterRefs;

   /** . */
   private final Map<String, RuntimeOptionInfo> options;

   public ContainerPortletInfo(
      ContainerCapabilitiesInfo capabilities,
      ContainerPreferencesInfo preferences,
      ContainerMetaInfo meta,
      ContainerSecurityInfo security,
      ContainerCacheInfo cache,
      String name,
      String className,
      String applicationName,
      Map<String, String> initParameters,
      ResourceBundleManager bundleManager)
   {
      this.attachments = new HashMap<Class, Object>();
      this.capabilities = capabilities;
      this.preferences = preferences;
      this.meta = meta;
      this.security = security;
      this.cache = cache;
      this.events = new ContainerEventingInfo();
      this.navigation = new ContainerNavigationInfo();
      this.filterRefs = Collections.emptyList();
      this.name = name;
      this.applicationName = applicationName;
      this.className = className;
      this.initParameters = initParameters;
      this.bundleManager = bundleManager;
      this.options = Collections.emptyMap();
   }

   protected ContainerPortletInfo(
      ContainerCapabilitiesInfo capabilities,
      ContainerPreferencesInfo preferences,
      ContainerMetaInfo meta,
      ContainerSecurityInfo security,
      ContainerCacheInfo cache,
      ContainerEventingInfo events,
      ContainerNavigationInfo navigation,
      List<String> filterRefs,
      String name,
      String applicationName,
      String className,
      Map<String, String> initParameters,
      Boolean remotable,
      ResourceBundleManager bundleManager,
      Map<String, RuntimeOptionInfo> options)
   {
      this.attachments = new HashMap<Class, Object>();
      this.capabilities = capabilities;
      this.preferences = preferences;
      this.meta = meta;
      this.security = security;
      this.cache = cache;
      this.events = events;
      this.navigation = navigation;
      this.filterRefs = filterRefs;
      this.name = name;
      this.applicationName = applicationName;
      this.className = className;
      this.initParameters = initParameters;
      this.bundleManager = bundleManager;
      this.options = options;
   }

   public <T> T getAttachment(Class<T> type)
   {
      if (type == null)
      {
         throw new IllegalArgumentException("No null type accepted");
      }
      return type.cast(attachments.get(type));
   }

   public <T> void setAttachment(Class<T> type, T object)
   {
      if (type == null)
      {
         throw new IllegalArgumentException("No null type accepted");
      }
      if (object == null)
      {
         attachments.remove(type);
      }
      else
      {
         attachments.put(type, object);
      }
   }

   public String getName()
   {
      return name;
   }

   public String getApplicationName()
   {
      return applicationName;
   }

   public Map<String, RuntimeOptionInfo> getRuntimeOptionsInfo()
   {
      return Collections.unmodifiableMap(options);
   }

   public ResourceBundleManager getBundleManager()
   {
      return bundleManager;
   }

   public String getClassName()
   {
      return className;
   }

   public Set<String> getInitParameterNames()
   {
      return initParameters.keySet();
   }

   public String getInitParameter(String name)
   {
      return initParameters.get(name);
   }

   public Map<String, String> getInitParameters()
   {
      return Collections.unmodifiableMap(initParameters);
   }

   public List<String> getFilterRefs()
   {
      return filterRefs;
   }

   public ContainerCapabilitiesInfo getCapabilities()
   {
      return capabilities;
   }

   public ContainerPreferencesInfo getPreferences()
   {
      return preferences;
   }

   public ContainerMetaInfo getMeta()
   {
      return meta;
   }

   public ContainerSecurityInfo getSecurity()
   {
      return security;
   }

   public ContainerCacheInfo getCache()
   {
      return cache;
   }

   public ContainerEventingInfo getEventing()
   {
      return events;
   }

   public ContainerNavigationInfo getNavigation()
   {
      return navigation;
   }
}