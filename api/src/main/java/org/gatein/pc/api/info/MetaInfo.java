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

/**
 * Portlet metadata (display-name, title, short title, keywords).
 *
 */
public interface MetaInfo
{

   /** Key for display name. */
   String DISPLAY_NAME = "display-name";

   /** Key for title. */
   String TITLE = "title";

   /** Key for short title. */
   String SHORT_TITLE = "short-title";

   /** Key for locale specific keywords associated with this portlet. The keywords are separated by commas. */
   String KEYWORDS = "keywords";

   /** Key for description. */
   String DESCRIPTION = "description";

   /**
    * Return the meta value of the portlet for a specific key.
    *
    * @param key the key
    * @return an internationalized value
    */
   LocalizedString getMetaValue(String key);
}
