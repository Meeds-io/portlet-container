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
import org.gatein.pc.portlet.container.PortletContainerContext;
import org.gatein.pc.portlet.container.PortletContainer;
import org.gatein.pc.portlet.container.PortletFilter;

import javax.portlet.Portlet;

/**
 * Contains life cycle and wiring details for the kernel environment.
 * 
 */
public interface PortletContainerObject extends PortletContainer
{

   /**
    * Set/unset the application.
    *
    * @param application the related application
    */
   void setPortletApplication(PortletApplication application);

   /**
    * Set/unset the portlet container context.
    *
    * @param context the context
    */
   void setContext(PortletContainerContext context);

   /**
    * Add a filter.
    *
    * @param filter the portlet filter
    */
   void addPortletFilter(PortletFilter filter);

   /**
    * Remove a filter.
    *
    * @param filter the portlet filter
    */
   void removePortletFilter(PortletFilter filter);

   /**
    * Creates the portlet container.
    *
    * @throws Exception any exception preventing the creation
    */
   void create() throws Exception;

   /**
    * Starts the portlet container.
    *
    * @throws Exception any exception preventing the start
    */
   void start() throws Exception;

   /**
    * Stops the portlet container.
    */
   void stop();

   /**
    * Destroys the portlet container.
    */
   void destroy();

   /**
    * Returns the current instance held by the container.
    *
    * @return the instance
    */
   Portlet getPortletInstance();
}
