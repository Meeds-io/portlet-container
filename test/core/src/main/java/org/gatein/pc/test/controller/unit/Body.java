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
package org.gatein.pc.test.controller.unit;

import jakarta.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

/**
 * The body of a request.
 *
 */
public class Body
{

   /** . */
   private final String characterEncoding;

   private Body(String characterEncoding)
   {
      this.characterEncoding = characterEncoding;
   }

   public String getCharacterEncoding()
   {
      return characterEncoding;
   }

   public static class Form extends Body
   {

      /** . */
      private final Map<String, String[]> parameters;

      public Form(String characterEncoding, Map<String, String[]> parameters)
      {
         super(characterEncoding);

         //
         if (parameters == null)
         {
            throw new IllegalArgumentException();
         }

         //
         this.parameters = parameters;
      }

      public Map<String, String[]> getParameters()
      {
         return parameters;
      }
   }

   public static class Raw extends Body
   {

      /** . */
      private final HttpServletRequest request;

      /** . */
      private boolean consumed;

      public Raw(String characterEncoding, HttpServletRequest request)
      {
         super(characterEncoding);

         //
         this.request = request;
      }

      public InputStream getInputStream() throws IOException
      {
         if (consumed)
         {
            throw new IllegalStateException();
         }
         consumed = true;
         return request.getInputStream();
      }

      public BufferedReader getReader() throws IOException
      {
         if (consumed)
         {
            throw new IllegalStateException();
         }
         consumed = true;
         return request.getReader();
      }
   }

}
