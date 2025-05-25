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
package org.gatein.pc.portlet.impl.jsr168.api;

import javax.portlet.PortletURLGenerationListener;
import javax.portlet.PortletURL;
import javax.portlet.ResourceURL;
import java.util.List;

/**
 * An implementation of the API that chains.
 *
 */
public class PortletURLGenerationListenerChain implements PortletURLGenerationListener
{

   /** . */
   private PortletURLGenerationListener[] listeners;

   public PortletURLGenerationListenerChain(List<PortletURLGenerationListener> listeners)
   {
      this.listeners = listeners.toArray(new PortletURLGenerationListener[listeners.size()]);
   }

   public void filterActionURL(PortletURL portletURL)
   {
      for (PortletURLGenerationListener listener : listeners)
      {
         try
         {
            listener.filterActionURL(portletURL);
         }
         catch (Exception e)
         {
            e.printStackTrace();
         }
      }
   }

   public void filterRenderURL(PortletURL portletURL)
   {
      for (PortletURLGenerationListener listener : listeners)
      {
         try
         {
            listener.filterRenderURL(portletURL);
         }
         catch (Exception e)
         {
            e.printStackTrace();
         }
      }
   }

   public void filterResourceURL(ResourceURL resourceURL)
   {
      for (PortletURLGenerationListener listener : listeners)
      {
         try
         {
            listener.filterResourceURL(resourceURL);
         }
         catch (Exception e)
         {
            e.printStackTrace();
         }
      }
   }
}
