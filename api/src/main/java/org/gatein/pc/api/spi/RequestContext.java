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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

public interface RequestContext
{
   /**
    * Returns the name of the character encoding used in the body of this request. This method returns <code>null</code>
    * if the request does not specify a character encoding.
    *
    * @return a <code>String</code> containing the name of the chararacter encoding, or <code>null</code> if the
    * request does not specify a character encoding.
    */
   String getCharacterEncoding();

   /**
    * Returns the length, in bytes, of the request body which is made available by the input stream, or -1 if the length
    * is not known.
    *
    * @return an integer containing the length of the request body or -1 if the length is not known
    */
   int getContentLength();

   /**
    * Returns the MIME type of the body of the request, or null if the type is not known.
    *
    * @return a <code>String</code> containing the name of the MIME type of the request, or null if the type is not
    * known.
    */
   String getContentType();

   /**
    * Retrieves the body of the HTTP request from the client to the portal as character data using a
    * <code>BufferedReader</code>.  The reader translates the character data according to the character encoding used on
    * the body. Either this method or {@link #getInputStream} may be called to read the body, not both.
    * For HTTP POST data of type application/x-www-form-urlencoded this method throws an
    * <code>IllegalStateException</code> as this data has been already processed by the portal/portlet-container and is
    * available as request parameters.
    *
    * @throws java.io.UnsupportedEncodingException if the character set encoding used is not supported and
    *         the text cannot be decoded
    * @throws java.lang.IllegalStateException if {@link #getInputStream} method has been called on this request,
    *         it is a HTTP POST data of type application/x-www-form-urlencoded.
    * @throws java.io.IOException if an input or output exception occurred
    * @return a <code>BufferedReader</code> containing the body of the request
    * @see #getInputStream
    */
   BufferedReader getReader() throws IOException;

   /**
    * Retrieves the body of the HTTP request from client to portal as binary data using an <CODE>InputStream</CODE>.
    * Either this method or {@link #getReader} may be called to read the body, but not both.
    * For HTTP POST data of type application/x-www-form-urlencoded this method throws an
    * <code>IllegalStateException</code> as this data has been already processed by the portal/portlet-container and is
    * available as request parameters.
    *
    * @return an input stream containing the body of the request
    * @throws java.lang.IllegalStateException if getReader was already called, or it is a HTTP POST data of type
    *         application/x-www-form-urlencoded
    * @throws java.io.IOException if an input or output exception occurred
    */
   InputStream getInputStream() throws IOException, IllegalStateException;
}
