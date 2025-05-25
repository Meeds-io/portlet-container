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
package org.gatein.pc.portlet.support.info;

import org.gatein.pc.api.Mode;
import org.gatein.common.i18n.LocalizedString;
import org.gatein.pc.api.info.ModeInfo;

import java.util.Locale;

public class ModeInfoSupport implements ModeInfo
{

   /** . */
   private final LocalizedString description;

   /** . */
   private final Mode mode;

   public ModeInfoSupport(org.gatein.pc.api.Mode mode)
   {
      this.description = new LocalizedString(mode + " mode", Locale.ENGLISH);
      this.mode = mode;
   }

   public LocalizedString getDescription()
   {
      return description;
   }

   public Mode getMode()
   {
      return mode;
   }

   public String getModeName()
   {
      return mode.toString();
   }
}
