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
package org.gatein.pc.test.unit.web;

import org.gatein.pc.test.unit.JoinPoint;
import org.gatein.pc.test.unit.JoinPointType;
import org.gatein.pc.test.unit.annotations.TestActor;


@TestActor(id=UTP1.NAME)
public class UTP1 extends AbstractUniversalTestPortlet
{
   public static ThreadLocal local = new ThreadLocal();

   public static ThreadLocal local1 = new ThreadLocal();

   public static ThreadLocal local2 = new ThreadLocal();

   public static ThreadLocal local3 = new ThreadLocal();

   public static ThreadLocal local4 = new ThreadLocal();

   public static ThreadLocal local5 = new ThreadLocal();

   public static Object holder;

   public static final String NAME = "Portlet1";

   public final static JoinPoint RENDER_JOIN_POINT = new JoinPoint(NAME, JoinPointType.PORTLET_RENDER);

   public final static JoinPoint EVENT_JOIN_POINT = new JoinPoint(NAME, JoinPointType.PORTLET_EVENT);

   public final static JoinPoint ACTION_JOIN_POINT = new JoinPoint(NAME, JoinPointType.PORTLET_ACTION);

   public final static JoinPoint RESOURCE_JOIN_POINT = new JoinPoint(NAME, JoinPointType.PORTLET_RESOURCE);

   /** Resets helper variables */
   public void reset()
   {
      local = new ThreadLocal();
      local1 = new ThreadLocal();
      local2 = new ThreadLocal();
      local3 = new ThreadLocal();
      local4 = new ThreadLocal();
      local5 = new ThreadLocal();

      holder = null;
   }


}
