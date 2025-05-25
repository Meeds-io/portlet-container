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
package org.gatein.pc.portlet.impl.jsr168.api;

import org.gatein.pc.api.cache.CacheScope;

import javax.portlet.CacheControl;

public class CacheControlImpl implements CacheControl
{

   /** . */
   private boolean useCachedContent;

   /** . */
   private int expirationSecs;

   /** . */
   private CacheScope cacheScope;

   /** . */
   private String validationToken;

   public CacheControlImpl(int expirationSecs, CacheScope cacheScope)
   {
      this.useCachedContent = false;
      this.expirationSecs = expirationSecs;
      this.cacheScope = cacheScope;
      this.validationToken = null;
   }

   public int getExpirationTime()
   {
      return expirationSecs;
   }

   public void setExpirationTime(int expirationTime)
   {
      this.expirationSecs = expirationTime;
   }

   public boolean isPublicScope()
   {
      return cacheScope == CacheScope.PUBLIC;
   }

   public void setPublicScope(boolean publicScope)
   {
      cacheScope = publicScope ? CacheScope.PUBLIC : CacheScope.PRIVATE;
   }

   public String getETag()
   {
      return validationToken;
   }

   public void setETag(String etag)
   {
      this.validationToken = etag;
   }

   public boolean useCachedContent()
   {
      return useCachedContent;
   }

   public void setUseCachedContent(boolean useCachedContent)
   {
      this.useCachedContent = useCachedContent;
   }
}
