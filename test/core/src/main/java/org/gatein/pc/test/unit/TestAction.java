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
package org.gatein.pc.test.unit;

import javax.portlet.PortletRequest;
import jakarta.servlet.http.Cookie;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import static org.gatein.pc.test.unit.Assert.*;

import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.gatein.common.util.Tools;

public abstract class TestAction
{

   /** . */
   private Log log = null;

   protected final Log getLogger()
   {
      if (log == null)
      {
        log = ExoLogger.getLogger(getClass());
      }
      return log;
   }

   /**
    * Check that the parameter map contains the value expected. The check is done with the different
    * ways that the <code>PortletRequest</code> API provides:
    *
    * <ul>
    * <li><code>PortletRequest.getParameter(String)</code></li>
    * <li><code>PortletRequest.getParameterValues(String)</code></li>
    * <li><code>PortletRequest.getParameterNames()</code></li>
    * <li><code>PortletRequest.getParameterMap()</code></li>
    * </ul>
    *
    * This method allows a full coverage of the API.
    *
    * @param expectedMap the expected map
    * @param request the actual portlet request
    * @throws AssertionError if the provided request does not match the expected map state
    */
   protected final void assertParameterMap(Map<String, String[]> expectedMap, PortletRequest request) throws AssertionError
   {
      assertNotNull(request);

      // Test getParameter(String name)
      for (Map.Entry<String, String[]> entry : expectedMap.entrySet())
      {
         String expectedValue = entry.getValue()[0];
         String actualValue = request.getParameter(entry.getKey());
         assertEquals("Was expecting value " + expectedValue + " for key " + entry.getKey() + " but instead have " +
            actualValue, expectedValue, actualValue);
      }

      // Test getParameterValues(String name)
      for (Map.Entry<String, String[]> entry : expectedMap.entrySet())
      {
         String[] expectedValues = entry.getValue();
         assertEquals(expectedValues, request.getParameterValues(entry.getKey()));
      }

      // Test parameter names, we use list in order to catch eventually a wrong Enumeration returned by the request
      List<String> names = Tools.toList(request.getParameterNames());
      List<String> expectedNames = new ArrayList<String>(expectedMap.keySet());
      Collections.sort(names);
      Collections.sort(expectedNames);
      assertEquals(expectedNames, names);

      //
      Map<String, String[]> map = request.getParameterMap();
      assertParameterMap(expectedMap, map);
   }

   /**
    * Check that the two parameter maps are equals.
    *
    * @param expectedMap the expected map
    * @param map the actual map
    * @throws AssertionError if the provided map is not equals to the expected map
    */
   protected final void assertParameterMap(Map<String, String[]> expectedMap, Map<String, String[]> map) throws AssertionError
   {
      assertNotNull(map);
      assertEquals(expectedMap.keySet(), map.keySet());
//      assertEquals(map.keySet(), expectedMap.keySet());
      for (Map.Entry<String, String[]> entry : expectedMap.entrySet())
      {
         String[] expectedValues = map.get(entry.getKey());
         assertEquals(entry.getValue(), expectedValues);
      }
   }

   /**
    * Build a cookie map from the request.
    *
    * @param request the request
    * @return the cookie map
    */
   protected final  Map<String, String> createCookieMap(PortletRequest request)
   {
      Map<String, String> cookieMap = new HashMap<String, String>();
      Cookie[] cookies = request.getCookies();
      if (cookies != null)
      {
         for (Cookie cookie : cookies)
         {
            cookieMap.put(cookie.getName(), cookie.getValue());
         }
      }
      return cookieMap;
   }
}
