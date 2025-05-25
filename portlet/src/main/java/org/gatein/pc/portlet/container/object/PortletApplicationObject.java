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

import org.gatein.pc.portlet.container.PortletApplicationContext;
import org.gatein.pc.portlet.container.PortletContainer;
import org.gatein.pc.portlet.container.PortletApplication;
import org.gatein.pc.portlet.container.PortletFilter;

/**
 * Contains life cycle and wiring details for the kernel environment.
 * 
 */
public interface PortletApplicationObject extends PortletApplication
{

   /**
    * Set the context required by that application.
    *
    * @param context the context
    */
   void setContext(PortletApplicationContext context);

   /**
    * Returns the context related to this application.
    *
    * @return the context
    */
   PortletApplicationContext getContext();

   /**
    * Add a container.
    *
    * @param container the container
    */
   void addPortletContainer(PortletContainer container);

   /**
    * Remove a container.
    *
    * @param container the container
    */
   void removePortletContainer(PortletContainer container);

   /**
    * Add a filter.
    *
    * @param filter the filter
    */
   void addPortletFilter(PortletFilter filter);

   /**
    * Remove a filter.
    *
    * @param filter the filter
    */
   void removePortletFilter(PortletFilter filter);

   /**
    * Starts the application only. It does not take care of starting its components.
    *
    * @throws Exception any exception preventing the start
    */
   void start() throws Exception;

   /**
    * Stops the application only. It does not take care of stopping its components.
    */
   void stop();
}
