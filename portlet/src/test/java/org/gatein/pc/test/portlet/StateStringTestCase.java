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
package org.gatein.pc.test.portlet;

import junit.framework.TestCase;
import org.gatein.common.util.MapBuilder;
import org.gatein.pc.api.OpaqueStateString;
import org.gatein.pc.api.ParametersStateString;
import org.gatein.pc.api.StateString;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Map;

public class StateStringTestCase extends TestCase
{

   public void testMarshalling() throws IOException
   {
      check(new OpaqueStateString("blah"));
      check(ParametersStateString.create());
      check(MapBuilder.hashMap("foo", new String[]{"bar"}).get());
      check(MapBuilder.hashMap("foo", new String[]{"foo_1"}).put("bar", new String[]{"bar_1", "bar_2"}).get());
   }

   private void check(Map<String, String[]> parameters) throws IOException
   {
      check(ParametersStateString.create(parameters));
   }

   private void check(StateString parameters) throws IOException
   {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      DataOutputStream out = new DataOutputStream(baos);
      parameters.writeTo(out);
      out.close();
      byte[] bytes = baos.toByteArray();
      ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
      DataInputStream in = new DataInputStream(bais);
      StateString copy = StateString.create(in);
      assertEquals(parameters, copy);
   }
}
