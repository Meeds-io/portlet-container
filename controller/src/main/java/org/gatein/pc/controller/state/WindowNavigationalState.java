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
package org.gatein.pc.controller.state;

import org.gatein.pc.api.Mode;
import org.gatein.pc.api.StateString;

import java.io.Serializable;

/**
 * The navigational state of a window that contains the portlet navigational state, the mode and window state.
 * This class is immutable.
 *
 */
public final class WindowNavigationalState implements Serializable
{

   /** . */
   private final StateString portletNavigationalState;

   /** . */
   private final org.gatein.pc.api.Mode mode;

   /** . */
   private final org.gatein.pc.api.WindowState windowState;

   public WindowNavigationalState()
   {
      this.portletNavigationalState = null;
      this.mode = org.gatein.pc.api.Mode.VIEW;
      this.windowState = org.gatein.pc.api.WindowState.NORMAL;
   }

   public WindowNavigationalState(StateString portletNavigationalState, org.gatein.pc.api.Mode mode, org.gatein.pc.api.WindowState windowState)
   {
      this.portletNavigationalState = portletNavigationalState;
      this.mode = mode;
      this.windowState = windowState;
   }

   public StateString getPortletNavigationalState()
   {
      return portletNavigationalState;
   }

   public Mode getMode()
   {
      return mode;
   }

   public org.gatein.pc.api.WindowState getWindowState()
   {
      return windowState;
   }
}
