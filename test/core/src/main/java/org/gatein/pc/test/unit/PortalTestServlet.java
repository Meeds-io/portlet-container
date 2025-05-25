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
package org.gatein.pc.test.unit;

import org.gatein.pc.controller.PortletController;
import org.gatein.pc.test.controller.unit.ControllerRequestFactory;
import org.gatein.pc.controller.state.PageNavigationalState;
import org.gatein.pc.test.controller.unit.URLParameterConstants;
import org.gatein.pc.controller.request.ControllerRequest;
import org.gatein.pc.controller.response.ControllerResponse;
import org.gatein.pc.api.invocation.response.ResponseProperties;
import org.gatein.pc.test.controller.ControllerResponseRendererFactory;
import org.gatein.pc.test.controller.PageRenderer;
import org.gatein.pc.test.controller.unit.PortletControllerContextImpl;
import org.gatein.pc.test.controller.Renderer;
import org.gatein.pc.test.controller.unit.RendererContextImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PortalTestServlet extends HttpServlet
{

   @Override
   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
   {
      try
      {
         _service(req, resp);
      }
      catch (Exception e)
      {
         if (e instanceof ServletException)
         {
            throw (ServletException)e;
         }
         if (e instanceof IOException)
         {
            throw (IOException)e;
         }
         if (e instanceof RuntimeException)
         {
            throw (RuntimeException)e;
         }
         throw new ServletException(e);
      }
   }

   protected void _service(HttpServletRequest req, HttpServletResponse resp) throws Exception
   {
      PortletControllerContextImpl context = new PortletControllerContextImpl(req, resp, getServletContext());

      //
      PortletController controller = new PortletController();

      //
      String type = req.getParameter(URLParameterConstants.TYPE);

      //
      if (URLParameterConstants.PORTLET_TYPE.equals(type))
      {
         ControllerRequestFactory factory = new ControllerRequestFactory(context.getPageNavigationalStateSerialization());
         ControllerRequest request = factory.decode(req);

         //
         ControllerResponse response = controller.process(context, request);

         //
         ControllerResponseRendererFactory rendererFactory = new ControllerResponseRendererFactory(
            true,
            true,
            request.getPageNavigationalState());

         //
         Renderer renderer = rendererFactory.getRenderer(response);

         //
         renderer.render(new RendererContextImpl(context));
      }
      else
      {

         PageRenderer renderer = new PageRenderer(new ResponseProperties(), new PageNavigationalState(false));

         //
         renderer.render(new RendererContextImpl(context));
      }
   }
}
