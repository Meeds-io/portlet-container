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
package org.gatein.pc.api.spi;

import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * The user context valid during the scope of a single request.
 *
 */
public interface UserContext
{

   /**
    * Retrieves the user id or null if it is not known.
    *
    * @return the user id
    */
   String getId();

   /**
    * The user profile information keyed by P3PConstants
    *
    * @return a map containing user profile informaton
    * @see org.gatein.common.p3p.P3PConstants
    */
   Map<String, String> getInformations();

   /**
    * Return the user locale.
    *
    * @return the user locale.
    */
   Locale getLocale();

   /**
    * Retrieves the locales that the user is willing to receive information in.
    *
    * @return the locales ordered according to user preference (preferred first).
    */
   List<Locale> getLocales();

   /**
    * Set an attribute related to the user identity.
    *
    * @param attrKey the attribute key
    * @param attrValue the attribute value
    */
   void setAttribute(String attrKey, Object attrValue);

   /**
    * Returns an attribute related to the user identity.
    *
    * @param attrKey the attribute key
    * @return the attribute value
    */
   Object getAttribute(String attrKey);
}
