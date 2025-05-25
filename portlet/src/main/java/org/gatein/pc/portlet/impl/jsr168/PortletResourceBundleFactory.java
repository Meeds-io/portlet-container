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

import org.gatein.common.util.EmptyResourceBundle;
import org.gatein.common.i18n.ParentChildResourceBundle;
import org.gatein.common.i18n.ResourceBundleFactory;
import org.gatein.pc.portlet.impl.info.ContainerPortletInfo;
import org.gatein.pc.portlet.impl.info.ResourceBundleManager;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Manage resource bundles for a portlet.
 *
 */
public class PortletResourceBundleFactory implements ResourceBundleFactory
{

   public static ResourceBundleManager createResourceBundleManager(ResourceBundleManager bundleMgr, ContainerPortletInfo containerInfo)
   {
      if (bundleMgr == null)
      {
         throw new IllegalArgumentException("Need a non null classloader");
      }
      if (containerInfo == null)
      {
         throw new IllegalArgumentException("Need non null meta data");
      }

      // Create factory
      PortletResourceBundleFactory factory = new PortletResourceBundleFactory(bundleMgr, containerInfo);

      // Create manager
      ResourceBundleManager manager = new ResourceBundleManager(EmptyResourceBundle.INSTANCE, factory);

      // Preload declared locales
//      for (Iterator i = metaData.getSupportedLocales().iterator();i.hasNext();)
//      {
//         Locale locale = (Locale)i.next();
//         manager.getResourceBundle(locale);
//      }

      //
      return manager;
   }

   /** The class loader to load resource bundle from. */
   private final ResourceBundleManager bundleMgr;

   private final ResourceBundle infoBundle;

   public PortletResourceBundleFactory(ResourceBundleManager bundleMgr, ContainerPortletInfo containerInfo)
   {
      if (bundleMgr == null)
      {
         throw new IllegalArgumentException("Need a non null classloader");
      }
      if (containerInfo == null)
      {
         throw new IllegalArgumentException("Need non null meta data");
      }

      //
      this.bundleMgr = bundleMgr;
      this.infoBundle = new InlineBundle(containerInfo);
   }

   public ResourceBundle getBundle(Locale locale)
   {
      if (locale == null)
      {
         throw new IllegalArgumentException("Locale cannot be null");
      }

      //
      ResourceBundle bundle = bundleMgr.getResourceBundle(locale);

      if (bundle == null)
      {
         bundle = infoBundle;
         // log.warn("Bundle " + baseName + " for locale " + locale + " not found");
      }
      else
      {
         bundle = new ParentChildResourceBundle(infoBundle, bundle);
         // log.debug("Created bundle " + baseName + " for locale " + locale);
      }

      //
      return bundle;
   }
}
