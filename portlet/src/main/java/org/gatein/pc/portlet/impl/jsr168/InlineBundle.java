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
package org.gatein.pc.portlet.impl.jsr168;

import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.gatein.pc.portlet.impl.info.ContainerPortletInfo;
import org.gatein.pc.api.info.MetaInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;
import java.util.Locale;

/**
 * A resource bundle that contains the inline information defined by the portlet specification.
 *
 */
public class InlineBundle extends ListResourceBundle
{

  private static final Log log = ExoLogger.getLogger(InlineBundle.class);

   /** . */
   private final Object[][] content;

   public InlineBundle(ContainerPortletInfo portletInfo)
   {
//      log.debug("Creates the parent bundle");

      //
      List<Object> list = new ArrayList<Object>(3);

      //
      String title = portletInfo.getMeta().getDefaultMetaValue(MetaInfo.TITLE);
      if (title != null)
      {
         list.add(new Object[]{Constants.JAVAX_PORTLET_TITLE, title});
      }

      //
      String shortTitle = portletInfo.getMeta().getDefaultMetaValue(MetaInfo.SHORT_TITLE);
      if (shortTitle != null)
      {
         list.add(new Object[]{Constants.JAVAX_PORTLET_SHORT_TITLE, shortTitle});
      }

      //
      String keywords = portletInfo.getMeta().getDefaultMetaValue(MetaInfo.KEYWORDS);
      if (keywords != null)
      {
         list.add(new Object[]{Constants.JAVAX_PORTLET_KEYWORDS, keywords});
      }

      //
      content = (Object[][])list.toArray(new Object[list.size()][]);
   }

   protected Object[][] getContents()
   {
      return content;
   }

   /**
    * This is the english locale.
    *
    * @return the english locale
    */
   public Locale getLocale()
   {
      return Locale.ENGLISH;
   }
}
