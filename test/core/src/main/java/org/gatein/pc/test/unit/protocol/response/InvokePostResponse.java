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

import org.gatein.pc.test.unit.protocol.Body;

import java.net.URI;

/**
 * The portlet wants to invoke a post.
 *
 */
public class InvokePostResponse extends InvokeMethodResponse
{

   /** . */
   public static final String APPLICATION_X_WWW_FORM_URLENCODED = "application/x-www-form-urlencoded";

   /** . */
   public static final String MULTIPART_FORM_DATA = "multipart/form-data";

   /** The content type. */
   private String contentType;

   /** The post body. */
   private Body body;

   public InvokePostResponse(String uri)
   {
      super(uri);
   }

   public InvokePostResponse(URI uri)
   {
      super(uri);
   }

   public Body getBody()
   {
      return body;
   }

   public void setBody(Body body)
   {
      this.body = body;
   }

   public String getContentType()
   {
      return contentType;
   }

   public void setContentType(String contentType)
   {
      this.contentType = contentType;
   }

   public String toString()
   {
      return "InvokePost[uri=" + getURI() + "]";
   }
}
