package com.zephyr.packages.scaner.utils;

import java.util.Comparator;

public class CommonDateComparator implements Comparator<ComparableDateOption> {

	@Override
	public int compare(ComparableDateOption o1, ComparableDateOption o2) {
		return o1.getDateField().compareTo(o2.getDateField());
	}

}
