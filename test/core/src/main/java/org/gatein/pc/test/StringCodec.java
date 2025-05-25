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
package org.gatein.pc.test;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

public class StringCodec
{

   private static char[] blah = "0123456789ABCDEF".toCharArray();


   public static String encode(String decodedValue)
   {
      try
      {
         StringBuffer buffer = new StringBuffer();
         char[] tmp = new char[1];
         for (int i = 0; i < decodedValue.length(); i++)
         {
            char c = decodedValue.charAt(i);
            if (Character.isLetterOrDigit(c))
            {
               buffer.append(c);
            }
            else
            {
               tmp[0] = c;
               byte[] bytes = new String(tmp).getBytes("UTF8");
               for (byte b : bytes)
               {
                  buffer.append('_').append(blah[(b & 0XF0) >> 4]).append(blah[b & 0x0F]);
               }
            }
         }
         return buffer.toString();
      }
      catch (UnsupportedEncodingException e)
      {
         throw new RuntimeException();
      }
   }

   public static String decode(String encodedValue)
   {
      try
      {
         ByteArrayOutputStream baos = new ByteArrayOutputStream(encodedValue.length());
         for (int i = 0; i < encodedValue.length(); i++)
         {
            char c = encodedValue.charAt(i);
            if (Character.isLetterOrDigit(c))
            {
               baos.write(c);
            }
            else if ('_' == c)
            {
               if (i + 3 > encodedValue.length())
               {
                  throw new IllegalArgumentException("There should be at least 2 chars after an _ char");
               }
               String hex = encodedValue.substring(i + 1, i + 3);
               int x = Integer.parseInt(hex, 16);
               baos.write(x);
               i += 2;
            }
            else
            {
               throw new IllegalArgumentException("Invalid char " + c);
            }
         }
         return baos.toString("UTF-8");
      }
      catch (UnsupportedEncodingException e)
      {
         throw new RuntimeException();
      }
   }


}
