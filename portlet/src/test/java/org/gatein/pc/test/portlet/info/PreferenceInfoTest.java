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

public class PreferenceInfoTest extends AbstractInfoTest
{

   public PreferenceInfoTest()
   {
      super("PreferenceInfoTest");
   }

//   public void execute()
//   {
//      ManagedPortletContainer container = registry.getManagedPortletApplication("/test-info").getManagedPortletContainer("PreferenceInfoPortlet");
//
//      //
//      PortletInfo info = container.getInfo();
//      ContainerPreferencesInfo prefsInfo = (ContainerPreferencesInfo)info.getPreferences();
//
//      //
//      ContainerPreferenceInfo prefInfo = prefsInfo.getContainerPreference("localized_pref");
//      assertEquals("localized_pref", prefInfo.getKey());
//      assertEquals("english localized description", prefInfo.getDescription().getString(Locale.ENGLISH, false));
//      assertEquals("polish localized description", prefInfo.getDescription().getString(new Locale("pl"), false));
//      assertEquals("english_localized_name", prefInfo.getDisplayName().getString(Locale.ENGLISH, false));
//      assertEquals("polish_localized_name", prefInfo.getDisplayName().getString(new Locale("pl"), false));
//
//      //
//      Set keys = prefsInfo.getKeys();
//      assertTrue(keys.contains("localized_pref"));
//      assertTrue(keys.contains("single_pref"));
//      assertTrue(keys.contains("multi_pref"));
//      assertTrue(keys.contains("single_pref_bis"));
//      assertTrue(keys.contains("multi_pref_bis"));
//
//      //
//      prefInfo = prefsInfo.getContainerPreference("single_pref");
//      assertEquals("single_pref", prefInfo.getKey());
//      List<String> values = prefInfo.getDefaultValue();
//      assertEquals(Arrays.asList("single_pref_value"), values);
//      assertTrue(!prefInfo.isReadOnly().booleanValue());
//
//      //
//      prefInfo = prefsInfo.getContainerPreference("multi_pref");
//      assertEquals("multi_pref", prefInfo.getKey());
//      values = prefInfo.getDefaultValue();
//      assertEquals(Arrays.asList("multi_pref_value_1", "multi_pref_value_2"), values);
//      assertTrue(!prefInfo.isReadOnly().booleanValue());
//
//      //
//      prefInfo = prefsInfo.getContainerPreference("single_pref_bis");
//      assertEquals("single_pref_bis", prefInfo.getKey());
//      values = prefInfo.getDefaultValue();
//      assertEquals(Arrays.asList("single_pref_value"), values);
//      assertTrue(prefInfo.isReadOnly().booleanValue());
//
//      //
//      prefInfo = prefsInfo.getContainerPreference("multi_pref_bis");
//      assertEquals("multi_pref_bis", prefInfo.getKey());
//      values = prefInfo.getDefaultValue();
//      assertEquals(Arrays.asList("multi_pref_value_1", "multi_pref_value_2"), values);
//      assertTrue(prefInfo.isReadOnly().booleanValue());
//   }
}
