/*******************************************************************************
 * Copyright (c) 2012 Jens Kristian Villadsen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     Jens Kristian Villadsen - initial API and implementation
 ******************************************************************************/
package gmusic.api.comm;

import com.google.gson.Gson;

public class JSON
{
	private final static Gson gson = new Gson();

	public static <T> T Deserialize(String data, Class<T> clazz)
	{
		return gson.fromJson(data, clazz);
	}
}
