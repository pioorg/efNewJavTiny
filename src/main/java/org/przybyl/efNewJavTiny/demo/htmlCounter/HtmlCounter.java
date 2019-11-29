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

import java.time.*;
import java.util.*;
import java.util.stream.*;

// 1. Download content of the pages from the list
// 2. Filter out the ones which don't have at least 50 occurrences of "the"
// 3. Show the URL of the one which has the longest content.

public class HtmlCounter {

	private static List<String> pagesToCheck = getPagesToCheck();


	public static void main(String[] args) {
		Instant start = Instant.now();
		oldWay(pagesToCheck);
		Instant oldStop = Instant.now();
		newWay(pagesToCheck.stream().parallel());
		Instant newStop = Instant.now();

		//Please mind that this is not a proper benchmark!!!
		System.out.println(Duration.between(start, oldStop));
		System.out.println(Duration.between(oldStop, newStop));
	}

	private static void oldWay(List<String> pagesToCheck) {

	}

	private static void newWay(Stream<String> pagesToCheck) {

	}






	private static List<String> getPagesToCheck() {
		return Arrays.asList(
			"https://en.wikipedia.org/",
			"https://www.nytimes.com/",
			"https://www.yahoo.com/",
//			"https://www.reddit.com/",
			"https://www.msn.com/",
			"https://www.youtube.com/",
			"https://www.imdb.com/",
			"https://www.ebay.com/",
			"https://www.tripadvisor.com/",
			"https://www.walmart.com/",
			"https://www.nytimes.com/",
			"https://www.forbes.com/"
		);
	}

}
