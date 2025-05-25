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
package org.gatein.pc.test.controller.unit;

public class ControllerRequestParameterNames
{
   /**
    * The life cycle type of the invocation. The values accepted are <code>ACTION_LIFECYCLE</code>,
    * <code>RENDER_LIFECYCLE</code> and <code>RESOURCE_LIFECYCLE</code>.
    */
   public static final String LIFECYCLE_PHASE = "phase";

   /** The window id. */
   public static final String WINDOW_ID = "windowid";

   /** The portlet mode. */
   public static final String MODE = "mode";

   /** The window state. */
   public static final String WINDOW_STATE = "windowstate";

   /** The portlet navigational state for any type of lifecycle. */
   public static final String NAVIGATIONAL_STATE = "navigationalstate";

   /** The portlet resource state for lifecycle of type <code>RENDER_LIFECYCLE</code>. */
   public static final String RESOURCE_STATE = "resourcestate";

   /** The portlet interaction state for lifecycle of type <code>ACTION_LIFECYCLE</code>. */
   public static final String INTERACTION_STATE = "interactionstate";

   /** The page state for any kind of lifecycle. */
   public static final String PAGE_NAVIGATIONAL_STATE = "pagenavigationalstate";

   /** The public navigational state changes of a portlet for lifecycle of type <code>RENDER_LIFECYCLE</code>. */
   public static final String PUBLIC_NAVIGATIONAL_STATE_CHANGES = "publicnavigationalstatechanges";

   /** The resource id for lifecycle of type <code>RESOURCE_LIFECYCLE</code>. */
   public static final String RESOURCE_ID = "resourceid";

   /** The resource cacheability for lifecycle of type <code>RESOURCE_LIFECYCLE</code>. */
   public static final String RESOURCE_CACHEABILITY = "resourcecacheability";

   /** Denotes an action lifecycle operation. */
   public static final String ACTION_PHASE = "action";

   /** Denotes a render lifecycle operation. */
   public static final String RENDER_PHASE = "render";

   /** Denotes a resource lifecycle operation. */
   public static final String RESOURCE_PHASE = "resource";
}
