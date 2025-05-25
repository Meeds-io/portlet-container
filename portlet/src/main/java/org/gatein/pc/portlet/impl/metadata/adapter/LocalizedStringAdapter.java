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
package org.gatein.pc.portlet.impl.metadata.adapter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.gatein.common.i18n.LocaleFormat;
import org.gatein.common.i18n.LocalizedString;
import static org.gatein.pc.portlet.impl.metadata.PortletMetaDataConstants.*;
import org.gatein.pc.portlet.impl.metadata.common.LocalizedDescriptionMetaData;

public class LocalizedStringAdapter
   extends XmlAdapter<List<LocalizedDescriptionMetaData>, LocalizedString>
{

   @Override
   public List<LocalizedDescriptionMetaData> marshal(LocalizedString arg0) throws Exception
   {
      throw new UnsupportedOperationException();
   }

   @Override
   public LocalizedString unmarshal(List<LocalizedDescriptionMetaData> descriptionList) throws Exception
   {
      Map<Locale, String> map = new LinkedHashMap<Locale, String>();
      for (LocalizedDescriptionMetaData d : descriptionList)
      {
         Locale locale = LocaleFormat.DEFAULT.getLocale(d.getLang());
         map.put(locale, d.getDescription());
      }
      return new LocalizedString(map, new Locale(DEFAULT_LOCALE));
   }

}
