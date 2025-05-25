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
package org.gatein.pc.test.portlet.jsr168.tck.portletconfig;

import org.gatein.pc.test.unit.PortletTestCase;
import org.gatein.pc.test.unit.PortletTestContext;
import org.gatein.pc.test.unit.web.AbstractUniversalTestPortlet;
import org.gatein.pc.test.unit.actions.PortletRenderTestAction;
import org.gatein.pc.test.portlet.jsr168.tck.portletconfig.spec.InlineValuesWithNoResourceBundleDefinedPortlet;
import org.gatein.pc.test.unit.annotations.TestCase;
import org.gatein.pc.test.unit.Assertion;
import org.gatein.pc.test.unit.protocol.response.Response;
import org.gatein.pc.test.unit.protocol.response.EndTestResponse;
import static org.gatein.pc.test.unit.Assert.fail;
import static org.gatein.pc.test.unit.Assert.assertEquals;

import javax.portlet.Portlet;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.PortletConfig;
import java.util.ResourceBundle;
import java.util.Locale;
import java.util.MissingResourceException;

@TestCase({Assertion.JSR168_24})
public class InlineValuesWithNoResourceBundleDefined
{
   public InlineValuesWithNoResourceBundleDefined(PortletTestCase seq)
   {
      seq.bindAction(0, InlineValuesWithNoResourceBundleDefinedPortlet.RENDER_JOIN_POINT, new PortletRenderTestAction()
      {
         protected Response run(Portlet portlet, RenderRequest request, RenderResponse response, PortletTestContext context)
         {
            PortletConfig cfg = ((AbstractUniversalTestPortlet)portlet).getPortletConfig();

            ResourceBundle bundle_en = cfg.getResourceBundle(Locale.ENGLISH);

            //dummy assert that we don't have resouce bundle defined...
            try
            {
               bundle_en.getString("foo");
               fail();
            }
            catch (MissingResourceException expected)
            {
            }

            //These defined inline in portelt.xml and there is no bundle defined there
            assertEquals("title", bundle_en.getString("javax.portlet.title"));
            assertEquals("short-title", bundle_en.getString("javax.portlet.short-title"));
            assertEquals("keywords", bundle_en.getString("javax.portlet.keywords"));
            return new EndTestResponse();
         }
      });
   }
}
