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

import java.time.*;
import java.util.*;

public class Invoice {
	private final String client;
	private final Instant date;
	private final List<InvoicePosition> positions;

	public Invoice(String client, Instant date, List<InvoicePosition> positions) {
		this.client = client;
		this.date = date;
		this.positions = positions;
	}

	public String getClient() {
		return client;
	}

	public Instant getDate() {
		return date;
	}

	public List<InvoicePosition> getPositions() {
		return positions;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Invoice invoice = (Invoice) o;
		return client.equals(invoice.client) &&
			date.equals(invoice.date) &&
			positions.equals(invoice.positions);
	}

	@Override
	public int hashCode() {
		return Objects.hash(client, date, positions);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Invoice.class.getSimpleName() + "[", "]")
			.add("client='" + client + "'")
			.add("date=" + date)
			.add("positions=" + positions)
			.toString();
	}
}
