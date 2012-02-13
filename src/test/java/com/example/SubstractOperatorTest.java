package com.example;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public final class SubstractOperatorTest extends AbstractOperatorTest {
	public SubstractOperatorTest() {
		super(Arrays.asList("SUBSTRACT 123", "SUBSTRACT +42", "SUBSTRACT -1", "SUBSTRACT 3.1415", "SUBSTRACT -1E-5"),
			Arrays.asList("SUBSTRACT ", " SUBSTRACT 123", "SUBSTRACT -1.1.1"));
	}
	
	@Test
	public void testSubstractionResult() {
		ResultHolder result = new ResultHolder(0.0d);
		Operator op = getOperatorInstance();
		
		op.matchesLine("SUBSTRACT 1");
		op.performOp(result);
		op.matchesLine("SUBSTRACT 1");
		op.performOp(result);
		
		assertEquals(-2.0d, result.getResult(), 1E-10);
	}

	@Override
	Operator getOperatorInstance() {
		return new SubstractOperator();
	}
}

