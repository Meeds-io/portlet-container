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

public final class Mode implements Serializable
{

   /** The serialVersionUID. */
   private static final long serialVersionUID = 6033765240710422050L;

   /** . */
   public static final Mode EDIT = new Mode("edit");

   /** . */
   public static final Mode HELP = new Mode("help");

   /** . */
   public static final Mode VIEW = new Mode("view");

   /** . */
   public static final Mode EDIT_DEFAULTS = new Mode("edit_defaults");

   /** . */
   public static final Mode ADMIN = new Mode("admin");

   /** . */
   private String name;

   /**
    * This NEEDS to be public for JAXB unmarshalling done by SupportsMetaData.
    *
    * @param name
    */
   public Mode(String name)
   {
      this(name, false);
   }

   /**
    * @param name
    * @param preserveCase
    * @since 2.4.2
    */
   private Mode(String name, boolean preserveCase)
   {
      if (name == null)
      {
         throw new IllegalArgumentException("Mode cannot be null");
      }
      this.name = (preserveCase ? name : name.toLowerCase(Locale.ENGLISH));
   }


   public boolean equals(Object o)
   {
      if (o == this)
      {
         return true;
      }
      if (o instanceof Mode)
      {
         Mode that = (Mode)o;
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
      Mode standardMode = isStandardMode(name);

      if (standardMode != null)
      {
         return standardMode;
      }
      else
      {
         return this;
      }
   }

   public static Mode create(String name)
   {
      return create(name, false);
   }

   /**
    * @param name
    * @param preserveCase
    * @return
    * @since 2.4.2
    */
   public static Mode create(String name, boolean preserveCase)
   {
      Mode standardMode = isStandardMode(name);
      if (standardMode != null)
      {
         return standardMode;
      }
      else
      {
         return new Mode(name, preserveCase);
      }
   }

   private static Mode isStandardMode(String name)
   {
      if (Mode.VIEW.name.equals(name))
      {
         return Mode.VIEW;
      }
      else if (Mode.EDIT.name.equals(name))
      {
         return Mode.EDIT;
      }
      else if (Mode.HELP.name.equals(name))
      {
         return Mode.HELP;
      }
      else if (Mode.ADMIN.name.equals(name))
      {
         return Mode.ADMIN;
      }
      else if (Mode.EDIT_DEFAULTS.name.equals(name))
      {
         return Mode.EDIT_DEFAULTS;
      }
      else
      {
         return null;
      }
   }
}