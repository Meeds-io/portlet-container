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
package org.gatein.pc.api;

import java.io.Serializable;
import java.util.Locale;

public final class WindowState implements Serializable
{

   /** The serialVersionUID */
   private static final long serialVersionUID = -6305311518934458562L;

   /** . */
   public static final WindowState NORMAL = new WindowState("normal");

   /** . */
   public static final WindowState MINIMIZED = new WindowState("minimized");

   /** . */
   public static final WindowState MAXIMIZED = new WindowState("maximized");

   /** . */
   private String name;

   /**
    * This NEEDS to be public for JAXB unmarshalling done by SupportsMetaData.
    *
    * @param name
    */
   public WindowState(String name)
   {
      this(name, false);
   }

   /**
    * @param name
    * @param preserveCase
    * @since 2.4.2
    */
   private WindowState(String name, boolean preserveCase)
   {
      if (name == null)
      {
         throw new IllegalArgumentException("Window state name cannot be null");
      }

      this.name = (preserveCase ? name : name.toLowerCase(Locale.ENGLISH));
   }

   public boolean equals(Object o)
   {
      if (o == this)
      {
         return true;
      }
      if (o instanceof WindowState)
      {
         WindowState that = (WindowState)o;
         return name.equals(that.name);
      }
      return false;
   }

   public int hashCode()
   {
      return name.hashCode();
   }

   public String toString()
   {
      return name;
   }

   private Object readResolve()
   {
      WindowState standardWindowState = isStandardWindowState(name);
      if (standardWindowState != null)
      {
         return standardWindowState;
      }
      else
      {
         return this;
      }
   }

   private static WindowState isStandardWindowState(String name)
   {
      if (NORMAL.name.equals(name))
      {
         return NORMAL;
      }
      else if (MAXIMIZED.name.equals(name))
      {
         return MAXIMIZED;
      }
      else if (MINIMIZED.name.equals(name))
      {
         return MINIMIZED;
      }
      else
      {
         return null;
      }
   }

   public static WindowState create(String name)
   {
      return create(name, false);
   }

   /**
    * @param name
    * @param preserveCase
    * @return
    * @since 2.4.2
    */
   public static WindowState create(String name, boolean preserveCase)
   {
      WindowState standardWindowState = isStandardWindowState(name);
      if (standardWindowState != null)
      {
         return standardWindowState;
      }
      else
      {
         return new WindowState(name, preserveCase);
      }
   }
}