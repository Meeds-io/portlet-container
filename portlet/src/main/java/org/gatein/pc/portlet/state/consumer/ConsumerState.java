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
package org.gatein.pc.portlet.state.consumer;

import org.gatein.pc.api.PortletStateType;

import java.util.Date;
import java.io.Serializable;

public class ConsumerState<S extends Serializable>
{

   /** . */
   private final String portletId;

   /** . */
   private final PortletStateType<S> stateType;

   /** . */
   private final S state;

   /** . */
   private final Date terminationTime;

  public ConsumerState(String porteltId, PortletStateType<S> stateType, S state)
   {
      if (porteltId == null)
      {
         throw new IllegalArgumentException("No portlet id provided");
      }
      if (state == null)
      {
         throw new IllegalArgumentException("No bytes provided");
      }
      this.portletId = porteltId;
      this.stateType = stateType;
      this.state = state;
      this.terminationTime = null;
   }

   /**
    *
    */
   public String getPortletId()
   {
      return portletId;
   }

   public PortletStateType<S> getStateType()
   {
     return stateType;
   }

   /**
    *
    */
   public S getState()
   {
      return state;
   }

   /**
    * The scheduled termination time.
    *
    * @return the termination time
    */
   public Date getTerminationTime()
   {
      return terminationTime;
   }
}
