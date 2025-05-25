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
package org.gatein.pc.portlet.impl.spi;

import org.gatein.common.util.Tools;
import org.gatein.pc.api.Mode;
import org.gatein.pc.api.WindowState;
import org.gatein.pc.api.spi.PortalContext;
import org.gatein.pc.portlet.Version;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class AbstractPortalContext implements PortalContext
{

   /**
    * The default info returned by the Portal.
    * . */
   public static final String DEFAULT_INFO = "GateIn/" + Version.VALUE;

   /** . */
   private static final Map<String, String> EMPTY_STRING_TO_STRING_MAP = Collections.emptyMap();

   /** . */
   private static final Set<WindowState> ALL_WINDOW_STATES = Collections.unmodifiableSet(Tools.toSet(WindowState.MAXIMIZED, WindowState.MINIMIZED, WindowState.NORMAL));

   /** . */
   private static final Set<org.gatein.pc.api.Mode> ALL_MODES = Collections.unmodifiableSet(Tools.toSet(org.gatein.pc.api.Mode.EDIT, Mode.HELP, org.gatein.pc.api.Mode.VIEW));

   /** . */
   private final Set<WindowState> windowStates;

   /** . */
   private final Set<org.gatein.pc.api.Mode> modes;

   /** . */
   private final Map<String, String> props;

   public AbstractPortalContext(Set<WindowState> windowStates, Set<org.gatein.pc.api.Mode> modes, Map<String, String> props)
   {
      if (windowStates == null)
      {
         throw new IllegalArgumentException("No window states provided");
      }
      if (modes == null)
      {
         throw new IllegalArgumentException("No modes provided");
      }
      if (props == null)
      {
         throw new IllegalArgumentException("No properties provided");
      }
      this.windowStates = windowStates;
      this.modes = modes;
      this.props = props;
   }

   public AbstractPortalContext(Map<String, String> props)
   {
      this(ALL_WINDOW_STATES, ALL_MODES, props);
   }

   public AbstractPortalContext()
   {
      this(EMPTY_STRING_TO_STRING_MAP);
   }

   public String getInfo()
   {
      return DEFAULT_INFO;
   }

   public Set<WindowState> getWindowStates()
   {
      return windowStates;
   }

   public Set<org.gatein.pc.api.Mode> getModes()
   {
      return modes;
   }

   public Map<String, String> getProperties()
   {
      return props;
   }
}
