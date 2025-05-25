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

import jakarta.servlet.ServletContext;

/**
 * The context provided to a portlet application by its envronment. For now it manages the application external resources
 * such as the servlet context and the application classloader. It manages also the life cycle of the
 * application and its components.
 *
 */
public interface PortletApplicationContext
{
   /**
    * Return the servlet context.
    *
    * @return the servlet context
    */
   ServletContext getServletContext();

   /**
    * Returns the context path of the web application
    * 
    * @return the context path
    */
   String getContextPath();
   
   /**
    * Return the classloader.
    *
    * @return the classloader
    */
   ClassLoader getClassLoader();

   /**
    * Attempt to start the portlet application.
    */
   void managedStart();

   /**
    * Stop the portlet application.
    */
   void managedStop();
}
