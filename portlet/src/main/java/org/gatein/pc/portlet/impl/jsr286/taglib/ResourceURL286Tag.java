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
package org.gatein.pc.portlet.impl.jsr286.taglib;

import javax.portlet.BaseURL;
import javax.portlet.ResourceURL;


public class ResourceURL286Tag extends GenerateURL286Tag
{
   /** The serialVersionUID */
   private static final long serialVersionUID = -4132423536342433557L;
   public static String typeParameter = "resource";

   private String id;

   private String cacheability;

   public String getId()
   {
      return id;
   }

   public void setId(String id)
   {
      this.id = id;
   }

   public String getCacheability()
   {
      return cacheability;
   }

   protected void setId(ResourceURL resourceURL)
   {
      if (id != null)
      {
         resourceURL.setResourceID(id);
      }
   }

   public void setCacheability(ResourceURL resourceURL)
   {
      if (cacheability != null)
      {
         resourceURL.setCacheability(cacheability);
      }
      else
      {
         resourceURL.setCacheability(ResourceURL.PAGE);
      }
   }


   public void setCacheability(String cacheability)
   {
      this.cacheability = cacheability;
   }

   /* (non-Javadoc)
    * @see org.gatein.pc.portlet.taglib.GenerateURLTag#addTypeParameter()
    */

   protected String getTypeValue()
   {
      return typeParameter;
   }

   protected BaseURL generateURL() throws Exception
   {
      BaseURL newPortletURL = super.generateURL();

      setId((ResourceURL)newPortletURL);
      setCacheability((ResourceURL)newPortletURL);

      return newPortletURL;
   }

}

