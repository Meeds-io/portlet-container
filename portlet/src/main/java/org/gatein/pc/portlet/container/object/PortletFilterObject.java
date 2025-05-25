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
package org.gatein.pc.portlet.container.object;

import org.gatein.pc.portlet.container.PortletApplication;
import org.gatein.pc.portlet.container.PortletFilter;
import org.gatein.pc.portlet.container.PortletFilterContext;

public interface PortletFilterObject extends PortletFilter
{

   /**
    * Set the application on the portlet filter.
    * 
    * @param application the application
    */
   void setPortletApplication(PortletApplication application);

   /**
    * Set the context required by that filter.
    *
    * @param context the context
    */
   void setContext(PortletFilterContext context);

   /**
    * Creates the portlet filter.
    *
    * @throws Exception any exception preventing the creation
    */
   void create() throws Exception;

   /**
    * Starts the portlet filer.
    *
    * @throws Exception any exception preventing the start
    */
   void start() throws Exception;

   /**
    * Stops the portlet filter.
    */
   void stop();

   /**
    * Destroys the portlet filter.
    */
   void destroy();
}
