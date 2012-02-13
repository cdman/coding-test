package com.example;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public final class DivideOperatorTest extends AbstractOperatorTest {
	public DivideOperatorTest() {
		super(Arrays.asList("DIVIDE BY 123", "DIVIDE BY +42", "DIVIDE BY -1", "DIVIDE BY 3.1415", "DIVIDE BY -1E-5"),
			Arrays.asList("DIVIDE BY ", " DIVIDE BY 123", "DIVIDE BY -1.1.1"));
	}
	
	@Test
	public void testAdditionResult() {
		ResultHolder result = new ResultHolder(1);
		Operator op = getOperatorInstance();
		
		op.matchesLine("DIVIDE BY 2");
		op.performOp(result);
		op.matchesLine("DIVIDE BY 2");
		op.performOp(result);
		
		assertEquals(1.0/4.0d, result.getResult(), 1E-10);
	}
	
	@Override
	Operator getOperatorInstance() {
		return new DivideOperator();
	}
}