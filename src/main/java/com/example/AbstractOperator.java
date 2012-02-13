package com.example;

abstract class AbstractOperator implements Operator {
	/**
	 * Tries to parse a floating point number. If successful it returns the value, null otherwise.
	 * @return
	 */
	protected Double getFloatingPointNumber(String str) {
		try {
			return Double.parseDouble(str);
		} catch (NumberFormatException ex) {
			return null;
		}
	}
}
