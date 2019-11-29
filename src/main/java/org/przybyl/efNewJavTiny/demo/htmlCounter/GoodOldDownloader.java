/*
 * 	Copyright (C) 2019 Piotr Przybył
 *
 * 	This program is free software: you can redistribute it and/or modify
 * 	it under the terms of the GNU General Public License as published by
 * 	the Free Software Foundation, either version 3 of the License, or
 * 	(at your option) any later version.
 *
 * 	This program is distributed in the hope that it will be useful,
 * 	but WITHOUT ANY WARRANTY; without even the implied warranty of
 * 	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * 	GNU General Public License for more details.
 *
 * 	You should have received a copy of the GNU General Public License
 * 	along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.przybyl.efNewJavTiny.demo.htmlCounter;

import java.io.*;
import java.net.*;

/**
 * The purpose of this code is to download the whole content of HTML page.
 *
 * But please be aware that this is (as of 2019) no more a good idea.
 * This is only for demonstration purposes.
 * E.g. you should try HTTP/2 client...
 */
public class GoodOldDownloader {

	public static String getWholePage(String pageAddress) {
		try(var inputStream = new URL(pageAddress).openStream()) {
			var reader = new BufferedReader(new InputStreamReader(inputStream));
			var builder = new StringBuilder();
			for(var line = ""; line != null; line = reader.readLine()) {
				builder.append(line).append("\n");
			}
			return builder.toString();
		} catch (Exception e) {
			// This block idea is really dumb. Whatever happens, we simply return null.
			// Don't do that in production unless you'd like to get fired.
			e.printStackTrace();
			return null;
		}

	}
}
