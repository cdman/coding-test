package com.example;

final class MultiplyOperator extends UnaryOperator {
	public MultiplyOperator() {
		super("MULTIPLY BY (.*)");
	}

	@Override
	double getNewResult(double currentResult, double lastMatch) {
		return currentResult * lastMatch;
	}
}

