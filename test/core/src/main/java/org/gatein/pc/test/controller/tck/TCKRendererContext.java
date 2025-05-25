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
package org.gatein.pc.test.controller.tck;

import org.gatein.pc.controller.state.PageNavigationalState;
import org.gatein.pc.test.controller.AbstractRendererContext;
import org.gatein.pc.api.Portlet;
import org.gatein.pc.api.PortletInvokerException;
import org.gatein.pc.api.NoSuchPortletException;

import java.util.Collection;
import java.util.ArrayList;

public class TCKRendererContext extends AbstractRendererContext
{

   /** . */
   private final Collection<Portlet> involvedPortlets;

   public TCKRendererContext(
      TCKPortletControllerContext portletControllerContext,
      PageNavigationalState tckPageNavigationalState) throws PortletInvokerException
   {
      super(portletControllerContext);

      //
      Collection<Portlet> involvedPortlets = new ArrayList<Portlet>();

      // Page state could be null for some requests
      if (tckPageNavigationalState != null)
      {
         for (String involvedPortletId : tckPageNavigationalState.getWindowIds())
         {
            try
            {
               Portlet involvedPortlet = portletControllerContext.getPortlet(involvedPortletId);
               involvedPortlets.add(involvedPortlet);
            }
            catch (NoSuchPortletException e)
            {
               // It happen when a portlet becomes unavailable and
               // therefore is removed from the available portlet
               // in that case it should not prevent the other portlets to be
               // rendered
            }
         }
      }

      //
      this.involvedPortlets = involvedPortlets;
   }

   public Collection<Portlet> getPortlets()
   {
      return involvedPortlets;
   }
}
