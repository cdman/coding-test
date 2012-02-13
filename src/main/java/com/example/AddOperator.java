package com.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class AddOperator extends AbstractOperator {
	private static final Pattern ADD_PATTERN = Pattern.compile("ADD (.*)");
	
	private Double lastMatch;
	
	@Override
	boolean doMatchesLine(String line) {
		Matcher m = ADD_PATTERN.matcher(line);
		if (!m.matches()) { return false; }
		lastMatch = getFloatingPointNumber(m.group(1));
		return lastMatch != null;
	}

	@Override
	public void doPerformOp(ResultHolder currentResult) {
		currentResult.setResult( currentResult.getResult() + lastMatch );
		lastMatch = null;
	}
}
