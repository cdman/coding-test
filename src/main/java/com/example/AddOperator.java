package com.example;

final class AddOperator extends UnaryOperator {
	public AddOperator() {
		super("ADD (.*)");
	}
	
	@Override
	double getNewResult(double currentResult, double lastMatch) {
		return currentResult + lastMatch;
	}
}
