package com.jwetherell.algorithms.data_structures.test;

public class DataStruct{
	public DataStruct(int size) {
		this.bools = new boolean[size];
	}
	boolean[] bools;
	
	public void addBooleans(boolean[] input) {
		for(int i = 0; i < input.length; i++) {
			if(input[i]) {
				this.bools[i] = true;
			}
		}
	}
	
	public double eval() {
		int counter = 0;
		for(int i = 0; i < bools.length; i++) {
			if(bools[i]) {
				counter = counter + 1;
			}
		}

		
		double ret = (double)counter / (double)bools.length;
		return ret;
		
	}
	
}
