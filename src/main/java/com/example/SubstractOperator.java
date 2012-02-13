package com.example;

final class SubstractOperator extends SingleValueOperator {
	public SubstractOperator() {
		super("SUBSTRACT (.*)");
	}

	@Override
	double getNewResult(double currentResult, double lastMatch) {
		return currentResult - lastMatch;
	}
}
