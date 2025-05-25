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

import java.util.Set;

/**
 * An attribute resolver.
 *
 */
public interface AttributeResolver<K, V>
{
   /**
    * Returns the set of keys of the attributes bound in that resolver.
    *
    * @return a set of keys
    */
   Set<K> getKeys();

   /**
    * Return an attribute from this resolver.
    *
    * @param attrKey
    * @return the attribute value or null if it is not found
    * @throws IllegalArgumentException if the attribute key is not valid
    */
   V getAttribute(K attrKey) throws IllegalArgumentException;

   /**
    * Update an attribute value on this resolve. If the attribute value is null the resolver must treat the operation as
    * a removal of the attribute.
    *
    * @param attrKey
    * @param attrValue the attribute value
    * @throws IllegalArgumentException if the attribute key is not valid
    */
   void setAttribute(K attrKey, V attrValue) throws IllegalArgumentException;
}
