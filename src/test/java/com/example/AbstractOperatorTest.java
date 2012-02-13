package com.example;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public abstract class AbstractOperatorTest {
	private final Collection<String> expectedMatches;
	private final Collection<String> expectedNonMatches;

	AbstractOperatorTest(Collection<String> expectedMatches, Collection<String> expectedNonMatches) {
		this.expectedMatches = expectedMatches;
		this.expectedNonMatches = expectedNonMatches;
	}
	
	@Test
	public void testExpectedMatches() {
		for (String expectedMatch : expectedMatches) {
			assertTrue(
				String.format("Expected %s to be matched by operator but wasn't", expectedMatch),
				getOperatorInstance().matchesLine(expectedMatch)
			);
		}
	}
	
	@Test
	public void testExpectedNonMatches() {
		for (String expectedNonMatch : expectedNonMatches) {
			assertFalse(
				String.format("Expected %s not to be matched by operator but it was", expectedNonMatch),
				getOperatorInstance().matchesLine(expectedNonMatch)
			);
		}
	}
	
	@Test(expected=NullPointerException.class)
	public void testNPEWhenParameterIsNull() {
		getOperatorInstance().matchesLine(null);
	}

	@Test(expected=NullPointerException.class)
	public void testNPEWhenPerformOpParameterIsNull() {
		getOperatorInstance().performOp(null);
	}
	
	@Test(expected=NullPointerException.class)
	public void testNPEWhenPerformOpIsCalledBeforeMatch() {
		getOperatorInstance().performOp(new ResultHolder(0));
	}
	
	@Test(expected=NullPointerException.class)
	public void testNPEWhenPerformOpIsCalledRepeteadly() {
		Operator op = getOperatorInstance();
		String matchingLine = expectedMatches.iterator().next();
		
		op.matchesLine(matchingLine);
		op.performOp(new ResultHolder(0));
		op.performOp(new ResultHolder(0));
	}

	abstract Operator getOperatorInstance();
}
