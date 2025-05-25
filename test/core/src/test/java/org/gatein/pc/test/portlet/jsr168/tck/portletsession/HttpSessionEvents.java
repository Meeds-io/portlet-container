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
package org.gatein.pc.test.portlet.jsr168.tck.portletsession;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.List;

public class HttpSessionEvents implements HttpSessionListener
{

   public static final ThreadLocal threadLocal = new ThreadLocal();

   public void sessionCreated(HttpSessionEvent event)
   {
      HttpSession session = event.getSession();
      List sessions = getEvents();
      if (sessions != null)
      {
         String id = session.getId();
         sessions.add(new Event(id, Event.CREATED));
      }
   }

   public void sessionDestroyed(HttpSessionEvent event)
   {
      HttpSession session = event.getSession();
      List sessions = getEvents();
      if (sessions != null)
      {
         String id = session.getId();
         sessions.add(new Event(id, Event.DESTROYED));
      }
   }

   public static List getEvents()
   {
      return (List)threadLocal.get();
   }

   public static void activate()
   {
      if (threadLocal.get() != null)
      {
         throw new IllegalStateException("Already activated");
      }
      List sessions = new ArrayList();
      threadLocal.set(sessions);
   }

   public static void desactivate()
   {
      threadLocal.set(null);
   }

   public static class Event
   {
      public static final int CREATED = 0;
      public static final int DESTROYED = 1;
      private final String sessionId;
      private final int type;

      public Event(String sessionId, int type)
      {
         this.sessionId = sessionId;
         this.type = type;
      }

      public String getSessionId()
      {
         return sessionId;
      }

      public int getType()
      {
         return type;
      }
   }
}
