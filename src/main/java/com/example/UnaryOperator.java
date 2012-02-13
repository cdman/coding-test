package com.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class UnaryOperator extends AbstractOperator {
	private final Pattern capturingRegex;
	private Double lastMatch;

	UnaryOperator(String capturingRegex) {
		this.capturingRegex = Pattern.compile(capturingRegex);
	}

	@Override
	boolean doMatchesLine(String line) {
		Matcher m = capturingRegex.matcher(line);
		if (!m.matches()) { return false; }
		lastMatch = getFloatingPointNumber(m.group(1));
		return lastMatch != null;
	}

	@Override
	void doPerformOp(ResultHolder currentResult) {
		currentResult.setResult(
			getNewResult(currentResult.getResult(), lastMatch));
		lastMatch = null;
	}
	
	abstract double getNewResult(double currentResult, double lastMatch);
}
