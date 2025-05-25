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
package org.gatein.pc.test.unit.protocol.response;

import org.apache.commons.httpclient.Header;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

public abstract class InvokeMethodResponse extends HTTPDriverResponse
{

   /** . */
   private URI uri;

   /** . */
   private HashMap<String, Header> headers;

   public InvokeMethodResponse(String uri) throws IllegalArgumentException
   {
      if (uri == null)
      {
         throw new IllegalArgumentException("Cannot invoke against a null URL");
      }

      //
      URI tmp;
      try
      {
         tmp = new URI(uri);
      }
      catch (URISyntaxException e)
      {
         IllegalArgumentException iae = new IllegalArgumentException("Wrong URI syntax");
         iae.initCause(e);
         throw iae;
      }

      //
      if (tmp.isOpaque())
      {
         throw new IllegalArgumentException("No opaque URI accepted");
      }

      //
      this.uri = tmp;
      this.headers = new HashMap<String, Header>();
   }

   public InvokeMethodResponse(URI uri) throws IllegalArgumentException
   {
      if (uri == null)
      {
         throw new IllegalArgumentException("Cannot invoke against a null URL");
      }
      this.uri = uri;
      this.headers = new HashMap<String, Header>();
   }

   public URI getURI()
   {
      return uri;
   }

   public void addHeader(String headerName, String headerValue)
   {
      if (headerName == null)
      {
         throw new IllegalArgumentException("No null header name accepted");
      }
      headers.put(headerName, new Header(headerName, headerValue));
   }

   public HashMap<String, Header> getHeaders()
   {
      return headers;
   }
}
