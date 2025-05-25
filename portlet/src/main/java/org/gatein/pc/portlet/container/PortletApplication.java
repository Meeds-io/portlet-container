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
package org.gatein.pc.portlet.container;

import java.util.Collection;

/**
 * A portlet application exposed for management.
 *
 */
public interface PortletApplication
{
   /**
    * Return the web app id.
    *
    * @return the id
    */
   String getId();

   /**
    * Returns the set of related portlet containers.
    *
    * @return the portlet containers
    */
   Collection<? extends PortletContainer> getPortletContainers();

   /**
    * Returns a specific container or null if it does not exist
    *
    * @param containerId the container id
    * @return the portlet container
    */
   PortletContainer getPortletContainer(String containerId);

   /**
    * Returns the context of the portlet application.
    *
    * @return the context
    */
   PortletApplicationContext getContext();


}
