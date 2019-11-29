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

package org.przybyl.efNewJavTiny.demo.executeAroundDemo;

import java.time.*;


interface Stopper {
	static void measure(Runnable toMeasure) {
		var start = Instant.now();
		toMeasure.run();
		var stop = Instant.now();
		var between = Duration.between(start, stop);
		System.out.println(String.format("Running took %d ms.", between.toMillis()));
	}
}
