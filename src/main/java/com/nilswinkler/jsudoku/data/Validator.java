package com.nilswinkler.jsudoku.data;

import java.util.HashSet;
import java.util.Set;

public class Validator {
	private Set numbers = new HashSet(9);
	
	public Validator() {
	}
	
	public boolean contains(int number) {
		return numbers.contains(new Integer(number));
	}
	
	public void add(int number) {
		if (number != 0) {
			numbers.add(new Integer(number));
		}
	}
}
