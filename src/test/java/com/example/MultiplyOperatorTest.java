package com.example;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public final class MultiplyOperatorTest extends AbstractOperatorTest {
	public MultiplyOperatorTest() {
		super(Arrays.asList("MULTIPLY BY 123", "MULTIPLY BY +42", "MULTIPLY BY -1", "MULTIPLY BY 3.1415", "MULTIPLY BY -1E-5"),
			Arrays.asList("MULTIPLY BY ", " MULTIPLY BY 123", "MULTIPLY BY -1.1.1"));
	}
	
	@Test
	public void testAdditionResult() {
		ResultHolder result = new ResultHolder(1);
		Operator op = getOperatorInstance();
		
		op.matchesLine("MULTIPLY BY 2");
		op.performOp(result);
		op.matchesLine("MULTIPLY BY 2");
		op.performOp(result);
		
		assertEquals(4.0d, result.getResult(), 1E-10);
	}

	@Override
	Operator getOperatorInstance() {
		return new MultiplyOperator();
	}
}