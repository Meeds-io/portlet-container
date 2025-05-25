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
package org.gatein.pc.api.invocation.resolver;

import jakarta.servlet.http.HttpServletRequest;
import java.security.Principal;

public class PrincipalAttributeResolver extends AbstractSessionAttributeResolver
{

   /** . */
   private String cachedPrincipalName;

   /** . */
   private String cachedMapKey;

   public PrincipalAttributeResolver(HttpServletRequest req)
   {
      super(req);
   }

   protected String getMapKey()
   {
      Principal principal = req.getUserPrincipal();

      //
      if (cachedMapKey != null)
      {
         if (cachedPrincipalName == null)
         {
            if (principal != null)
            {
               cachedMapKey = null;
            }
         }
         else
         {
            if (principal == null || (cachedPrincipalName.equals(principal.getName()) == false))
            {
               cachedMapKey = null;
            }
         }
      }

      //
      if (cachedMapKey == null)
      {
         if (principal == null)
         {
            cachedMapKey = "portal.principal";
            cachedPrincipalName = null;
         }
         else
         {
            cachedMapKey = "portal.principal." + principal.getName();
            cachedPrincipalName = principal.getName();
         }
      }

      //
      return cachedMapKey;
   }
}