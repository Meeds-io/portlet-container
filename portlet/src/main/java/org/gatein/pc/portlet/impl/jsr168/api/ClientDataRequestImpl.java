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

import org.gatein.pc.api.invocation.ActionInvocation;
import org.gatein.pc.api.invocation.ResourceInvocation;
import org.gatein.pc.api.spi.RequestContext;
import org.gatein.pc.portlet.impl.jsr168.PortletContainerImpl;

import javax.portlet.ClientDataRequest;
import java.io.InputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.UnsupportedEncodingException;

public abstract class ClientDataRequestImpl extends PortletRequestImpl implements ClientDataRequest 
{

   /** . */
   protected final RequestContext requestContext;

   public ClientDataRequestImpl(PortletContainerImpl container, ActionInvocation invocation)
   {
      super(container, invocation);

      //
      this.requestContext = invocation.getRequestContext();
   }

   public ClientDataRequestImpl(PortletContainerImpl container, ResourceInvocation invocation)
   {
      super(container, invocation);

      //
      this.requestContext = invocation.getRequestContext();
   }

   public InputStream getPortletInputStream() throws IOException
   {
      if ("application/x-www-form-urlencoded".equals(requestContext.getContentType()))
      {
         throw new IllegalStateException();
      }
      return requestContext.getInputStream();
   }

   public BufferedReader getReader() throws UnsupportedEncodingException, IOException
   {
      if ("application/x-www-form-urlencoded".equals(requestContext.getContentType()))
      {
         throw new IllegalStateException();
      }
      return requestContext.getReader();
   }

   public String getCharacterEncoding()
   {
      return requestContext.getCharacterEncoding();
   }

   public String getContentType()
   {
      return requestContext.getContentType();
   }

   public int getContentLength()
   {
      return requestContext.getContentLength();
   }

   public void setCharacterEncoding(String s) throws UnsupportedEncodingException
   {
      // This method is frankly stupid
      throw new IllegalStateException("called after the body has been read");
      // req.setCharacterEncoding(s);
   }

   public String getMethod()
   {
      return clientContext.getMethod();
   }
}
