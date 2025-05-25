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
package org.gatein.pc.test.controller.unit;

import org.gatein.pc.api.Portlet;
import org.gatein.pc.api.PortletInvokerException;
import org.gatein.pc.test.controller.AbstractRendererContext;
import org.gatein.pc.test.controller.unit.PortletControllerContextImpl;

import java.util.Collection;

public class RendererContextImpl extends AbstractRendererContext
{

   /** . */
   private final Collection<Portlet> portlets;

   public RendererContextImpl(PortletControllerContextImpl portletControllerContext) throws PortletInvokerException
   {
      super(portletControllerContext);

      //
      this.portlets = portletControllerContext.getPortlets();
   }

   public Collection<Portlet> getPortlets()
   {
      return portlets;
   }
}
