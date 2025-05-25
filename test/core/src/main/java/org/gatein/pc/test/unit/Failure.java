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
package org.gatein.pc.test.unit;

import java.io.Serializable;

/**
 * A failure, contains the description of a failure.
 *
 */
public class Failure implements Serializable
{

   /** The optional failure message. */
   private final String message;

   /** The optional failure cause. */
   private final Throwable cause;

   /** The type of failure. */
   private final FailureType type;

   /** The non null stack trace. */
   private final Throwable stackTrace;

   public Failure(String message, FailureType type)
   {
      this(message, null, type);
   }

   public Failure(Throwable cause, FailureType type)
   {
      this(null, cause, type);
   }

   public Failure(String message, Throwable cause, FailureType type)
   {
      if (message == null)
      {
         if (cause != null)
         {
            message = cause.getMessage();
         }
      }

      //
      this.message = message;
      this.cause = cause;
      this.type = type;
      this.stackTrace = cause != null ? cause : new Exception(message != null ? message : "Failed at");
   }

   public String getMessage()
   {
      return message;
   }

   public Throwable getCause()
   {
      return cause;
   }

   public Throwable getStackTrace()
   {
      return stackTrace;
   }

   public FailureType getType()
   {
      return type;
   }

   public static Failure createFailure(Throwable cause)
   {
      if (cause instanceof AssertionError)
      {
         return new Failure(cause, FailureType.ASSERTION);
      }
      else
      {
         return new Failure(cause, FailureType.ERROR);
      }
   }

   public static Failure createFailure(String message, Throwable cause)
   {
      if (cause instanceof AssertionError)
      {
         return new Failure(message, cause, FailureType.ASSERTION);
      }
      else
      {
         return new Failure(message, cause, FailureType.ERROR);
      }
   }

   public static Failure createErrorFailure(String message)
   {
      return new Failure(message, FailureType.ERROR);
   }

   public static Failure createErrorFailure(String message, Throwable cause)
   {
      return new Failure(message, cause, FailureType.ERROR);
   }

   public static Failure createErrorFailure(Throwable cause)
   {
      return new Failure(cause, FailureType.ERROR);
   }

   public static Failure createAssertionFailure(Throwable cause)
   {
      return new Failure(cause, FailureType.ASSERTION);
   }

   public static Failure createAssertionFailure(String message)
   {
      return new Failure(message, FailureType.ASSERTION);
   }
}
