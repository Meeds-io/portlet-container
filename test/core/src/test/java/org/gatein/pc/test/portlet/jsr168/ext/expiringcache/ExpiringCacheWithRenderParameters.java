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
package org.gatein.pc.test.portlet.jsr168.ext.expiringcache;

import org.gatein.pc.test.portlet.jsr168.ext.common.AbstractCacheMarkup;
import org.gatein.pc.test.portlet.jsr168.ext.common.NavigationalStateConfigurator;
import org.gatein.pc.test.unit.web.UTP4;
import org.gatein.pc.test.unit.web.UTP5;
import org.gatein.pc.test.unit.PortletTestCase;
import org.gatein.pc.test.unit.annotations.TestCase;
import org.gatein.pc.test.unit.Assertion;

@TestCase({
   Assertion.EXT_EXPIRING_CACHE_5
   })
public class ExpiringCacheWithRenderParameters extends AbstractCacheMarkup
{
   public ExpiringCacheWithRenderParameters(PortletTestCase seq)
   {
      super(seq, UTP4.RENDER_JOIN_POINT, UTP4.ACTION_JOIN_POINT, UTP5.RENDER_JOIN_POINT, NavigationalStateConfigurator.RENDER_PARAMETER_CONFIGURATOR);
   }
}
