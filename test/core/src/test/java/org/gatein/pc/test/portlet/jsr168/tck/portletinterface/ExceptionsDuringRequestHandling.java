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
package org.gatein.pc.test.portlet.jsr168.tck.portletinterface;

import org.gatein.pc.test.unit.Assertion;
import org.gatein.pc.test.unit.PortletTestCase;
import org.gatein.pc.test.unit.annotations.TestCase;

/**
 * This case is based on: - ExceptionsDuringRequestHandlingControllerPortlet - PortletExceptionDuringRequestHandlingPortlet
 * - RuntimeExceptionDuringRequestHandlingPortlet - UnavailableExceptionDuringProcessActionPortlet -
 * UnavailableExceptionDuringRenderPortlet
 * This test is disabled. Specification doesn't defined strictly portal behaviour when one of the portlets throws
 * PortletException. Currently in GateIn if one portlet throws an PortletException than the rest of portlet of the page
 * is not rendered - code 500 is returned. Tests are based on different behaviour where rest of portlets are rendered.
 *
 */
@TestCase(value = {Assertion.JSR168_17, Assertion.JSR168_18, Assertion.JSR168_19}, enabled = false)
public class ExceptionsDuringRequestHandling
{
   public ExceptionsDuringRequestHandling(PortletTestCase seq)
   {
      // suite.addTest(new PortletTestCase("ExceptionsDuringRequestHandlingPortlet"));
   }
}
