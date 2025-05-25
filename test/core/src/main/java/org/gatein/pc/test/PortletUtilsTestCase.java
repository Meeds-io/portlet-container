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

import org.gatein.pc.portlet.impl.jsr168.PortletUtils;
import static org.gatein.pc.test.unit.Assert.assertEquals;

public class PortletUtilsTestCase
{

   public void testgenerateNamespaceFrom()
   {
      String name = "_09azAZ$";
      assertEquals(PortletUtils.PREFIX + name + PortletUtils.SUFFIX, PortletUtils.generateNamespaceFrom(name));

      name = "_";
      assertEquals(PortletUtils.PREFIX + "_" + PortletUtils.SUFFIX, PortletUtils.generateNamespaceFrom(name));

      name = "_é";
      assertEquals(PortletUtils.PREFIX + "__e9" + PortletUtils.SUFFIX, PortletUtils.generateNamespaceFrom(name));
   }

}
