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
package org.gatein.pc.portlet.deployment;

import java.util.Locale;

import org.gatein.pc.portlet.impl.metadata.CustomPortletModeMetaData;
import org.gatein.pc.portlet.impl.metadata.PortletApplication10MetaData;
import org.gatein.pc.portlet.impl.metadata.PortletApplication20MetaData;

public class CustomPortletModeTestEverythingTestCase extends AbstractMetaDataTestCase
{

   
   public void test01()
   {
      try
      {
         String xmlFile = "metadata/customPortletMode/portlet1.xml";

         PortletApplication10MetaData md = unmarshall(xmlFile);
         assertNotNull(md);
         assertTrue(md instanceof PortletApplication10MetaData);
         assertEquals("1.0", md.getVersion());
         assertNotNull(md.getCustomPortletModes());

         CustomPortletModeMetaData cmd1 = md.getCustomPortletModes().get("Custom");
         assertNotNull(cmd1);
         assertEquals("mode1", cmd1.getId());
         assertEquals("Custom", cmd1.getPortletMode());
         assertEquals("portletMode1", cmd1.getDescription().getDefaultString());
         assertEquals("eigener portlet modus", cmd1.getDescription().getString(new Locale("de"), false));

         assertNotNull(md.getCustomPortletModes().get("Custom2"));
      }
      catch (Exception e)
      {
         fail(e);
      }
   }

   public void test02()
   {
      try
      {

         String xmlFile = "metadata/customPortletMode/portlet2.xml";

         PortletApplication20MetaData md = unmarshall(xmlFile);
         assertNotNull(md);
         assertTrue(md instanceof PortletApplication20MetaData);
         assertEquals("2.0", md.getVersion());

         CustomPortletModeMetaData cmd1 = md.getCustomPortletModes().get("Custom");
         assertNotNull(cmd1);
         assertEquals("Custom", cmd1.getPortletMode());
         assertEquals("portletMode1", cmd1.getDescription().getDefaultString());         
         assertEquals(true, cmd1.isPortalManaged());
         assertEquals("cmode1", cmd1.getId());
         
         CustomPortletModeMetaData cmd2 = md.getCustomPortletModes().get("Custom2");
         assertNotNull(cmd2);
         assertEquals("Custom2", cmd2.getPortletMode());
         assertEquals(false, cmd2.isPortalManaged());

         CustomPortletModeMetaData cmd3 = md.getCustomPortletModes().get("Custom3");
         assertNotNull(cmd3);
         assertEquals("Custom3", cmd3.getPortletMode());

         // default value
         assertEquals(true, cmd3.isPortalManaged());
         assertEquals("eigener portlet modus", cmd1.getDescription().getString(new Locale("de"), false));
         assertEquals("Portlet Mode Three", cmd3.getDescription().getDefaultString());


      }
      catch (Exception e)
      {
         fail(e);
      }
   }

   public void test03() throws Exception
   {
      String xmlFile = "metadata/customPortletMode/portlet1-fail.xml";
      unmarshall(xmlFile, true);
   }
}
