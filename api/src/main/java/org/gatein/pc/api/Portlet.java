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
package org.gatein.pc.api;

import org.gatein.pc.api.info.PortletInfo;
import org.gatein.pc.api.PortletContext;

/**
 * Defines a logical portlet.
 *
 */
public interface Portlet
{
   /**
    * Return the portlet context.
    *
    * @return the portlet context
    */
   PortletContext getContext();

   /**
    * Return the portlet info.
    *
    * @return the portlet info
    */
   PortletInfo getInfo();

   /**
    * Determines whether the described portlet is remote or not.
    *
    * @return <code>true</code> if the described portlet runs in a remote context (such as WSRP), <code>false</code>
    *         otherwise
    */
   boolean isRemote();
}
