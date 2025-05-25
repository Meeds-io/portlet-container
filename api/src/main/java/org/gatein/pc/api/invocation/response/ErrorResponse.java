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
package org.gatein.pc.api.invocation.response;

import org.exoplatform.services.log.Log;
import org.gatein.common.util.Exceptions;

/**
 * Application level error.
 *
 */
public class ErrorResponse extends PortletInvocationResponse
{
   /** The logged throwable if any. */
   private final Throwable cause;

   /** There must be one error message. */
   private final String message;

   public ErrorResponse(String message)
   {
      if (message == null)
      {
         throw new IllegalArgumentException("There must be a message");
      }
      this.message = message;
      cause = null;
   }

   public ErrorResponse(Throwable cause)
   {
      if (cause == null)
      {
         throw new IllegalArgumentException("There must be a cause if there is no message");
      }
      this.cause = cause;
      this.message = cause.getMessage();
   }

   public ErrorResponse(String message, Throwable cause)
   {
      if (message == null)
      {
         throw new IllegalArgumentException("There must be a message");
      }
      if (cause == null)
      {
         throw new IllegalArgumentException("There must be a cause");
      }
      this.cause = cause;
      this.message = message;
   }

   /** The throwable. Can be a null object. */
   public Throwable getCause()
   {
      return cause;
   }

   /** The logged message. */
   public String getMessage()
   {
      return message;
   }

   /**
    * Logs an error message to the specified logger, using either the message or this ErrorResult's Throwable if
    * available.
    *
    * @param log        the logger
    * @param logMessage the additional message to log
    */
   public void logErrorTo(Log log, String logMessage)
   {
      if (cause != null)
      {
         log.error(logMessage, cause);
      }
      else
      {
         log.error(logMessage + "\n" + message);
      }
   }

   /**
    * Provides an HTML description of the error, using either the message or the encapsulated Throwable.
    *
    * @return an html formatted string
    */
   public String toHTML()
   {
      if (cause != null)
      {
         return Exceptions.toHTML(cause);
      }
      else
      {
         StringBuilder sb = new StringBuilder(255);
         sb.append("<div><code>").append(message).append("</code></div>");
         return sb.toString();
      }
   }
}
