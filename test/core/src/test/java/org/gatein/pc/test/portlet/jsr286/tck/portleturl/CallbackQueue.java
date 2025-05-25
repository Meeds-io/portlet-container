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
package org.gatein.pc.test.portlet.jsr286.tck.portleturl;

import org.gatein.pc.test.unit.Assert;

import javax.portlet.PortletURLGenerationListener;
import javax.portlet.PortletURL;
import javax.portlet.ResourceURL;
import java.util.LinkedList;

public class CallbackQueue
{

   /** . */
   private static LinkedList<PortletURLSnapshot> queue = new LinkedList<PortletURLSnapshot>();

   public static PortletURLSnapshot next()
   {
      Assert.assertTrue(queue.size() > 0);
      return queue.removeFirst();
   }

   public static void clear()
   {
      queue.clear();
   }

   public static int size()
   {
      return queue.size();
   }

   public static PortletURLGenerationListener createListener(final String id)
   {
      return new PortletURLGenerationListener()
      {
         public void filterActionURL(PortletURL portletURL)
         {
            queue.addLast(PortletURLSnapshot.createActionURL(id, portletURL));
         }

         public void filterRenderURL(PortletURL portletURL)
         {
            queue.addLast(PortletURLSnapshot.createRenderURL(id, portletURL));
         }

         public void filterResourceURL(ResourceURL resourceURL)
         {
            queue.addLast(PortletURLSnapshot.createResourceURL(id, resourceURL));
         }
      };
   }
}
