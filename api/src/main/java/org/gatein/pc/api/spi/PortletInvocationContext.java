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
package org.gatein.pc.api.spi;

import java.io.IOException;
import java.io.Writer;

import org.gatein.common.net.media.MediaType;
import org.gatein.common.util.MarkupInfo;
import org.gatein.pc.api.ContainerURL;
import org.gatein.pc.api.URLFormat;

/**
 * Contract that defines what input/services the caller of a portlet container must provide.
 *
 */
public interface PortletInvocationContext
{

   /**
    * Returns the response content type
    *
    * @return the response content type
    */
   MediaType getResponseContentType();

   /**
    * <p>Encodes the specified URL by including the session ID in it, or, if encoding is not needed, returns the URL
    * unchanged. The implementation of this method includes the logic to determine whether the session ID needs to be
    * encoded in the URL. For example, if the browser supports cookies, or session tracking is turned off, URL encoding
    * is unnecessary.</p>
    * <p>For robust session tracking, all URLs emitted by a servlet should be run through this method. Otherwise, URL
    * rewriting cannot be used with browsers which do not support cookies.</p>
    *
    * @param url the url to be encoded
    * @return the encoded URL if encoding is needed, the unchanged URL otherwise
    * @throws IllegalArgumentException if the url is not valid or null
    */
   String encodeResourceURL(String url) throws IllegalArgumentException;

   /**
    * Renders a container URL.
    *
    * @param containerURL the portlet url
    * @param format the url format
    * @return the rendered url
    */
   String renderURL(ContainerURL containerURL, URLFormat format);

   /**
    * Renders a container URL.
    *
    * @param writer the writer
    * @param containerURL the portlet url
    * @param format the url format
    * @throws IOException any IOException thrown by the writer
    */
   void renderURL(Writer writer, ContainerURL containerURL, URLFormat format) throws IOException;
}
