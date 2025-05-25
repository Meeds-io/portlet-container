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
package org.gatein.pc.api.invocation.response;

import org.gatein.pc.api.Mode;
import org.gatein.pc.api.StateString;

import javax.xml.namespace.QName;
import java.util.Map;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.io.Serializable;

/**
 * Update the navigational state.
 *
 */
public class UpdateNavigationalStateResponse extends PortletInvocationResponse
{

   /** . */
   private ResponseProperties properties;

   /** The navigational state returned. */
   private StateString navigationalState;

   /** The new window state requested. */
   private org.gatein.pc.api.WindowState windowState;

   /** The new mode requested. */
   private org.gatein.pc.api.Mode mode;

   /** The attributes snapshot after the request. */
   private Map<String, Object> attributes;

   /** . */
   private List<Event> producedEvents;

   /**
    * The update to the public parameters. Each entry having a zero length value must be interpeted as
    * a public parameter removal otherwise it must be interpreted as a public parameter values update.
    */
   protected Map<String, String[]> publicNavigationalStateUpdates;

   public UpdateNavigationalStateResponse()
   {
      navigationalState = null;
      windowState = null;
      mode = null;
      publicNavigationalStateUpdates = null;
      producedEvents = Collections.emptyList();
   }

   public ResponseProperties getProperties()
   {
      return properties;
   }

   public void setProperties(ResponseProperties properties)
   {
      this.properties = properties;
   }

   public Map<String, Object> getAttributes()
   {
      return attributes;
   }

   public void setAttributes(Map<String, Object> attributes)
   {
      this.attributes = attributes;
   }

   public Mode getMode()
   {
      return mode;
   }

   public void setMode(Mode mode)
   {
      this.mode = mode;
   }

   public org.gatein.pc.api.WindowState getWindowState()
   {
      return windowState;
   }

   public void setWindowState(org.gatein.pc.api.WindowState windowState)
   {
      this.windowState = windowState;
   }

   public StateString getNavigationalState()
   {
      return navigationalState;
   }

   public void setNavigationalState(StateString state)
   {
      this.navigationalState = state;
   }

   public Map<String, String[]> getPublicNavigationalStateUpdates()
   {
      return publicNavigationalStateUpdates;
   }

   public void setPublicNavigationalStateUpdates(Map<String, String[]> publicNavigationalStateUpdates)
   {
      this.publicNavigationalStateUpdates = publicNavigationalStateUpdates;
   }

   public void queueEvent(UpdateNavigationalStateResponse.Event event)
   {
      if (event == null)
      {
         throw new IllegalArgumentException("No null event accepted");
      }

      //
      if (producedEvents.size() == 0)
      {
         producedEvents = new ArrayList<Event>();
      }

      //
      producedEvents.add(event);
   }

   public List<UpdateNavigationalStateResponse.Event> getEvents()
   {
      return producedEvents;
   }

   /**
    * An event produced by a state response.
    */
   public static class Event
   {

      /** The optional event. */
      private QName name;

      /** The optional event payload. */
      private Serializable payload;

      public Event(QName name, Serializable payload)
      {
         if (name == null)
         {
            throw new IllegalArgumentException();
         }
         this.name = name;
         this.payload = payload;
      }

      public QName getName()
      {
         return name;
      }

      public Serializable getPayload()
      {
         return payload;
      }
   }
}
