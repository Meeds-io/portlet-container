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
package org.gatein.pc.portlet.deployment;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;
import org.gatein.pc.portlet.impl.deployment.staxnav.PortletApplicationMetaDataBuilder;
import org.gatein.pc.portlet.impl.metadata.PortletApplication20MetaData;

import org.xml.sax.SAXException;

public abstract class AbstractMetaDataTestCase extends TestCase
{

   protected PortletApplication20MetaData unmarshall(String file) throws SAXException, IOException
   {
      return unmarshall(file, false);
   }

   protected PortletApplication20MetaData unmarshall(String file, boolean fail) throws SAXException, IOException
   {
      try
      {
         PortletApplicationMetaDataBuilder builder = new PortletApplicationMetaDataBuilder();
         builder.setSchemaValidation(true);
         String path = getPath(file);
         URL url = new URL(path);
         InputStream in = url.openStream();
         assertNotNull(in);
         PortletApplication20MetaData build = builder.build(in);
         if (fail)
         {
            throw new AssertionFailedError("Was expecting unmarshalling of " + file + " to fail");
         }
         return build;
      }
      catch (Exception e)
      {
         if (fail)
         {
            // OK
            return null;
         }
         else
         {
            throw fail(e);
         }
      }
   }

   protected final Error fail(Throwable t)
   {
      AssertionFailedError afe = new AssertionFailedError();
      afe.initCause(t);
      throw afe;
   }

   protected final Error fail(Throwable t, String msg)
   {
      AssertionFailedError afe = new AssertionFailedError(msg);
      afe.initCause(t);
      throw afe;
   }

   protected String getPath(String file)
   {
      URL url = Thread.currentThread().getContextClassLoader().getResource(file);
      if (url == null)
      {
         fail(file + " not found.");
      }
      return url.toString();
   }

   protected InputStream getStream(String file)
   {
      return Thread.currentThread().getContextClassLoader().getResourceAsStream(file);
   }

}
