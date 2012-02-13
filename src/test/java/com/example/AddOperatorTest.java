package com.example;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public final class AddOperatorTest extends AbstractOperatorTest {
	public AddOperatorTest() {
		super(Arrays.asList("ADD 123", "ADD +42", "ADD -1", "ADD 3.1415", "ADD -1E-5"),
			Arrays.asList("ADD ", " ADD 123", "ADD -1.1.1"));
	}
	
	@Test
	public void testAdditionResult() {
		ResultHolder result = new ResultHolder(0);
		Operator op = getOperatorInstance();
		
		op.matchesLine("ADD 1");
		op.performOp(result);
		op.matchesLine("ADD 1");
		op.performOp(result);
		
		assertEquals(2, result.getResult(), 1E-10);
	}

	@Override
	Operator getOperatorInstance() {
		return new AddOperator();
	}
}
