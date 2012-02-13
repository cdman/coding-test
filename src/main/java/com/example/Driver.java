package com.example;

import java.util.*;
import java.io.OutputStream;

final class Driver {
	private final Collection<Operator> operators;
	private final ResultHolder resultHolder;
	
	Driver(OutputStream dest) {
		List<Operator> ops = new ArrayList<Operator>();
		ops.add(new AddOperator());
		ops.add(new DisplayOperator(dest));
		ops.add(new DivideOperator());
		ops.add(new MultiplyOperator());
		ops.add(new SubstractOperator());
		this.operators = Collections.unmodifiableCollection(ops);
		
		this.resultHolder = new ResultHolder(0.0d);
	}
	
	void consume(String line) {
		String trimmedLine = line.replaceAll("[\\n\\r]+$", "").trim();
		for (Operator op : operators) {
			if (op.matchesLine(trimmedLine)) {
				op.performOp(resultHolder);
				return;
			}
		}
		
		throw new IllegalArgumentException(String.format("No operator matched the input '%s'", line));
	}
}
