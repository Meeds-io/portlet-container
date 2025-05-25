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

import org.gatein.common.i18n.LocalizedString;
import org.gatein.common.util.ParameterValidation;
import org.gatein.pc.api.info.EventInfo;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ContainerEventInfo implements EventInfo
{

   /** . */
   private final QName name;

   /** . */
   private final ContainerTypeInfo type;

   /** . */
   private final LocalizedString displayName;

   /** . */
   private final LocalizedString description;

   /** . */
   private final List<QName> aliases;

   public ContainerEventInfo(
      QName name,
      ContainerTypeInfo type,
      LocalizedString displayName,
      LocalizedString description, List<QName> aliases)
   {
      this.name = name;
      this.type = type;
      this.displayName = displayName;
      this.description = description;
      if (ParameterValidation.existsAndIsNotEmpty(aliases))
      {
         this.aliases = aliases;
      }
      else
      {
         this.aliases = new ArrayList<QName>();
      }
   }

   public LocalizedString getDisplayName()
   {
      return displayName;
   }

   public LocalizedString getDescription()
   {
      return description;
   }

   public QName getName()
   {
      return name;
   }

   public ContainerTypeInfo getType()
   {
      return type;
   }

   public Collection<QName> getAliases()
   {
      return Collections.unmodifiableCollection(aliases);
   }
}
