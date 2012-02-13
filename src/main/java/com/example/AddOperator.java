package com.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class AddOperator extends AbstractOperator {
	private static final Pattern ADD_PATTERN = Pattern.compile("ADD " + NUMBER_GROUP);
	
	private String lastMatch;
	
	@Override
	public boolean matchesLine(String line) {
		Matcher m = ADD_PATTERN.matcher(line);
		if (!m.matches()) { return false; }
		lastMatch = m.group(1);
		return true;
	}

	@Override
	public void performOp(ResultHolder currentResult) {
		if (lastMatch == null) { 
			throw new NullPointerException("Last match not found! "
				+ "Perhaps matchesLine wasn't called or performOp called repeteadly?"); 
		}
		int matchValue = Integer.parseInt(lastMatch);
		currentResult.setResult( currentResult.getResult() + matchValue );
		lastMatch = null;
	}
}
