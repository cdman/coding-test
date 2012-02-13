package com.example;

final class DivideOperator extends UnaryOperator {
	public DivideOperator() {
		super("DIVIDE BY (.*)");
	}

	@Override
	double getNewResult(double currentResult, double lastMatch) {
		return currentResult / lastMatch;
	}
}
