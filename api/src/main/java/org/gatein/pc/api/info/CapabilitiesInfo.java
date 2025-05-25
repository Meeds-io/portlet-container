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
package org.gatein.pc.api.info;

import org.gatein.common.net.media.MediaType;
import org.gatein.pc.api.WindowState;

import java.util.Set;
import java.util.Locale;

/**
 * Gathers capability information (portlet modes, window states, supported media types and locales) regarding a portlet.
 *
 */
public interface CapabilitiesInfo
{
   /**
    * Retrieves all the Media types supported by the associated Portlet.
    *
    * @return a Set of String representation of supported Media types
    */
   Set<MediaType> getMediaTypes();

   /**
    * Retrieves all the portlet modes supported by the associated Portlet.
    *
    * @return a Set of {@link ModeInfo} reprensenting the supported portlet modes
    */
   Set<ModeInfo> getAllModes();

   /**
    * Retrieves the portlet modes supported by the associated Portlet for the specified Media type.
    *
    * @param mediaType the media type
    * @return a Set of {@link ModeInfo} reprensenting the supported portlet modes for the specified Media type
    */
   Set<ModeInfo> getModes(MediaType mediaType);

   /**
    * Returns a mode info matching a specifed mode or null.
    *
    * @param mode the mode
    * @return the mode info
    */
   ModeInfo getMode(org.gatein.pc.api.Mode mode);

   /**
    * Retrieves all the window states supported by the associated Portlet.
    *
    * @return a Set of {@link WindowStateInfo} reprensenting the supported window states
    */
   Set<WindowStateInfo> getAllWindowStates();

   /**
    * Retrieves the window states supported by the associated Portlet for the specified MIME type.
    *
    * @param mimeType the mime type
    * @return a Set of {@link ModeInfo} reprensenting the supported window states for the specified MIME type
    */
   Set<WindowStateInfo> getWindowStates(MediaType mimeType);

   /**
    * Returns a window state info matching a specifed window state or null.
    *
    * @param windowState the window state
    * @return the window state info
    */
   WindowStateInfo getWindowState(WindowState windowState);

   /**
    * Retrieves all the locales supported by the associated Portlet.
    *
    * @return the Set of supported {@link java.util.Locale}s
    */
   Set<Locale> getAllLocales();

   /**
    * Retrieves the locales supported by the associated Portlet for the specified MIME type.
    *
    * @param mimeType the mime type
    * @return a Set of supported {@link java.util.Locale}s for the specified MIME type
    */
   Set<Locale> getLocales(MediaType mimeType);
}
