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
package org.gatein.pc.portlet.aspects;

import org.gatein.pc.portlet.container.PortletApplication;
import org.gatein.pc.portlet.container.PortletContainer;
import org.gatein.pc.portlet.container.ContainerPortletInvoker;
import org.gatein.pc.api.invocation.PortletInvocation;
import org.gatein.pc.portlet.PortletInvokerInterceptor;
import org.gatein.pc.api.invocation.response.PortletInvocationResponse;
import org.gatein.pc.api.spi.ServerContext;
import org.gatein.pc.api.PortletInvokerException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import java.io.IOException;

/**
 * This interceptor dispatch the call to the target web application.
 *
 */
public class ContextDispatcherInterceptor extends PortletInvokerInterceptor
{

   /** . */
   public static final String REQ_ATT_COMPONENT_INVOCATION = "org.jboss.portal.attribute.component_invocation";

   public ContextDispatcherInterceptor()
   {
   }

   public PortletInvocationResponse invoke(PortletInvocation invocation) throws IllegalArgumentException, PortletInvokerException
   {
      PortletContainer container = (PortletContainer)invocation.getAttribute(ContainerPortletInvoker.PORTLET_CONTAINER);
      PortletApplication portletApplication = container.getPortletApplication();
      ServerContext reqCtx = invocation.getServerContext();
      ServletContext targetCtx = portletApplication.getContext().getServletContext();
      try
      {
         CallableImpl callable = new CallableImpl(invocation);
         reqCtx.dispatch(targetCtx, invocation.getRequest(), invocation.getResponse(), callable);
         return callable.response;
      }
      catch (Exception e)
      {
         if (e instanceof PortletInvokerException)
         {
            throw (PortletInvokerException)e;
         }
         else if (e instanceof RuntimeException)
         {
            throw (RuntimeException)e;
         }
         else if (e instanceof ServletException)
         {
            ServletException se = (ServletException)e;

            //
            if (se.getRootCause() != null && se.getRootCause() instanceof Exception)
            {
               e = (Exception)se.getRootCause();
            }
         }

         //
         throw new PortletInvokerException(e);
      }

   }

   private class CallableImpl implements ServerContext.Callable
   {

      /** . */
      private final PortletInvocation invocation;

      /** . */
      private PortletInvocationResponse response;

      private CallableImpl(PortletInvocation invocation)
      {
         this.invocation = invocation;
      }

      @Override
      public void call(ServletContext context, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
      {
         HttpServletRequest oldReq = invocation.getRequest();
         HttpServletResponse oldResp = invocation.getResponse();
         try
         {
            invocation.setRequest(req);
            invocation.setResponse(resp);
            req.setAttribute(REQ_ATT_COMPONENT_INVOCATION, invocation);
            response = ContextDispatcherInterceptor.super.invoke(invocation);
         }
         catch (Exception e)
         {
            throw new ServletException(e);
         }
         finally
         {
            req.setAttribute(REQ_ATT_COMPONENT_INVOCATION, null);
            invocation.setRequest(oldReq);
            invocation.setResponse(oldResp);
         }
      }
   }
}
