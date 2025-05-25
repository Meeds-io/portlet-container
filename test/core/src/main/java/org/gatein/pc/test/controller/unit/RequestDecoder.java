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

import org.gatein.common.http.QueryStringParser;
import org.gatein.common.net.media.MediaType;
import org.gatein.common.net.media.ContentType;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Collections;
import java.util.HashMap;
import java.nio.charset.Charset;
import java.io.UnsupportedEncodingException;

/**
 * Useful request decoder.
 *
 */
public class RequestDecoder
{

   /** . */
   private static final Charset UTF_8_CHARSET = Charset.forName("UTF-8");

   /** . */
   private final MediaType mediaType;

   /** . */
   private final Map<String, String[]> queryParameters;

   /** . */
   private final Body body;

   public RequestDecoder(HttpServletRequest request) throws UnsupportedEncodingException
   {
      if (request == null)
      {
         throw new IllegalArgumentException("No null http request accepted");
      }

      // Parse the query string to have the get parameters
      // The resulting map has its parameters decoded from the x-www-form-url encoding
      String queryString = request.getQueryString();
      if (queryString != null)
      {
         queryParameters = QueryStringParser.getInstance().parseQueryString(queryString);
      }
      else
      {
         queryParameters = Collections.emptyMap();
      }

      if (request.getContentType() != null)
      {
         ContentType contentType = ContentType.create(request.getContentType());
         mediaType = contentType.getMediaType();
      }
      else
      {
         mediaType = null;
      }

      //
      if ("POST".equals(request.getMethod()))
      {
         if (MediaType.APPLICATION_X_WWW_FORM_URLENCODED.equals(mediaType))
         {
            // Now we must ensure that we have either an equals or a trailing space after the media-type
            String characterEncoding = request.getCharacterEncoding();
            if (characterEncoding == null)
            {
               // Set out charset for the request
               request.setCharacterEncoding(UTF_8_CHARSET.name());
            }
            else
            {
               Charset charset = Charset.forName(characterEncoding);
               if (!UTF_8_CHARSET.equals(charset))
               {
                  throw new IllegalStateException("Charset " + characterEncoding + " not accepted, it should be UTF8");
               }
            }

            //
            Map<String, String[]> bodyParameterMap = new HashMap<String, String[]>();
            for (Map.Entry<String, String[]> entry : request.getParameterMap().entrySet())
            {
               // Get param name
               String paramName = entry.getKey();

               // Values that are aggregated from the query string and the body
               String[] paramValues = entry.getValue();

               // Values decoded from the query string
               String[] queryValues = queryParameters.get(paramName);

               //
               if (queryValues != null)
               {
                  int bodyValuesLength = paramValues.length - queryValues.length;
                  if (bodyValuesLength > 0)
                  {
                     String[] bodyValues = new String[bodyValuesLength];
                     System.arraycopy(paramValues, queryValues.length, bodyValues, 0, bodyValuesLength);
                     bodyParameterMap.put(paramName, bodyValues);
                  }
               }
               else
               {
                  bodyParameterMap.put(paramName, paramValues);
               }
            }

            //
            body = new Body.Form(request.getCharacterEncoding(), bodyParameterMap);
         }
         else
         {
            body = new Body.Raw(request.getCharacterEncoding(), request);
         }
      }
      else
      {
         body = null;
      }
   }

   public MediaType getMediaType()
   {
      return mediaType;
   }

   public Map<String, String[]> getQueryParameters()
   {
      return queryParameters;
   }

   public Body getBody()
   {
      return body;
   }
}
