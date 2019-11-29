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

package org.przybyl.efNewJavTiny.tasks;

import java.util.*;
import java.util.stream.*;


// Instead of the boxed stream, use primitive stream
public class StreamToPrimitiveStream {
	public static void main(String[] args) {
		Optional<Long> sumOfRoundsBoxed = Stream.of(1.3, 2.4, 3.6, 4.7).map(Math::round).reduce(Long::sum);
		long sumOfRounds = 0; //change zero to implementation

		System.out.println(sumOfRoundsBoxed);
		System.out.println(sumOfRounds);
	}
}
