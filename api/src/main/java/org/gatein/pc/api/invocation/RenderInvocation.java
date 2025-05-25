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
package org.gatein.pc.api.invocation;

import org.gatein.pc.api.spi.PortletInvocationContext;

public class RenderInvocation extends PortletInvocation
{

   /** . */
   private String validationToken;

   /** . */
   private String encoding;

   public RenderInvocation(PortletInvocationContext ctx) throws IllegalArgumentException
   {
      super(ctx);

      //
      this.ctx = ctx;
      this.encoding = "utf-8";
   }

   public String getValidationToken()
   {
      return validationToken;
   }

   public void setValidationToken(String validationToken)
   {
      this.validationToken = validationToken;
   }

   public String getEncoding()
   {
      return encoding;
   }

   public void setEncoding(String encoding)
   {
      this.encoding = encoding;
   }
}
