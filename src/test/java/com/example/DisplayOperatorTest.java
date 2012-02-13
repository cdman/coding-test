package com.example;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

public final class DisplayOperatorTest extends AbstractOperatorTest {
	public DisplayOperatorTest() {
		super(Arrays.asList("DISPLAY RESULT"),
			Arrays.asList("DIISPLAY RESULT"));
	}
	
	@Test
	public void testDisplayOperator() {
		ResultHolder result = new ResultHolder(1.618);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Operator op = new DisplayOperator(out);
		
		op.matchesLine("DISPLAY RESULT");
		op.performOp(result);
		
		assertEquals(String.format("1.618%n"), out.toString());
	}
	
	@Override
	Operator getOperatorInstance() {
		return new DisplayOperator(new ByteArrayOutputStream());
	}
}
