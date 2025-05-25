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
package org.gatein.pc.test.portlet;

import junit.framework.TestCase;
import org.gatein.pc.portlet.impl.jsr168.ByteBuffer;
import org.gatein.pc.portlet.impl.jsr168.CharBuffer;

import java.io.PrintWriter;
import java.io.OutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ContentBufferTestCase extends TestCase
{

   public void testResetChars()
   {
      CharBuffer buffer = new CharBuffer();
      PrintWriter writer = buffer.getWriter();
      writer.print("foo");
      buffer.reset();
      assertEquals("", buffer.getChars());
   }

   public void testResetBytes() throws IOException
   {
      ByteBuffer buffer = new ByteBuffer();
      OutputStream out = buffer.getOutputStream();
      out.write("foo".getBytes("UTF8"));
      buffer.reset();
      assertEquals(0, buffer.getBytes().length);
   }

   public void testResetAfterCommit()
   {
      ByteBuffer buffer1 = new ByteBuffer();
      buffer1.commit();
      try
      {
         buffer1.reset();
         fail();
      }
      catch (IllegalStateException ignore)
      {
      }
      CharBuffer buffer2 = new CharBuffer();
      buffer2.commit();
      try
      {
         buffer2.reset();
         fail();
      }
      catch (IllegalStateException ignore)
      {
      }
   }

   public void testCommit()
   {
      ByteBuffer buffer1 = new ByteBuffer();
      assertFalse(buffer1.isCommited());
      buffer1.commit();
      assertTrue(buffer1.isCommited());
      CharBuffer buffer2 = new CharBuffer();
      assertFalse(buffer2.isCommited());
      buffer2.commit();
      assertTrue(buffer2.isCommited());
   }

   public void testWriteCharsAfterCommit()
   {
      CharBuffer buffer = new CharBuffer();
      buffer.commit();
      PrintWriter writer = buffer.getWriter();
      assertNotNull(writer);
      writer.print("foo");
      writer.close();
      assertEquals("foo", buffer.getChars());
   }

   public void testWriteCharsAndCommit()
   {
      CharBuffer buffer = new CharBuffer();
      PrintWriter writer = buffer.getWriter();
      assertNotNull(writer);
      writer.print("foo");
      buffer.commit();
      writer.print("bar");
      writer.close();
      assertEquals("foobar", buffer.getChars());
   }

   public void testWriteBytesAfterCommit() throws IOException
   {
      ByteBuffer buffer = new ByteBuffer();
      buffer.commit();
      OutputStream out = buffer.getOutputStream();
      assertNotNull(out);
      out.write("foo".getBytes("UTF8"));
      out.close();
      assertTrue(Arrays.equals("foo".getBytes("UTF8"), buffer.getBytes()));
   }

   public void testWriteBytesAndCommit() throws IOException
   {
      ByteBuffer buffer = new ByteBuffer();
      buffer.commit();
      OutputStream out = buffer.getOutputStream();
      out.write("foo".getBytes("UTF8"));
      assertNotNull(out);
      out.write("bar".getBytes("UTF8"));
      out.close();
      assertTrue(Arrays.equals("foobar".getBytes("UTF8"), buffer.getBytes()));
   }

   public void testFlushWriterDoesCommit()
   {
      CharBuffer buffer = new CharBuffer();
      PrintWriter writer = buffer.getWriter();
      writer.print("foo");
      writer.flush();
      assertTrue(buffer.isCommited());
   }

   public void testCloseWriterDoesCommit()
   {
      CharBuffer buffer = new CharBuffer();
      PrintWriter writer = buffer.getWriter();
      writer.print("foo");
      writer.close();
      assertTrue(buffer.isCommited());
   }

   public void testFlushStreamDoesCommit() throws IOException
   {
      ByteBuffer buffer = new ByteBuffer();
      OutputStream out = buffer.getOutputStream();
      out.write("foo".getBytes("UTF8"));
      out.flush();
      assertTrue(buffer.isCommited());
   }

   public void testClosestreamDoesCommit() throws IOException
   {
      ByteBuffer buffer = new ByteBuffer();
      OutputStream out = buffer.getOutputStream();
      out.write("foo".getBytes("UTF8"));
      out.close();
      assertTrue(buffer.isCommited());
   }
}
