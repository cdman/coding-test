package com.example;

/**
 * An operator object encapsulating a supported operation 
 */
interface Operator {
	/**
	 * Checks if the passed in line matches the syntax of the operator
	 * 
	 * @param line - the line to be parsed
	 * @return true if the line matches the syntax of this operator
	 * @throws NullPointerException if the line is null
	 */
	boolean matchesLine(String line);
	
	/**
	 * Performs the operator from the last successful {@link #matchesLine(String)}
	 * call and updates the value of the passed in {@link ResultHolder} object.
	 * 
	 * @throws NullPointerException if the {@link ResultHolder} reference is null
	 * or no successful {@link #matchesLine(String)} call happened before.
	 * 
	 * A {@link #performOp(ResultHolder)} consumes the result from {@link #matchesLine(String)}
	 * and thus it can be called only once after each succesful {@link #matchesLine(String)}.
	 */
	void performOp(ResultHolder currentResult);
}
