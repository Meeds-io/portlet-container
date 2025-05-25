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
package org.gatein.pc.test.portlet.session;

import java.io.Serializable;
import java.io.IOException;

public class MutableValue implements Serializable
{

   private String string;

   public MutableValue(String string)
   {
      this.string = string;
   }

   public String getString()
   {
      return string;
   }

   public void setString(String string)
   {
      this.string = string;
   }

   public boolean equals(Object obj)
   {
      if (obj == this)
      {
         return true;
      }
      if (obj instanceof MutableValue)
      {
         MutableValue that = (MutableValue)obj;
         return string == null ? that.string == null : string.equals(that.string);
      }
      return false;
   }

   private void writeObject(java.io.ObjectOutputStream out) throws IOException
   {
      out.writeUTF(string);
      System.out.print("Serializing " + string);
   }

   private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException
   {
      string = in.readUTF();
      System.out.print("Unserializing " + string);
   }

   public String toString()
   {
      return "MutableValue[" + string + "]";
   }
}
