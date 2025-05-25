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

import org.gatein.common.util.ParameterValidation;

import java.io.Serializable;

public class StatefulPortletContext<S extends Serializable> extends PortletContext
{

   public static <S extends Serializable> StatefulPortletContext<S> create(String id, StatefulPortletContext<S> spc)
   {
      return new StatefulPortletContext<S>(id, spc.type, spc.state, true);
   }

   static <S extends Serializable> StatefulPortletContext<S> create(Components components, StatefulPortletContext<S> spc)
   {
      return new StatefulPortletContext<S>(components, spc.type, spc.state);
   }

   public static <S extends Serializable> StatefulPortletContext<S> create(String id, PortletStateType<S> type, S state)
   {
      return new StatefulPortletContext<S>(id, type, state, true);
   }

   /** . */
   private final S state;

   /** . */
   private final PortletStateType<S> type;

   StatefulPortletContext(String id, PortletStateType<S> type, S state, boolean interpret) throws IllegalArgumentException
   {
      super(id, interpret);

      ParameterValidation.throwIllegalArgExceptionIfNull(type, "Portlet type");
      ParameterValidation.throwIllegalArgExceptionIfNull(state, "Portlet state");

      this.type = type;
      this.state = state;
   }

   StatefulPortletContext(Components components, PortletStateType<S> type, S state)
   {
      super(components);

      ParameterValidation.throwIllegalArgExceptionIfNull(type, "Portlet type");
      ParameterValidation.throwIllegalArgExceptionIfNull(state, "Portlet state");

      this.type = type;
      this.state = state;
   }

   public PortletStateType<S> getType()
   {
      return type;
   }

   public boolean equals(Object o)
   {
      if (this == o)
      {
         return true;
      }
      if (o == null || getClass() != o.getClass())
      {
         return false;
      }
      if (!super.equals(o))
      {
         return false;
      }

      //
      StatefulPortletContext<?> that = (StatefulPortletContext<?>)o;

      //
      if (type.getJavaType().equals(that.type.getJavaType()))
      {
         S thatState = type.getJavaType().cast(that.getState());
         return type.equals(state, thatState);
      }

      //
      return false;
   }

   public int hashCode()
   {
      int result = super.hashCode();
      result = 31 * result + (state != null ? state.hashCode() : 0);
      return result;
   }

   public S getState()
   {
      return state;
   }

   public String toString()
   {
      return "StatefulPortletContext[" + getId() + "," + type.toString(state) + "]";
   }
}
