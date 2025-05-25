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
package org.gatein.pc.portlet.state.producer;

import org.gatein.pc.api.Portlet;
import org.gatein.pc.api.PortletContext;
import org.gatein.pc.api.info.PortletInfo;

public class ProducerPortlet implements Portlet
{

   /** . */
   private final PortletContext context;

   /** . */
   private final Portlet next;

   public ProducerPortlet(PortletContext context, Portlet next)
   {
      this.context = context;
      this.next = next;
   }

   public PortletContext getContext()
   {
      return context;
   }

   public PortletInfo getInfo()
   {
      return next.getInfo();
   }

   public boolean isRemote()
   {
      return next.isRemote();
   }

   public String toString()
   {
      return "ProducerPortlet[" + context + ",delegate=" + next + "]";
   }

   public Portlet getNext()
   {
      return next;
   }
}
