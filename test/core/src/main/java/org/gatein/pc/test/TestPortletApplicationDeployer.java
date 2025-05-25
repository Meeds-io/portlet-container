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
package org.gatein.pc.test;

import org.gatein.pc.portlet.container.ContainerPortletInvoker;
import org.gatein.pc.portlet.impl.deployment.DeploymentException;
import org.gatein.pc.portlet.impl.deployment.PortletApplicationDeployer;

import jakarta.servlet.ServletContext;
import java.util.ArrayList;
import java.util.HashMap;

public class TestPortletApplicationDeployer extends PortletApplicationDeployer
{

   /** Keep track of deployers. */
   private static final ArrayList<TestPortletApplicationDeployer> deployers = new ArrayList<TestPortletApplicationDeployer>();

   /** . */
   private static final HashMap<String, ServletContext> deployments = new HashMap<String, ServletContext>();

   public static void deploy(ServletContext deployment)
   {
      if (!deployments.containsKey(deployment.getContextPath()))
      {
         deployments.put(deployment.getContextPath(), deployment);
         synchronized (deployers)
         {
            for (TestPortletApplicationDeployer deployer : deployers)
            {
               try
               {
                  deployer.add(deployment);
               }
               catch (DeploymentException e)
               {
                  e.printStackTrace();
               }
            }
         }
      }
   }

   public synchronized static void undeploy(ServletContext deployment)
   {
      if (deployments.remove(deployment.getContextPath()) != null)
      {
         synchronized (deployers)
         {
            for (TestPortletApplicationDeployer deployer : deployers)
            {
               deployer.remove(deployment);
            }
         }
      }
   }

   public TestPortletApplicationDeployer(ContainerPortletInvoker containerPortletInvoker)
   {
      super(containerPortletInvoker);
   }

   public void start()
   {
      synchronized (deployers)
      {
         for (ServletContext deployment : deployments.values())
         {
            try
            {
               add(deployment);
            }
            catch (DeploymentException e)
            {
               e.printStackTrace();
            }
         }

         //
         deployers.add(this);
      }
   }

   public void stop()
   {
      synchronized (deployers)
      {
         deployers.remove(this);

         //
         for (ServletContext deployment : deployments.values())
         {
            remove(deployment);
         }
      }
   }
}
