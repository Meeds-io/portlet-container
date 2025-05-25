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
package org.gatein.pc.portlet.impl.info;

import org.gatein.pc.api.TransportGuarantee;
import org.gatein.pc.api.info.SecurityInfo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

public class ContainerSecurityInfo implements SecurityInfo
{

   /** . */
   private final Set<TransportGuarantee> tgs;

   /** . */
   private final Set<TransportGuarantee> rotgs;

   /** . */
   private final Map<String, String> roleRefs;

   public ContainerSecurityInfo()
   {
      Set<TransportGuarantee> tgs = new HashSet<TransportGuarantee>();
      tgs.add(TransportGuarantee.NONE);

      //
      this.tgs= tgs;
      this.roleRefs = new HashMap<String, String>();
      this.rotgs = Collections.unmodifiableSet(tgs);
   }

   public String getRoleRef(String roleName)
   {
      return roleRefs.get(roleName);
   }

   public boolean containsRoleRef(String roleName)
   {
      return roleRefs.containsKey(roleName);
   }

   public void addRoleRef(String roleName, String roleLink)
   {
      if (roleName == null)
      {
         throw new IllegalArgumentException();
      }

      //
      roleRefs.put(roleName, roleLink);
   }

   public void addTransportGuarantee(TransportGuarantee transportGuarantee)
   {
      tgs.add(transportGuarantee);
   }

   public boolean containsTransportGuarantee(TransportGuarantee transportGuarantee)
   {
      return tgs.contains(transportGuarantee);
   }

   public Set<TransportGuarantee> getTransportGuarantees()
   {
      return rotgs;
   }
}