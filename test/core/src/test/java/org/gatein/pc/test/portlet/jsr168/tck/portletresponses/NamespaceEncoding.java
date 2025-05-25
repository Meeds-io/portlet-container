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
package org.gatein.pc.test.portlet.jsr168.tck.portletresponses;

import org.gatein.pc.test.unit.PortletTestCase;
import org.gatein.pc.test.unit.PortletTestContext;
import org.gatein.pc.test.unit.actions.PortletRenderTestAction;
import org.gatein.pc.test.unit.web.UTP1;
import org.gatein.pc.test.unit.annotations.TestCase;
import org.gatein.pc.test.unit.Assertion;
import org.gatein.pc.test.unit.protocol.response.Response;
import org.gatein.pc.test.unit.protocol.response.EndTestResponse;
import static org.gatein.pc.test.unit.Assert.assertTrue;
import static org.gatein.pc.test.unit.Assert.assertEquals;

import javax.portlet.Portlet;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@TestCase({Assertion.JSR168_86, Assertion.JSR168_87, Assertion.JSR168_88})
public class NamespaceEncoding
{
   public NamespaceEncoding(PortletTestCase seq)
   {
      seq.bindAction(0, UTP1.RENDER_JOIN_POINT, new PortletRenderTestAction()
      {
         protected Response run(Portlet portlet, RenderRequest request, RenderResponse response, PortletTestContext context)
         {
            String namespace = response.getNamespace();

            //assert it is valid Java identifier
            assertTrue(isJavaIdentifier(namespace));

            //check if it always return same value in scope of render request
            assertEquals(namespace, response.getNamespace());

            assertEquals(namespace, response.getNamespace());

            assertEquals(namespace, response.getNamespace());
            return new EndTestResponse();
         }
      });
   }

   /** Checks if string is valid java identifier as defined in 'Java Language Specification' */
   public static boolean isJavaIdentifier(String s)
   {
      if (s.length() == 0 || !Character.isJavaIdentifierStart(s.charAt(0)))
      {
         return false;
      }
      for (int i = 1; i < s.length(); i++)
      {
         if (!Character.isJavaIdentifierPart(s.charAt(i)))
         {
            return false;
         }
      }
      return true;
   }
}
