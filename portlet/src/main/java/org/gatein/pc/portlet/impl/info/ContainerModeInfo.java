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

import org.gatein.pc.api.Mode;
import org.gatein.common.i18n.LocalizedString;
import org.gatein.pc.api.info.ModeInfo;

import java.util.Locale;

class ContainerModeInfo implements ModeInfo
{

   /** . */
   private static final LocalizedString DEFAULT_DESCRIPTION = new LocalizedString("Default Portlet mode description.", Locale.ENGLISH);

   /** . */
   private final org.gatein.pc.api.Mode mode;

   /** . */
   private final LocalizedString description;

   public ContainerModeInfo(org.gatein.pc.api.Mode mode, LocalizedString description)
   {
      if (mode == null)
      {
         throw new IllegalArgumentException("Specified mode cannot be null!");
      }
      if (description == null)
      {
         throw new IllegalArgumentException("Specified description cannot be null!");
      }

      //
      this.mode = mode;
      this.description = description;
   }

   public ContainerModeInfo(Mode mode)
   {
      this(mode, DEFAULT_DESCRIPTION);
   }

   public boolean equals(Object o)
   {
      if (this == o)
      {
         return true;
      }
      if (o == null || getClass() != o.getClass())
      {
         return false;
      }

      ContainerModeInfo that = (ContainerModeInfo)o;

      return mode.equals(that.mode);
   }

   public int hashCode()
   {
      return mode.hashCode();
   }

   public LocalizedString getDescription()
   {
      return DEFAULT_DESCRIPTION; // fix-me
   }

   public org.gatein.pc.api.Mode getMode()
   {
      return mode;
   }

   public String getModeName()
   {
      return mode.toString();
   }
}