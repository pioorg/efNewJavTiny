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


//  1. Here are some elements for you:
//	"ene", "due", "like", "fake"
//	2. Create a list of them Java 8 style.
//	3. Create a set of them Java 8 style as well.
//	4. For both the list and the set try to add one more element, "torba".
//	5. Now, using the elements from 1., try to create the list and the set using List.of() and Set.of()
//	6. and repeat step 4. for them. What do you see?
//  7. Use List.copyOf to create copies of list from 1. and from 4. Check if they're equal and ==.
//  8. Create a list of just two elements and print the full class name of the result.
//	9. Print the contents of Set.of. Restart the application a few times and observe results.
//	10. Create array of the set created in 9.

import java.util.*;

public class NewMethodsInCollections {

	public static void main(String[] args) {

		List<String> list8 = Arrays.asList("ene", "due", "like", "fake");
		Set<String> set8 = new HashSet<>(list8);

//		list8.add("torba");
		set8.add("torba");

		List<String> listOf = List.of("ene", "due", "like", "fake");
		Set<String> setOf = Set.of("ene", "due");

//		listOf.add("torba");
//		setOf.add("torba");
		List<String> copyList8 = List.copyOf(list8);
		Set<String> copySet8 = Set.copyOf(set8);

		List<String> copyListOf = List.copyOf(listOf);
		Set<String> copySetOf = Set.copyOf(setOf);

		checkEquality(copyList8, list8);
		checkEquality(copySet8, set8);
		checkEquality(copyListOf, listOf);
		checkEquality(copySetOf, setOf);

		System.out.println(List.of(1, 2).getClass().getCanonicalName());
		System.out.println(setOf);
		System.out.println(setOf.toArray(String[]::new));
	}

	private static void checkEquality(Collection<?> one, Collection<?> two) {
		System.out.println(String.format("Collections equal? %s", one.equals(two)));
		System.out.println(String.format("Collections ==? %s", one == two));
	}

}
