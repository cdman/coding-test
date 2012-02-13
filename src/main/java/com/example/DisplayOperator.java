package com.example;

import java.io.OutputStream;
import java.io.PrintStream;

class DisplayOperator extends AbstractOperator {
	private final static String DISPLAY_COMMAND = "DISPLAY RESULT";
	
	private final PrintStream output;

	DisplayOperator(OutputStream dest) {
		this.output = new PrintStream(dest);
	}

	@Override
	boolean doMatchesLine(String line) {
		return line.equals(DISPLAY_COMMAND);
	}

	@Override
	void doPerformOp(ResultHolder currentResult) {
		output.println(currentResult.getResult());
	}
}
