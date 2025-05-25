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

import org.gatein.common.io.IOTools;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestClassLoader extends ClassLoader
{

   /** . */
   private Class replicatedValueClass;

   public Class loadClass(String name) throws ClassNotFoundException
   {
      if (ReplicatedValue.class.getName().equals(name))
      {
         synchronized (this)
         {
            if (replicatedValueClass == null)
            {
               InputStream in = null;
               try
               {
                  in = ReplicatedValue.class.getClassLoader().getResourceAsStream(ReplicatedValue.class.getName().replace('.', '/') + ".class");
                  ByteArrayOutputStream baos = new ByteArrayOutputStream();
                  IOTools.copy(in, baos);
                  byte[] bytes = baos.toByteArray();
                  replicatedValueClass = defineClass(ReplicatedValue.class.getName(), bytes, 0, bytes.length);
               }
               catch (IOException e)
               {
                  throw new ClassNotFoundException("", e);
               }
               finally
               {
                  IOTools.safeClose(in);
               }
            }
            return replicatedValueClass;
         }
      }
      else
      {
         return super.loadClass(name);
      }
   }
}
