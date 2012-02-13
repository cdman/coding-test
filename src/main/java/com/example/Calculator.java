package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class Calculator {
	public static void main(String[] args) throws IOException {
		Driver driver = new Driver(System.out);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ( (line = reader.readLine()) != null ) {
			driver.consume(line);
		}
	}
}
