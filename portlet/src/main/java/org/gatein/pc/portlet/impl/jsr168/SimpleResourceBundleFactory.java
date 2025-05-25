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

import org.gatein.common.i18n.ResourceBundleFactory;

import java.util.ResourceBundle;
import java.util.Locale;

public class SimpleResourceBundleFactory implements ResourceBundleFactory
{

   /** . */
   private final ClassLoader classLoader;

   /** . */
   private final String baseName;

   public SimpleResourceBundleFactory(ClassLoader classLoader, String baseName)
   {
      this.classLoader = classLoader;
      this.baseName = baseName;
   }

   public ResourceBundle getBundle(Locale locale) throws IllegalArgumentException
   {
      if (locale == null)
      {
         throw new IllegalArgumentException();
      }
      if (baseName != null)
      {
         try
         {
            return ResourceBundle.getBundle(baseName, locale, classLoader);
         }
         catch (Exception e)
         {
            return null;
         }
      }
      else
      {
         return null;
      }
   }
}
