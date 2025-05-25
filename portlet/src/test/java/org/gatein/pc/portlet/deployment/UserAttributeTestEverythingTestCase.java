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

import org.gatein.pc.portlet.impl.metadata.PortletApplication10MetaData;
import org.gatein.pc.portlet.impl.metadata.PortletApplication20MetaData;
import org.gatein.pc.portlet.impl.metadata.UserAttributeMetaData;

public class UserAttributeTestEverythingTestCase extends AbstractMetaDataTestCase
{

   public void test01()
   {
      try
      {
         String xmlFile = "metadata/userAttribute/portlet1.xml";

         PortletApplication10MetaData md = unmarshall(xmlFile);
         assertNotNull(md);
         assertTrue(md instanceof PortletApplication10MetaData);

         UserAttributeMetaData umb = md.getUserAttributes().get("blub");
         assertNotNull(umb);
         assertEquals("notFoo", umb.getId());
         assertNull(umb.getDescription());

         UserAttributeMetaData umd = md.getUserAttributes().get("foo");
         assertNotNull(umd);
         assertEquals("realFoo", umd.getId());
         assertEquals("foobar", umd.getDescription().getDefaultString());
         assertEquals("fuhbar", umd.getDescription().getString(new Locale("de"), true));

      }
      catch (Exception e)
      {
         e.printStackTrace();
         fail();
      }
   }

   public void test02()
   {
      try
      {
         String xmlFile = "metadata/userAttribute/portlet2.xml";

         PortletApplication20MetaData md = this.unmarshall(xmlFile);
         assertNotNull(md);
         assertTrue(md instanceof PortletApplication20MetaData);

         UserAttributeMetaData umb = md.getUserAttributes().get("blub");
         assertNotNull(umb);
         assertEquals("notFoo", umb.getId());
         assertNull(umb.getDescription());

         UserAttributeMetaData umd = md.getUserAttributes().get("foo");
         assertNotNull(umd);
         assertEquals("realFoo", umd.getId());
         assertEquals("foobar", umd.getDescription().getDefaultString());
         assertEquals("fuhbar", umd.getDescription().getString(new Locale("de"), true));
      }
      catch (Exception e)
      {
         e.printStackTrace();
         fail();
      }
   }

}
