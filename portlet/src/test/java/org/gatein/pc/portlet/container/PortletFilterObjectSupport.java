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

import org.gatein.pc.portlet.container.object.PortletFilterObject;

public class PortletFilterObjectSupport extends ObjectSupport implements PortletFilterObject
{

   /** . */
   PortletApplication application;

   /** . */
   PortletFilterContext context;

   public PortletFilterObjectSupport(String id)
   {
      super(id);
   }

   public void setPortletApplication(PortletApplication application)
   {
      this.application = application;
   }

   public PortletApplication getPortletApplication()
   {
      return application;
   }

   public void setContext(PortletFilterContext context)
   {
      this.context = context;
   }

   public PortletFilterContext getContext()
   {
      return context;
   }

}
