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
package org.gatein.pc.portlet.impl.jsr168.taglib;

import javax.portlet.PortletURL;
import javax.portlet.BaseURL;

/**
 * The actionURL tag for the JSR 168 Portlet specification.
 * Creates a URL that must point to the current portlet and must trigger an action request with the supplied
 * parameters.
 *
 */
public class ActionURLTag extends GenerateURLTag
{
   /** The serialVersionUID */
   private static final long serialVersionUID = 7474331828863555492L;
   public static String typeParameter = "action";

   /* (non-Javadoc)
    * @see org.gatein.pc.portlet.taglib.GenerateURLTag#addTypeParameter()
    */
   protected String getTypeValue()
   {
      return typeParameter;
   }

   protected BaseURL generateURL() throws Exception
   {
      PortletURL newPortletURL =  (PortletURL)super.generateURL();

      setWindowState(newPortletURL);

      setPortletMode(newPortletURL);

      return newPortletURL;
   }
}
