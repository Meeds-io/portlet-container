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
package org.gatein.pc.test.portlet.navigation;

import junit.framework.TestCase;
import org.gatein.pc.api.ParametersStateString;
import org.gatein.pc.api.StateString;

public class StateStringTestCase extends TestCase
{
   public static final String NAME1 = "param1";
   public static final String VALUE1 = "value1";
   public static final String VALUE2 = "value2";

   public void testNavigationalState() throws Exception
   {
      ParametersStateString ns = ParametersStateString.create();
      ns.setValue(NAME1, VALUE1);
      assertEquals(VALUE1, ns.getValue(NAME1));

      String opaqueValue = ns.getStringValue();
      System.out.println("opaqueValue = " + opaqueValue);
      assertNotNull(opaqueValue);

      ns = (ParametersStateString)StateString.create(opaqueValue);
      assertEquals(VALUE1, ns.getValue(NAME1));
   }
}
