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
package org.gatein.pc.portlet.container;

public class ObjectSupport
{

   /** . */
   private final String id;

   /** . */
   private int created;

   /** . */
   private int started;

   /** . */
   private int stopped;

   /** . */
   private int destroy;

   /** . */
   Callback createCallback;

   /** . */
   Callback startCallback;

   /** . */
   Callback stopCallback;

   /** . */
   Callback destroyCallback;

   public ObjectSupport(String id)
   {
      this.id = id;
      this.createCallback = null;
      this.startCallback = null;
      this.stopCallback = null;
      this.destroyCallback = null;
   }

   public String getId()
   {
      return id;
   }

   public int getStarted()
   {
      return started;
   }

   public int getStopped()
   {
      return stopped;
   }

   public void create() throws Exception
   {
      created++;

      //
      if (createCallback != null)
      {
         createCallback.execute();
      }
   }

   public void start() throws Exception
   {
      started++;

      //
      if (startCallback != null)
      {
         startCallback.execute();
      }
   }

   public void stop()
   {
      stopped++;

      //
      if (stopCallback != null)
      {
         stopCallback.execute();
      }
   }

   public void destroy()
   {
      destroy++;

      //
      if (destroyCallback != null)
      {
         destroyCallback.execute();
      }
   }

   public interface Callback
   {
      void execute();
   }

   public static class Failure implements Callback
   {

      /** . */
      private RuntimeException failure;

      @Override
      public void execute()
      {
         failure = new RuntimeException();
         throw failure;
      }

      public RuntimeException getFailure()
      {
         return failure;
      }
   }
}
