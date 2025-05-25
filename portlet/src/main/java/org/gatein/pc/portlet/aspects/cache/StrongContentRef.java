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
package org.gatein.pc.portlet.aspects.cache;

import org.gatein.pc.api.invocation.response.ContentResponse;

/**
 * Use strong references.
 *
 */
public class StrongContentRef extends ContentRef
{

   /** The serialVersionUID */
   private static final long serialVersionUID = -8194245397756941208L;

   /** The content. */
   private transient ContentResponse content;

   /**
    * @param content the content
    * @throws IllegalArgumentException if the content is null
    */
   public StrongContentRef(ContentResponse content) throws IllegalArgumentException
   {
      if (content == null)
      {
         throw new IllegalArgumentException("Content must not be null");
      }
      this.content = content;
   }

   public ContentResponse getContent()
   {
      return content;
   }
}
