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
package org.gatein.pc.api.invocation.resolver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class AbstractSessionAttributeResolver implements AttributeResolver
{

   /** . */
   protected final HttpServletRequest req;

   public AbstractSessionAttributeResolver(HttpServletRequest req)
   {
      if (req == null)
      {
         throw new IllegalArgumentException();
      }
      this.req = req;
   }


   public Set getKeys()
   {
      Map map = getMap(false);

      //
      if (map != null)
      {
         return map.keySet();
      }
      else
      {
         return Collections.EMPTY_SET;
      }
   }

   public Object getAttribute(Object attrKey) throws IllegalArgumentException
   {
      if (attrKey == null)
      {
         throw new IllegalArgumentException();
      }

      //
      Object value = null;
      Map map = getMap(false);
      if (map != null)
      {
         value = map.get(attrKey);
      }
      return value;
   }

   public void setAttribute(Object attrKey, Object attrValue) throws IllegalArgumentException
   {
      if (attrKey == null)
      {
         throw new IllegalArgumentException();
      }

      //
      Map map = getMap(false);
      if (map != null)
      {
         if (attrValue != null)
         {
            map.put(attrKey, attrValue);
         }
         else
         {
            map.remove(attrKey);
         }
      }
      else
      {
         if (attrValue != null)
         {
            map = getMap(true);
            map.put(attrKey, attrValue);
         }
      }
   }

   protected abstract String getMapKey();

   protected Map createMap(String mapKey)
   {
      return new HashMap();
   }

   private Map getMap(boolean create)
   {
      HttpSession session = req.getSession(create);
      if (session != null)
      {
         String mapKey = getMapKey();
         Map map = (Map)session.getAttribute(mapKey);
         if (map == null)
         {
            map = createMap(mapKey);
            session.setAttribute(mapKey, map);
         }
         return map;
      }
      else
      {
         return null;
      }
   }
}