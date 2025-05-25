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
package org.gatein.pc.controller.event;

import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

/**
 * An event associated with a portlet window.
 *
 */
public class WindowEvent
{

   private static final AtomicLong generator = new AtomicLong();

   /** . */
   private final QName name;

   /** . */
   private final Serializable payload;

   /** . */
   private final String windowId;

   /** . */
   private final long serialNumber = generator.incrementAndGet();

   public WindowEvent(QName name, Serializable payload, String windowId)
   {
      if (name == null)
      {
         throw new IllegalArgumentException();
      }
      if (windowId == null)
      {
         throw new IllegalArgumentException();
      }
      this.name = name;
      this.payload = payload;
      this.windowId = windowId;
   }

   public QName getName()
   {
      return name;
   }

   public Serializable getPayload()
   {
      return payload;
   }

   public String getWindowId()
   {
      return windowId;
   }

   public long getSerialNumber()
   {
      return serialNumber;
   }

   public String toString()
   {
      return "Event[name=" + name + ",windowId=" + windowId + ",payload=" + payload + ",serialNumber=" + serialNumber + "]";
   }
}
