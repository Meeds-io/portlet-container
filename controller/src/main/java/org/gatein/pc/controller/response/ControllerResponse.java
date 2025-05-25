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
package org.gatein.pc.controller.response;

/**
 * Must be used as base class for high level response provided by the controller that will be translated into something
 * at the portal level. The goal is to avoid to manipulate the HTTP response directly.
 * The test bed will of course use the HTTP response but the Presentation Framework will work differently.
 * So we really need to abstract everything done with the HttpServletResponse and *never* use it in the controller.
 * Typical usage should be : ControllerResponse response = controller.invoker(ControllerRequest request);
 */
public abstract class ControllerResponse
{
}
