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
package org.gatein.pc.api;

/**
 * Defines how a container URL should be formatted when rendered. 
 *
 */
public class URLFormat
{

   /** . */
   private final Boolean wantSecure;

   /** . */
   private final Boolean wantAuthenticated;

   /** . */
   private final Boolean wantRelative;

   /** . */
   private final Boolean wantEscapeXML;

   public URLFormat(Boolean wantSecure, Boolean wantAuthenticated, Boolean wantRelative, Boolean wantEscapeXML)
   {
      this.wantSecure = wantSecure;
      this.wantAuthenticated = wantAuthenticated;
      this.wantRelative = wantRelative;
      this.wantEscapeXML = wantEscapeXML;
   }

   public Boolean getWantSecure()
   {
      return wantSecure;
   }

   public Boolean getWantAuthenticated()
   {
      return wantAuthenticated;
   }

   public Boolean getWantRelative()
   {
      return wantRelative;
   }

   public Boolean getWantEscapeXML()
   {
      return wantEscapeXML;
   }
}
