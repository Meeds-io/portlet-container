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
package org.gatein.pc.test.url;

import org.gatein.common.util.ParameterMap;

import java.util.Map;

public class ParameterEncoder
{

   /** . */
   private final CodecBuilder builder;

   /** . */
   private final ParameterMap parameters;

   public ParameterEncoder(CodecBuilder builder)
   {
      this.builder = new CodecBuilder(builder);
      this.parameters = new ParameterMap();
   }

   public ParameterMap getParameters()
   {
      return parameters;
   }

   public void encode(ParameterMap actualParameters, ParameterMap metaParameters)
   {
      parameters.clear();

      //
      long meta = 0;

      //
      for (String mv : builder.metaParameterNames)
      {
         String pv = metaParameters.getValue(mv);

         //
         meta *= 2;

         //
         if (pv != null)
         {
            String[] pvs = actualParameters.getValues(mv);
            if (pvs != null)
            {
               String[] blah = new String[1 + pvs.length];
               blah[0] = pv;
               System.arraycopy(pvs, 0, blah, 1, pvs.length);
               parameters.setValues(mv, blah);
            }
            else
            {
               parameters.setValue(mv, pv);
            }
            meta |= 1;
         }
      }

      //
      String def = Long.toBinaryString(meta);
      String[] pvs = actualParameters.getValues(builder.reservedParameterName);
      if (pvs != null)
      {
         String[] tmp = new String[1 + pvs.length];
         tmp[0] = def;
         System.arraycopy(pvs, 0, tmp, 1, pvs.length);
         parameters.setValues(builder.reservedParameterName, tmp);
      }
      else
      {
         parameters.setValue(builder.reservedParameterName, def);
      }

      //
      for (Map.Entry<String, String[]> entry : actualParameters.entrySet())
      {
         String name = entry.getKey();
         if (!parameters.containsKey(name))
         {
            String[] values = entry.getValue();
            parameters.setValues(name, values);
         }
      }
   }
}
