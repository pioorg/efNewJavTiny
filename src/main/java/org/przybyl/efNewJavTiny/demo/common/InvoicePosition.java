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

import java.math.*;
import java.util.*;

public class InvoicePosition {
	private final String name;
	private final int quantity;
	private final BigDecimal unitPrice;

	public InvoicePosition(String name, int quantity, BigDecimal unitPrice) {
		this.name = name;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		InvoicePosition that = (InvoicePosition) o;
		return quantity == that.quantity &&
			name.equals(that.name) &&
			unitPrice.equals(that.unitPrice);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, quantity, unitPrice);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", InvoicePosition.class.getSimpleName() + "[", "]")
			.add("name='" + name + "'")
			.add("quantity=" + quantity)
			.add("unitPrice=" + unitPrice)
			.toString();
	}
}
