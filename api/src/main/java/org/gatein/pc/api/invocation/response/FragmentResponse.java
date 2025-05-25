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

import org.gatein.pc.api.cache.CacheControl;
import org.gatein.pc.api.Mode;

import java.util.Set;
import java.util.Map;

/**
 * Data produced.
 *
 */
public class FragmentResponse extends ContentResponse
{

   /** The title if any. */
   private final String title;

   /** The next modes. */
   private final Set<Mode> nextModes;

   public FragmentResponse(
      ResponseProperties properties,
      Map<String, Object> attributes,
      String contentType,
      String encoding,
      byte[] bytes,
      String title,
      CacheControl cacheControl,
      Set<Mode> nextModes)
   {
      super(properties, attributes, contentType, encoding, bytes, cacheControl);

      //
      this.title = title;
      this.nextModes = nextModes;
   }

   public FragmentResponse(
      ResponseProperties properties,
      Map<String, Object> attributes,
      String contentType,
      String encoding,
      String chars,
      String title,
      CacheControl cacheControl,
      Set<Mode> nextModes)
   {
      super(properties, attributes, contentType, encoding, chars, cacheControl);

      //
      this.title = title;
      this.nextModes = nextModes;
   }

   public FragmentResponse(
      ResponseProperties properties,
      Map<String, Object> attributes,
      String contentType,
      String title,
      CacheControl cacheControl,
      Set<Mode> nextModes)
   {
      super(properties, attributes, contentType, cacheControl);

      //
      this.title = title;
      this.nextModes = nextModes;
   }

   public FragmentResponse(FragmentResponse that, CacheControl cacheControl)
   {
      super(that, cacheControl);

      //
      this.title = that.title;
      this.nextModes = that.nextModes;
   }

   /**
    * Return the fragment title.
    *
    * @return the title.
    */
   public String getTitle()
   {
      return title;
   }

   /**
    * Returns the next modes.
    *
    * @return the next modes
    */
   public Set<org.gatein.pc.api.Mode> getNextModes()
   {
      return nextModes;
   }
}
