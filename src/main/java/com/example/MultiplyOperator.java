package com.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class MultiplyOperator extends AbstractOperator {
	private static final Pattern MULTIPLY_PATTERN = Pattern.compile("MULTIPLY BY (.*)");
	
	private Double lastMatch;
	
	@Override
	boolean doMatchesLine(String line) {
		Matcher m = MULTIPLY_PATTERN.matcher(line);
		if (!m.matches()) { return false; }
		lastMatch = getFloatingPointNumber(m.group(1));
		return lastMatch != null;
	}

	@Override
	public void doPerformOp(ResultHolder currentResult) {
		currentResult.setResult( currentResult.getResult() * lastMatch );
		lastMatch = null;
	}
}

