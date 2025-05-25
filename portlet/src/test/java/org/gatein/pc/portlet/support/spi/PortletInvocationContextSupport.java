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
package org.gatein.pc.portlet.support.spi;

import org.gatein.common.net.media.MediaType;
import org.gatein.pc.api.ContainerURL;
import org.gatein.pc.api.URLFormat;
import org.gatein.pc.api.spi.PortletInvocationContext;

import java.io.IOException;
import java.io.Writer;

public class PortletInvocationContextSupport implements PortletInvocationContext
{

   @Override
   public MediaType getResponseContentType()
   {
      throw new UnsupportedOperationException();
   }

   public String encodeResourceURL(String url) throws IllegalArgumentException
   {
      throw new UnsupportedOperationException();
   }

   public String renderURL(ContainerURL containerURL, URLFormat format)
   {
      throw new UnsupportedOperationException();
   }

   public void renderURL(Writer writer, ContainerURL containerURL, URLFormat format) throws IOException
   {
      throw new UnsupportedOperationException();
   }

}
