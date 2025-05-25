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
package org.gatein.pc.controller.request;

/**
 * Any request made to a portlet container.
 *
 */
public abstract class ContainerRequest extends ControllerRequest
{

   /** . */
   protected final String windowId;

   /**
    * @param windowId the target window id
    * @throws IllegalArgumentException if the window id is null
    */
   protected ContainerRequest(String windowId) throws IllegalArgumentException
   {
      if (windowId == null)
      {
         throw new IllegalArgumentException("No null window id accepted");
      }

      this.windowId = windowId;
   }

   public String getWindowId()
   {
      return windowId;
   }

}
