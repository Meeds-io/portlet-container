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

import org.gatein.pc.api.WindowState;
import org.gatein.common.i18n.LocalizedString;
import org.gatein.pc.api.info.WindowStateInfo;

import java.util.Locale;

public class WindowStateInfoSupport implements WindowStateInfo
{

   /** . */
   private final LocalizedString description;

   /** . */
   private final org.gatein.pc.api.WindowState windowState;

   public WindowStateInfoSupport(WindowState mode)
   {
      this.description = new LocalizedString(mode + " window state", Locale.ENGLISH);
      this.windowState = mode;
   }

   public LocalizedString getDescription()
   {
      return description;
   }

   public org.gatein.pc.api.WindowState getWindowState()
   {
      return windowState;
   }

   public String getWindowStateName()
   {
      return windowState.toString();
   }
}
