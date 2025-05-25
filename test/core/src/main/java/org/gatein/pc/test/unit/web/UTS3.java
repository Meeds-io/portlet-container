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

@TestActor(id=UTS3.NAME)
public class UTS3 extends AbstractUniversalTestServlet
{
   /** The serialVersionUID */
   private static final long serialVersionUID = -6331478437141464198L;

   public static ThreadLocal local = new ThreadLocal();

   public static final String NAME = "ServletC";

   public final static JoinPoint SERVICE_JOIN_POINT = new JoinPoint(NAME, JoinPointType.SERVLET_SERVICE);

   protected String createComponentId(Class clazz)
   {
      return NAME;
   }

   public void reset()
   {
      local = new ThreadLocal();
   }
}