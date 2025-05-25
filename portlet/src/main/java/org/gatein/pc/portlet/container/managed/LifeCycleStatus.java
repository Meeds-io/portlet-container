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
package org.gatein.pc.portlet.container.managed;

public enum LifeCycleStatus
{

   INITIALIZED(0), CREATED(1), STARTED(2);

   /** . */
   private final int stage;

   private LifeCycleStatus(int stage)
   {
      this.stage = stage;
   }

   public int getStage()
   {
      return stage;
   }

   public LifeCycleStatus getPromotion()
   {
      return getByStage(stage + 1);
   }

   public LifeCycleStatus getDemotion()
   {
      return getByStage(stage - 1);
   }

   private static LifeCycleStatus getByStage(int stage)
   {
      switch (stage)
      {
         case 0:
            return INITIALIZED;
         case 1:
            return CREATED;
         case 2:
            return STARTED;
         default:
            return null;
      }
   }
}
