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

import java.util.*;

public class DownloadedPage {
	private String address;
	private String content;

	public DownloadedPage(String address, String content) {
		this.address = address;
		this.content = content;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isContentLongerThan(int length) {
		System.out.println("Length check");
		return content != null && content.length() > length;
	}

	public boolean hasEnoughOccurrences(String needle, int count) {
		System.out.println("Occurrences check");
		return content != null && StringUtils.countOccurrences(this.content, needle) >= count;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", DownloadedPage.class.getSimpleName() + "[", "]")
			.add("address='" + address + "'")
			.add("content='" + content + "'")
			.toString();
	}
}
