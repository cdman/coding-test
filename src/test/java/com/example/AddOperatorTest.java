package com.example;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public final class AddOperatorTest extends AbstractOperatorTest {
	public AddOperatorTest() {
		super(Arrays.asList("ADD 123", "ADD +42", "ADD -1"),
			Arrays.asList("ADD ", " ADD 123"));
	}
	
	@Test
	public void testAdditionResult() {
		ResultHolder result = new ResultHolder(0);
		Operator op = getOperatorInstance();
		
		op.matchesLine("ADD 1");
		op.performOp(result);
		op.matchesLine("ADD 1");
		op.performOp(result);
		
		assertEquals(2, result.getResult());
	}

	@Override
	Operator getOperatorInstance() {
		return new AddOperator();
	}
}
