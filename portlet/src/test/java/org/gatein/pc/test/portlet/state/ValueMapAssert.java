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
package org.gatein.pc.test.portlet.state;

import junit.framework.Assert;
import org.gatein.pc.api.state.PropertyMap;

import java.util.HashSet;
import java.util.List;

public class ValueMapAssert extends Assert
{
   public static void assertEquals(PropertyMap vm1, PropertyMap vm2)
   {
      if (vm1 == null)
      {
         if (vm2 != null)
         {
            fail("Value map should be null");
         }
      }
      else
      {
         if (vm2 == null)
         {
            fail("Value map should not be null");
         }
         assertEquals("Value maps don't have the same keys", new HashSet<String>(vm1.keySet()), new HashSet<String>(vm2.keySet()));
         for (String key : vm1.keySet())
         {
            List<String> v1 = vm1.getProperty(key);
            List<String> v2 = vm2.getProperty(key);
            assertEquals("Values for key " + key + " are not equals", v1, v2);
         }
      }
   }
}
