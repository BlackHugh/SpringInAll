package com.zephyr.packages.scaner.utils;

import java.util.Comparator;

public class CommonStringComparator implements Comparator<ComparableStringOption> {

	@Override
	public int compare(ComparableStringOption o1, ComparableStringOption o2) {
		return o1.getStringField().compareTo(o2.getStringField());
	}

}
