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

import org.gatein.common.i18n.LocalizedString;

import java.util.List;

/**
 * Describes a Portlet preference.
 *
 */
public interface PreferenceInfo
{
   /**
    * Retrieves the key associated to the described preference.
    *
    * @return the key associated to the described preference.
    */
   String getKey();

   /**
    * Retrieves the localized display name of the described preference.
    *
    * @return the localized display name of the described preference.
    * @see LocalizedString
    */
   LocalizedString getDisplayName();

   /**
    * Retrieves the localized description of the described preference.
    *
    * @return the localized description of the described preference.
    * @see LocalizedString
    */
   LocalizedString getDescription();

   /**
    * Return true if the preference is read-only, false otherwise or null if it cannot be determined.
    *
    * @return <code>true</code> if the described preference is read-only, <code>false</code> otherwise.
    */
   Boolean isReadOnly();

   /**
    * Return the default value or null if it cannot be determined (for instance WSRP v1 does not define it).
    *
    * @return the default value
    */
   List<String> getDefaultValue();
}
