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

package org.przybyl.efNewJavTiny.demo.common;

import static java.util.List.*;

import java.math.*;
import java.time.*;
import java.time.format.*;
import java.time.temporal.*;
import java.util.*;

public interface CompanyA {

	DateTimeFormatter formatter = new DateTimeFormatterBuilder()
		.parseStrict()
		.appendValue(ChronoField.YEAR)
		.appendLiteral("-")
		.appendValue(ChronoField.MONTH_OF_YEAR)
		.appendLiteral("-")
		.appendValue(ChronoField.DAY_OF_MONTH)
		.toFormatter();

	static List<Person> getEmployees() {
		return of(
			new Person("Susan", 32, 12345),
			new Person("Jessica", 22, 22341),
			new Person("Sarah", 32, 12346),
			new Person("Jack", 48, 21111),
			new Person("Mary", 47, 18567),
			new Person("Marie", 22, 12346),
			new Person("Sarah", 48, 20000),
			new Person("Jack", 33, 20202)
		);
	}

	static List<Invoice> getInvoices() {
		return of(
			new Invoice("ACME", createDate("2019-01-02"), of(
				new InvoicePosition("3 inch screw", 14, BigDecimal.valueOf(12)),
				new InvoicePosition("5 inch screw", 10, BigDecimal.valueOf(20))
			)),
			new Invoice("Josh Garage", createDate("2019-01-02"), of(
				new InvoicePosition("PH1 screwdriver", 5, BigDecimal.valueOf(50)),
				new InvoicePosition("wrench", 1, BigDecimal.valueOf(123))
			)),
			new Invoice("Josh Garage", createDate("2019-01-04"), of(
				new InvoicePosition("3 inch screw", 55, BigDecimal.valueOf(13))
			)),
			new Invoice("ACME", createDate("2019-02-02"), of(
				new InvoicePosition("hammer", 20, BigDecimal.valueOf(40)),
				new InvoicePosition("wrench", 2, BigDecimal.valueOf(120))
			))
		);
	}

	static Instant createDate(String toParse) {
		TemporalAccessor parse = formatter.parse(toParse);
		ZonedDateTime zonedDateTime = LocalDate.from(parse).atStartOfDay(ZoneId.of("Europe/Warsaw"));
		return zonedDateTime.toInstant();
	}

	static boolean instantInYearAndMonth(Instant instant, int year, int month) {
		ZonedDateTime zonedDate = instant.atZone(ZoneId.of("Europe/Warsaw"));
		return zonedDate.getYear() == year && zonedDate.getMonthValue() == month;
	}
}
