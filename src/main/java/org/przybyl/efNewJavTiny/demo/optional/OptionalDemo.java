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

package org.przybyl.efNewJavTiny.demo.optional;

import java.util.*;

public class OptionalDemo {
	private static Random random = new Random();

	public static void main(String[] args) {
		Optional<Integer> luckyNo = randomNumber();

		//BAAD C0DE, don't do that!
		if (luckyNo.isPresent()) {
			System.out.println("Look, I got " + luckyNo.get());
		} else {
			System.out.println("No luck this time");
		}

		//this is what you should do
		luckyNo.ifPresent(value -> System.out.println("Look, I got " + value));
		luckyNo.ifPresentOrElse(
			value -> System.out.println("Look, I got " + value),
			() -> System.out.println("No luck this time"));

		luckyNo.stream().filter(value -> value % 2 == 0).findFirst()
			.ifPresentOrElse(
				value -> System.out.println("We got an even value! " + value),
				() -> System.out.println("The value wasn't even..."));
		Integer concreteInteger = luckyNo.map(value -> value * 3).orElseGet(() -> {
			System.out.println("Generating -1...");
			return -1;
		});
		System.out.println(concreteInteger);

		Integer secondInteger = luckyNo.map(value -> value * 3).orElse(generateMinus2());
		System.out.println(secondInteger);
	}

	private static Integer generateMinus2() {
		System.out.println("Generating -2... always ;-)");
		return -2;
	}


	private static Optional<Integer> randomNumber() {
		return random.nextInt(2) == 1 ? Optional.of(random.nextInt(10)) : Optional.empty();
	}
}
