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
package org.gatein.pc.api.cache;

import org.gatein.common.util.ParameterValidation;

import java.io.Serializable;

public final class CacheLevel implements Serializable
{
   public static final CacheLevel FULL = new CacheLevel("FULL");
   public static final CacheLevel PORTLET = new CacheLevel("PORTLET");
   public static final CacheLevel PAGE = new CacheLevel("PAGE");

   private static final long serialVersionUID = -7020875805659724988L;

   private final String name;

   private CacheLevel(String name)
   {
      ParameterValidation.throwIllegalArgExceptionIfNullOrEmpty(name, "CacheLevel name", null);
      this.name = name;
   }

   public final String name()
   {
      return name;
   }

   private Object readResolve()
   {
      CacheLevel standardCacheLevel = isStandardCacheLevel(name);
      if (standardCacheLevel != null)
      {
         return standardCacheLevel;
      }
      else
      {
         return this;
      }
   }

   @Override
   public boolean equals(Object o)
   {
      if (this == o)
      {
         return true;
      }
      if (o == null || getClass() != o.getClass())
      {
         return false;
      }

      CacheLevel that = (CacheLevel)o;

      return !(name == null ? that.name != null : !name.equals(that.name));
   }

   @Override
   public int hashCode()
   {
      return name != null ? name.hashCode() : 0;
   }

   public static CacheLevel create(String name)
   {
      CacheLevel standardCacheLevel = isStandardCacheLevel(name);
      if (standardCacheLevel != null)
      {
         return standardCacheLevel;
      }
      else
      {
         return new CacheLevel(name);
      }
   }

   private static CacheLevel isStandardCacheLevel(String name)
   {
      if (FULL.name.equals(name))
      {
         return FULL;
      }
      else if (PORTLET.name.equals(name))
      {
         return PORTLET;
      }
      else if (PAGE.name.equals(name))
      {
         return PAGE;
      }
      else
      {
         return null;
      }
   }
}
