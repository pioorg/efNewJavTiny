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

package org.przybyl.efNewJavTiny.tasks.task02;

import static org.przybyl.efNewJavTiny.tasks.task02.Client.Level.*;

import java.math.*;
import java.util.*;


// In this implementation of strategy pattern use lambda expression to simplify the code.
public class StrategicApp {

	public static void main(String[] args) {

		BigDecimal orderValue = new BigDecimal("333");
		List<Client> clients = Arrays.asList(new Client(GOLD), new Client(SILVER), new Client(NONE));
		for (Client client : clients) {
			BigDecimal calculatedDiscount = DiscountSelector.chooseDiscount(client).calculateDiscount(orderValue);
			System.out.println(String.format("For client with level %s we can offer %s discount.", client.getLevel(), calculatedDiscount));
		}
	}
}

@FunctionalInterface
interface DiscountStrategy {
	BigDecimal calculateDiscount(BigDecimal total);

	static BigDecimal tenPercent(BigDecimal total) {
		return byMultiplier(total, "0.1");
	}

	static BigDecimal twentyPercent(BigDecimal total) {
		return byMultiplier(total, "0.2");
	}

	static BigDecimal roundToTen(BigDecimal total) {
		return total.remainder(BigDecimal.TEN);
	}

	private static BigDecimal byMultiplier(BigDecimal total, String multiplier) {
		return total.multiply(new BigDecimal(multiplier));
	}
}

class Client {
	private final Level level;

	Client(Level level) {
		this.level = level;
	}

	public Level getLevel() {
		return level;
	}

	enum Level {NONE, SILVER, GOLD}

}

class DiscountSelector {
	static DiscountStrategy chooseDiscount(Client client) {
		switch (client.getLevel()) {
			case GOLD:
				// for complex algorithms with many usage cases
				return DiscountStrategy::twentyPercent;
			case SILVER:
				// for simple lambdas with single use only
				return total -> total.multiply(new BigDecimal("0.1"));
			case NONE:
			default:
				return DiscountStrategy::roundToTen;
		}
	}
}


