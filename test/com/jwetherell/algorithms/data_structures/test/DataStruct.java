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

    public float getCoverage() {
        float sum = 0;
        for (boolean bool : this.bools) {
            if (bool) {
                sum += 1;
            }
        }
        return (sum / this.bools.length) * 100 ;
    }
}