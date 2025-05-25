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
package org.gatein.pc.controller;

import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.gatein.pc.api.PortletInvokerException;
import org.gatein.pc.controller.request.ControllerRequest;
import org.gatein.pc.controller.response.ControllerResponse;
import org.gatein.pc.api.invocation.response.PortletInvocationResponse;

abstract class RequestHandler<T extends ControllerRequest>
{
   /** . */
   protected static final Log log = ExoLogger.getLogger(RequestHandler.class);

   /** . */
   protected PortletController controller;

   /** . */
   protected final Class<T> t;

   protected RequestHandler(Class<T> t, PortletController controller)
   {
      this.t = t;
      this.controller = controller;
   }

   public ControllerResponse handle(ControllerContext controllerContext, ControllerRequest request) throws PortletInvokerException
   {
      if (!t.isInstance(request))
      {
         throw new IllegalArgumentException("Request " + request + " cannot be handled by this handler");
      }

      //
      T req = t.cast(request);
      PortletInvocationResponse response = req.invoke(controllerContext);

      return processResponse(controllerContext, req, response);
   }

   abstract ControllerResponse processResponse(ControllerContext controllerContext, T request, PortletInvocationResponse response) throws PortletInvokerException;
}
