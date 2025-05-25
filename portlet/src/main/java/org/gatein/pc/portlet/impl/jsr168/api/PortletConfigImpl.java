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

import org.gatein.common.util.ParameterMap;
import org.gatein.pc.portlet.impl.info.ContainerParameterInfo;
import org.gatein.pc.portlet.impl.info.ContainerPortletApplicationInfo;
import org.gatein.pc.portlet.impl.info.ContainerPortletInfo;
import org.gatein.pc.api.info.RuntimeOptionInfo;
import org.gatein.pc.portlet.impl.info.ResourceBundleManager;

import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class PortletConfigImpl implements PortletConfig
{

   /** . */
   private final ContainerPortletInfo portletInfo;

   /** . */
   private final ContainerPortletApplicationInfo portletApplicationInfo;

   /** . */
   private final PortletContextImpl portletContext;

   /** . */
   private ResourceBundleManager bundleMgr;

   /** . */
   private List<QName> publishingEventQNames;

   /** . */
   private List<QName> processingEventQNames;

   /** . */
   private List<String> publicRenderParameterNames;

   /** . */
   private Map<String, String[]> containerRuntimeOptions;

   public PortletConfigImpl(
      ContainerPortletInfo portletInfo,
      ContainerPortletApplicationInfo portletApplicationInfo,
      PortletContextImpl portletContext,
      ResourceBundleManager bundleMgr)
   {
      //
      List<String> publicRenderParameterNames = new ArrayList<String>();
      for (ContainerParameterInfo parameterInfo : portletInfo.getNavigation().getPublicParameters())
      {
         publicRenderParameterNames.add(parameterInfo.getId());
      }

      //
      ParameterMap tmp = null;
      for (RuntimeOptionInfo option : portletInfo.getRuntimeOptionsInfo().values())
      {
         String name = option.getName();
         if (RuntimeOptionInfo.SUPPORTED_OPTIONS.contains(name))
         {
            if (tmp == null)
            {
               tmp = new ParameterMap(ParameterMap.AccessMode.get(true, false));
            }

            //
            String[] values = option.getValues().toArray(new String[option.getValues().size()]);
            tmp.setValues(name, values);
         }
      }

      //
      Map<String, String[]> containerRuntimeOptions;
      if (tmp != null)
      {
         containerRuntimeOptions = Collections.unmodifiableMap(tmp);
      }
      else
      {
         containerRuntimeOptions = Collections.emptyMap();
      }

      //
      this.portletInfo = portletInfo;
      this.portletApplicationInfo = portletApplicationInfo;
      this.portletContext = portletContext;
      this.bundleMgr = bundleMgr;
      this.publishingEventQNames = new ArrayList<QName>(portletInfo.getEventing().getProducedEvents().keySet());
      this.processingEventQNames = new ArrayList<QName>(portletInfo.getEventing().getConsumedEvents().keySet());
      this.publicRenderParameterNames = publicRenderParameterNames;
      this.containerRuntimeOptions = containerRuntimeOptions;
   }

   public String getPortletName()
   {
      return portletInfo.getName();
   }

   public PortletContext getPortletContext()
   {
      return portletContext;
   }

   /** May return null ? the spec does not specify what happens when the bundle is not found for the locale. */
   public ResourceBundle getResourceBundle(Locale locale)
   {
      return bundleMgr.getResourceBundle(locale);
   }

   public String getInitParameter(String s)
   {
      if (s == null)
      {
         throw new IllegalArgumentException("name must not be null");
      }
      return portletInfo.getInitParameter(s);
   }

   public Enumeration<String> getInitParameterNames()
   {
      return Collections.enumeration(portletInfo.getInitParameterNames());
   }

   public Enumeration<String> getPublicRenderParameterNames()
   {
      return Collections.enumeration(publicRenderParameterNames);
   }

   public String getDefaultNamespace()
   {
      return portletApplicationInfo.getDefaultNamespace();
   }

   public Enumeration<QName> getPublishingEventQNames()
   {
      return Collections.enumeration(publishingEventQNames);
   }

   public Enumeration<QName> getProcessingEventQNames()
   {
      return Collections.enumeration(processingEventQNames);
   }

   public Enumeration<Locale> getSupportedLocales()
   {
      return Collections.enumeration(portletInfo.getCapabilities().getAllLocales());
   }

   public Map<String, String[]> getContainerRuntimeOptions()
   {
      return containerRuntimeOptions;
   }
}
