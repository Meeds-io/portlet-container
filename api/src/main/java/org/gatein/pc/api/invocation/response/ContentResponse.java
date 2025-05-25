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

import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Map;

import org.gatein.pc.api.cache.CacheControl;

/**
 * Data produced.
 *
 */
public class ContentResponse extends PortletInvocationResponse
{

   /** . */
   private static final Charset UTF_8 = Charset.forName("UTF-8");

   /** . */
   public static final int TYPE_EMPTY = 0;

   /** . */
   public static final int TYPE_CHARS = 1;

   /** . */
   public static final int TYPE_BYTES = 2;

   /** . */
   private final ResponseProperties properties;

   /** . */
   private final Map<String, Object> attributes;

   /** The result content type if any. */
   private String contentType;

   /** The optional encoding. */
   private final String encoding;

   /** . */
   private final byte[] bytes;

   /** . */
   private final String chars;

   /** . */
   private final CacheControl cacheControl;

   public ContentResponse(
      ResponseProperties properties,
      Map<String, Object> attributes,
      String contentType,
      String encoding,
      byte[] bytes,
      CacheControl cacheControl)
   {
      this.properties = properties;
      this.attributes = attributes;
      this.contentType = contentType;
      this.encoding = encoding;
      this.bytes = bytes;
      this.chars = null;
      this.cacheControl = cacheControl;
   }

   public ContentResponse(
      ResponseProperties properties,
      Map<String, Object> attributes,
      String contentType,
      String encoding,
      String chars,
      CacheControl cacheControl)
   {
      this.properties = properties;
      this.attributes = attributes;
      this.contentType = contentType;
      this.encoding = encoding;
      this.bytes = null;
      this.chars = chars;
      this.cacheControl = cacheControl;
   }

   public ContentResponse(
      ResponseProperties properties,
      Map<String, Object> attributes,
      String contentType,
      CacheControl cacheControl)
   {
      this.properties = properties;
      this.attributes = attributes;
      this.contentType = contentType;
      this.encoding = null;
      this.bytes = null;
      this.chars = null;
      this.cacheControl = cacheControl;
   }

   public ContentResponse(
      ContentResponse that,
      CacheControl cacheControl)
   {
      if (that == null)
      {
         throw new IllegalArgumentException("No null content response can be provided for copy");
      }
      this.properties = that.properties;
      this.attributes = that.attributes;
      this.contentType = that.contentType;
      this.encoding = that.encoding;
      this.bytes = that.bytes;
      this.chars = that.chars;
      this.cacheControl = cacheControl;
   }

   public String getEncoding()
   {
      return encoding;
   }

   public ResponseProperties getProperties()
   {
      return properties;
   }

   public CacheControl getCacheControl()
   {
      return cacheControl;
   }

   public Map<String, Object> getAttributes()
   {
      return attributes;
   }

   public int getType()
   {
      if (bytes == null)
      {
         if (chars == null)
         {
            return TYPE_EMPTY;
         }
         else
         {
            return TYPE_CHARS;
         }
      }
      else
      {
         return TYPE_BYTES;
      }
   }

   /**
    * Return the content as a string, when the character encoding is set, it will be used
    * for binary content, otherwise the <code>UTF-8</code> will be used.
    *
    * @return the content
    * @throws UnsupportedCharsetException when the response encoding is not supported
    */
   public String getContent() throws UnsupportedCharsetException
   {
      Charset charset = UTF_8;
      if (encoding != null)
      {
         charset = Charset.forName(encoding);
      }
      return getContent(charset);
   }

   /**
    * Return the content as a string, the provided charset will be used for binary content.
    *
    * @return the content
    */
   public String getContent(Charset charset)
   {
      if (charset == null)
      {
         throw new NullPointerException("No null charset accepted");
      }
      switch (getType())
      {
         case TYPE_CHARS:
            return getChars();
         case TYPE_BYTES:
            return new String(bytes, charset);
         case TYPE_EMPTY:
            return "";
         default:
            throw new AssertionError();
      }
   }

   /**
    * Return the bytes of the content held by the fragment.
    *
    * @return the bytes
    * @throws IllegalArgumentException if the type is not bytes
    */
   public byte[] getBytes() throws IllegalArgumentException
   {
      return bytes;
   }

   /**
    * Return the chars of the content held by the fragment.
    *
    * @return the chars
    * @throws IllegalArgumentException if the type is not chars
    */
   public String getChars() throws IllegalArgumentException
   {
      return chars;
   }

   /**
    * Return the content type of the generated fragment.
    *
    * @return the content type
    */
   public String getContentType()
   {
      return contentType;
   }
}