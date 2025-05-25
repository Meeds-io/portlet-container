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

import org.gatein.pc.api.StateString;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * An opaque implementation of the navigational state.
 *
 */
public class OpaqueStateString extends StateString
{

   /** . */
   private String value;

   public OpaqueStateString(String value)
   {
      if (value == null)
      {
         throw new IllegalArgumentException("No null value accepted");
      }
      this.value = value;
   }

   public String getStringValue()
   {
      return value;
   }

   public void writeTo(DataOutputStream out) throws IOException
   {
      out.writeByte(StateString.OPAQUE);
      out.writeUTF(value);
   }

   public int hashCode()
   {
      return value.hashCode();
   }

   public boolean equals(Object o)
   {
      if (o == this)
      {
         return true;
      }
      if (o instanceof OpaqueStateString)
      {
         OpaqueStateString that = (OpaqueStateString)o;
         return value.equals(that.value);
      }
      return false;
   }
}
