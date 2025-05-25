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

import org.gatein.pc.api.LifeCyclePhase;
import org.gatein.pc.portlet.impl.metadata.PortletApplication20MetaData;
import org.gatein.pc.portlet.impl.metadata.common.InitParamMetaData;
import org.gatein.pc.portlet.impl.metadata.filter.FilterMetaData;

public class FilterTestEverythingTestCase extends AbstractMetaDataTestCase
{

   public void test01() throws Exception
   {
      unmarshall("metadata/filter/portlet-filter1.xml", true);
   }

   public void test02()
   {
      try
      {
         String xmlFile = "metadata/filter/portlet-filter2.xml";

         PortletApplication20MetaData md = unmarshall(xmlFile);
         assertNotNull(md);
         assertTrue(md instanceof PortletApplication20MetaData);

         FilterMetaData filter = md.getFilter("testFilter");
         assertNotNull(filter);
         assertEquals("org.jboss.portal.meta.NoExistingClass", filter.getFilterClass());
         assertEquals("testFilter", filter.getFilterName());
         assertEquals(LifeCyclePhase.ACTION, filter.getLifecycle().get(0));
         assertEquals(LifeCyclePhase.RENDER, filter.getLifecycle().get(1));
         
         assertEquals("test", filter.getDescription().getDefaultString());
         assertEquals("bla", filter.getDescription().getString(new Locale("de"), false));

         assertEquals("foo", filter.getDisplayName().getString(new Locale("fr"), false));
         assertEquals("foobar", filter.getDisplayName().getDefaultString());
         
         InitParamMetaData ip = filter.getInitParams().get(0);
         assertEquals("eins", ip.getId());
         assertEquals("foo", ip.getName());
         assertEquals("bar", ip.getValue());
         assertNotNull(ip.getDescription());
         
         InitParamMetaData ip2 = filter.getInitParams().get(1);
         assertEquals("test", ip2.getName());
         assertEquals("testing", ip2.getValue());
         assertNull(ip2.getId());
         
         // 
         FilterMetaData filter2 = md.getFilter("testFilterZwei");
         assertEquals("testFilterZwei", filter2.getFilterName());
         assertEquals(LifeCyclePhase.ACTION, filter2.getLifecycle().get(0));
         
         // Filter mapping            
         assertEquals("Portlet1", md.getFilterMapping().get(0).getPortletNames().get(0));
         assertEquals("Portlet2", md.getFilterMapping().get(0).getPortletNames().get(1));

         assertEquals("Portlet2", md.getFilterMapping().get(1).getPortletNames().get(0));

      }
      catch (Exception e)
      {
         e.printStackTrace();
         fail();
      }
   }

}
