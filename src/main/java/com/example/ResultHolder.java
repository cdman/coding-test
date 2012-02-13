package com.example;

/**
 * Encapsulates the result of the calculation and offers getters/setters for it 
 */
final class ResultHolder {
	private int result;
	
	public ResultHolder(int initialValue) {
		result = initialValue;
	}
	
	int getResult() {
		return result;
	}

	void setResult(int value) {
		result = value;
	}
}
