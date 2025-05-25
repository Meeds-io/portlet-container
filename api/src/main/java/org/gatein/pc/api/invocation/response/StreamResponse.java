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
package org.gatein.pc.api.invocation.response;

/**
 * Stream a result to the client directly.
 *
 */
public class StreamResponse extends PortletInvocationResponse
{

   private String contentType;
   private byte[] bytes;

   public StreamResponse(String contentType, byte[] bytes)
   {
      if (contentType == null)
      {
         throw new IllegalArgumentException("Content type cannot be null");
      }
      if (bytes == null)
      {
         throw new IllegalArgumentException("Bytes cannot be null");
      }
      this.contentType = contentType;
      this.bytes = bytes;
   }

   public String getContentType()
   {
      return contentType;
   }

   public byte[] getBytes()
   {
      return bytes;
   }
}
