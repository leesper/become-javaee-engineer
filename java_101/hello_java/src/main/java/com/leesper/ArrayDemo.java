package com.leesper;

public class ArrayDemo {
    public static void main(String[] args) {
        double[] doubles = {12.9, 53.54, 75.0, 99.1, 3.14};
        double min = Double.MAX_VALUE;
        for (int i = 0; i < doubles.length; i++) {
            if (doubles[i] < min) {
                min = doubles[i];
            }
        }
        System.out.println("Minimal value: " + min);
    }
}
