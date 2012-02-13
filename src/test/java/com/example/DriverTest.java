package com.example;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;

public final class DriverTest {
	private ByteArrayOutputStream out;
	private Driver driver;
	
	@Test
	public void testDriver() {
		driver.consume("ADD 4\n");
		driver.consume("DIVIDE BY 5\n\r");
		driver.consume("MULTIPLY BY 2");
		driver.consume("SUBSTRACT 10");
		driver.consume("DISPLAY RESULT");
		driver.consume("ADD 2");
		driver.consume("DISPLAY RESULT");
		
		assertEquals(
			String.format("%.1f%n%.1f%n", 
				(4.0d/5.0d*2.0d) - 10.0d,  
				(4.0d/5.0d*2.0d) - 10.0d + 2.0d), 
			out.toString());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testUnknownCommand() {
		driver.consume("FAKE COMMAND");
	}
	
	@Test(expected=NullPointerException.class)
	public void testNullLine() {
		driver.consume(null);
	}		
	
	@Before
	public void setUp() {
		out = new ByteArrayOutputStream();
		driver = new Driver(out);
	}
}
