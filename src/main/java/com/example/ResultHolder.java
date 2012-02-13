package com.example;

/**
 * Encapsulates the result of the calculation and offers getters/setters for it 
 */
final class ResultHolder {
	private double result;
	
	public ResultHolder(double initialValue) {
		result = initialValue;
	}
	
	double getResult() {
		return result;
	}

	void setResult(double value) {
		result = value;
	}
}
