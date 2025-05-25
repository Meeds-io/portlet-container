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
package org.gatein.pc.test;

import org.junit.Test;

import static org.gatein.pc.test.unit.Assert.assertEquals;

public class StringCodecTestCase
{

   private static final char EURO_CHAR = '\u20AC';

   @Test
   public void testA()
   {

      assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", StringCodec.encode("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
      assertEquals("abcdefghijklmnopqrstuvwxyz", StringCodec.encode("abcdefghijklmnopqrstuvwxyz"));
      assertEquals("0123456789", StringCodec.encode("0123456789"));
      assertEquals("_2F", StringCodec.encode("/"));
      assertEquals("_40", StringCodec.encode("@"));
      assertEquals("_E2_82_AC", StringCodec.encode(Character.toString(EURO_CHAR)));
      assertEquals("A_E2_82_ACB_40C", StringCodec.encode("A" + EURO_CHAR + "B@C"));

   }

   @Test
   public void testB()
   {
      assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", StringCodec.decode(StringCodec.encode("ABCDEFGHIJKLMNOPQRSTUVWXYZ")));
      assertEquals("abcdefghijklmnopqrstuvwxyz", StringCodec.decode(StringCodec.encode("abcdefghijklmnopqrstuvwxyz")));
      assertEquals("0123456789", StringCodec.decode(StringCodec.encode("0123456789")));
      assertEquals("/", StringCodec.decode(StringCodec.encode("/")));
      assertEquals("@", StringCodec.decode(StringCodec.encode("@")));
      assertEquals(Character.toString(EURO_CHAR), StringCodec.decode(StringCodec.encode(Character.toString(EURO_CHAR))));
      assertEquals("A" + EURO_CHAR + "B@C", StringCodec.decode(StringCodec.encode("A" + EURO_CHAR + "B@C")));
   }

}
