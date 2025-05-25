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
package org.gatein.pc.test.portlet.info;

public class ModeInfoTest extends AbstractInfoTest
{

   public ModeInfoTest()
   {
      super("ModeInfoTest");
   }

//   public void execute()
//   {
//      ManagedPortletContainer container1 = registry.getManagedPortletApplication("/test-info").getManagedPortletContainer("ModePortlet1");
//      ManagedPortletContainer container2 = registry.getManagedPortletApplication("/test-info").getManagedPortletContainer("ModePortlet2");
//      CapabilitiesInfo capaInfo = container1.getInfo().getCapabilities();
//
//      //Portlet 1 with VIEW, EDIT, HELP
//      Set modeInfos = capaInfo.getModes(MediaType.TEXT_HTML);
//
//      //shoule be 3 modes
//      assertEquals(3, modeInfos.size());
//
//      Set portletModes = new HashSet();
//      for (Iterator i = modeInfos.iterator(); i.hasNext();)
//      {
//         ModeInfo mode = (ModeInfo)i.next();
//         portletModes.add(mode.getMode());
//         assertEquals(mode.getModeName(), mode.getMode().toString());
//      }
//
//
//      assertTrue(portletModes.contains(org.gatein.pc.api.Mode.VIEW));
//      assertTrue(portletModes.contains(Mode.HELP));
//      assertTrue(portletModes.contains(Mode.EDIT));
//
//      //Portlet 2 with only VIEW
//      capaInfo = container2.getInfo().getCapabilities();
//      modeInfos = capaInfo.getModes(MediaType.TEXT_HTML);
//
//      //shoule be 1 mode
//      assertEquals(1, modeInfos.size());
//
//
//      portletModes = new HashSet();
//      for (Iterator i = modeInfos.iterator(); i.hasNext();)
//      {
//         ModeInfo mode = (ModeInfo)i.next();
//         portletModes.add(mode.getMode());
//         assertEquals(mode.getModeName(), mode.getMode().toString());
//      }
//
//      assertTrue(portletModes.contains(Mode.VIEW));
//      assertTrue(!portletModes.contains(Mode.HELP));
//      assertTrue(!portletModes.contains(Mode.EDIT));
//   }
}
