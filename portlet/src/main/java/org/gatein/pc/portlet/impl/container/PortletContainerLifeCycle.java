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
package org.gatein.pc.portlet.impl.container;

import org.gatein.pc.portlet.container.object.PortletContainerObject;
import org.gatein.pc.portlet.container.managed.LifeCycleStatus;
import org.gatein.pc.portlet.container.managed.ManagedPortletContainer;
import org.gatein.pc.portlet.container.managed.ManagedObjectRegistryEventListener;
import org.gatein.pc.portlet.container.PortletContainerContext;
import org.gatein.pc.portlet.container.PortletContainer;
import org.gatein.pc.api.info.PortletInfo;

import javax.portlet.Portlet;

public class PortletContainerLifeCycle extends LifeCycle implements ManagedPortletContainer
{

   /** . */
   private PortletApplicationLifeCycle portletApplicationLifeCycle;

   /** . */
   final PortletContainerContext portletContainerContext;

   /** . */
   final PortletContainerObject portletContainer;

   PortletContainerLifeCycle(
      PortletApplicationLifeCycle portletApplicationLifeCycle,
      PortletContainerContext portletContainerContext,
      PortletContainerObject portletContainer)
   {
      this.portletApplicationLifeCycle = portletApplicationLifeCycle;
      this.portletContainerContext = portletContainerContext;
      this.portletContainer = portletContainer;
   }

   @Override
   protected void invokeCreate() throws Exception
   {
      if (portletApplicationLifeCycle.getStatus().getStage() < LifeCycleStatus.CREATED.getStage())
      {
         throw new DependencyNotResolvedException("The parent application is not created");
      }

      //
      for (PortletFilterLifeCycle portletFilterLifeCycle : portletApplicationLifeCycle.getDependencies(this))
      {
         if (portletFilterLifeCycle.getStatus().getStage() < LifeCycleStatus.CREATED.getStage())
         {
            throw new DependencyNotResolvedException("The filter " + portletFilterLifeCycle + " is not created");
         }
      }

      //
      portletContainer.create();
   }

   protected void invokeStart() throws Exception
   {
      if (portletApplicationLifeCycle.getStatus().getStage() < LifeCycleStatus.STARTED.getStage())
      {
         throw new DependencyNotResolvedException("The parent application is not started");
      }

      //
      for (PortletFilterLifeCycle portletFilterLifeCycle : portletApplicationLifeCycle.getDependencies(this))
      {
         if (portletFilterLifeCycle.getStatus().getStage() < LifeCycleStatus.STARTED.getStage())
         {
            throw new DependencyNotResolvedException("The filter " + portletFilterLifeCycle + " is not started");
         }
      }

      //
      portletContainer.start();
   }

   protected void invokeStop()
   {
      portletContainer.stop();
   }

   @Override
   public Portlet getPortletInstance()
   {
      return portletContainer.getPortletInstance();
   }

   @Override
   protected void invokeDestroy() throws Exception
   {
      portletContainer.destroy();
   }

   public String getId()
   {
      return portletContainer.getId();
   }

   public PortletInfo getInfo()
   {
      return portletContainer.getInfo();
   }

   public PortletApplicationLifeCycle getManagedPortletApplication()
   {
      return portletApplicationLifeCycle;
   }

   public String toString()
   {
      return getClass().getSimpleName() + "[" + portletContainer.getId() + "]";
   }

   public PortletContainer getPortletContainer()
   {
      return portletContainer;
   }

   protected ManagedObjectRegistryEventListener getListener()
   {
      return portletApplicationLifeCycle.getListener();
   }
}
