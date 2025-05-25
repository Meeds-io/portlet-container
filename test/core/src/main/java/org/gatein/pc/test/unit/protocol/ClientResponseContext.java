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
package org.gatein.pc.test.unit.protocol;

import org.gatein.pc.test.unit.protocol.response.Response;

import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;

public class ClientResponseContext
{

   /** . */
   private final ClientRequestContext commandContext;

   /** . */
   private final Response response;

   /** . */
   private final Map<String, Serializable> payload;

   ClientResponseContext(ClientRequestContext commandContext, Response response)
   {
      this.commandContext = commandContext;
      this.response = response;
      this.payload = new HashMap<String, Serializable>();
   }

   public ClientRequestContext getCommandContext()
   {
      return commandContext;
   }

   public Map<String, Serializable> getPayload()
   {
      return payload;
   }

   public Object getPayload(String name)
   {
      if (name == null)
      {
         throw new IllegalArgumentException();
      }
      return payload.get(name);
   }

   public void setPayload(String name, Object value)
   {
      if (name == null)
      {
         throw new IllegalArgumentException();
      }
      if (value == null)
      {
         payload.remove(name);
      }
      else
      {
         payload.put(name, (Serializable)value);
      }
   }

   public void removePayload(String name)
   {
      setPayload(name, null);
   }

   public Response getResponse()
   {
      return response;
   }
}
