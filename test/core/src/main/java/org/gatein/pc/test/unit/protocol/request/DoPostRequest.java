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
package org.gatein.pc.test.unit.protocol.request;

import org.gatein.pc.test.unit.protocol.Body;

import java.net.URI;

public class DoPostRequest extends DoMethodRequest
{

   /** . */
   private String contentType;

   /** . */
   private Body body;

   public DoPostRequest(URI uri, String contentType, Body body)
   {
      super(uri);

      //
      if (body == null)
      {
         throw new IllegalArgumentException();
      }

      //
      this.contentType = contentType;
      this.body = body;
   }

   public String getContentType()
   {
      return contentType;
   }

   public Body getBody()
   {
      return body;
   }
}
