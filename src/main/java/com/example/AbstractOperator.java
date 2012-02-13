package com.example;

abstract class AbstractOperator implements Operator {
	private boolean didMatch = false;
	
	@Override
	public boolean matchesLine(String line) {
		didMatch = doMatchesLine(line);
		return didMatch;
	}
	
	abstract boolean doMatchesLine(String line);
	
	@Override
	public void performOp(ResultHolder currentResult) {
		if (!didMatch) { 
			throw new NullPointerException("Last match not found! "
				+ "Perhaps matchesLine wasn't called or performOp called repeteadly?"); 
		}		
		doPerformOp(currentResult);
		didMatch = false;
	}
	
	
	abstract void doPerformOp(ResultHolder currentResult);
	
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
