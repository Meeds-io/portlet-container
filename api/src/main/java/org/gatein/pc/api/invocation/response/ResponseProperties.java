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

import org.gatein.common.util.MultiValuedPropertyMap;
import org.gatein.common.util.SimpleMultiValuedPropertyMap;
import org.w3c.dom.Element;

import jakarta.servlet.http.Cookie;

import java.util.List;

import java.util.Collections;
import java.util.LinkedList;

public class ResponseProperties
{

   /** . */
   private MultiValuedPropertyMap<String> transportHeaders = new SimpleMultiValuedPropertyMap<String>();

   /** . */
   private MultiValuedPropertyMap<Element> markupHeaders = new SimpleMultiValuedPropertyMap<Element>();

   /** . */
   private List<Cookie> cookies = new LinkedList<Cookie>();

   public ResponseProperties()
   {
   }

   public MultiValuedPropertyMap<String> getTransportHeaders()
   {
      return transportHeaders;
   }

   public MultiValuedPropertyMap<Element> getMarkupHeaders()
   {
      return markupHeaders;
   }

   public List<Cookie> getCookies()
   {
      return cookies;
   }

   public void append(ResponseProperties appended)
   {
      if (appended == null)
      {
         throw new IllegalArgumentException();
      }

      //
      transportHeaders.append(appended.transportHeaders);
      markupHeaders.append(appended.markupHeaders);
      cookies.addAll(appended.cookies);
   }

   public void clear()
   {
      transportHeaders.clear();
      markupHeaders.clear();
      cookies.clear();
   }
}