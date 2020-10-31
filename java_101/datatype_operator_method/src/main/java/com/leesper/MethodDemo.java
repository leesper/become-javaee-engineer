package com.leesper;

public class MethodDemo {
    public static void main(String[] args) {
        extractInteger();
        overloadOperator();
    }

    private static void extractInteger() {
        int num = 1234;
        System.out.println("Unit: " + num % 10);
        System.out.println("Decade: " + num / 10 % 10);
        System.out.println("Hundreds: " + num / 100 % 10);
        System.out.println("Kilobit: " + num / 1000 % 10);
    }

    private static void overloadOperator() {
        System.out.println("1 + 2 = " + add(1, 2));
        System.out.println("1 + 2 + 3 = " + add(1, 2, 3));
        System.out.println("3.14159 + 3.14159 = " + add(3.14159, 3.14159));
    }

    private static int add(int a, int b) {
        return a + b;
    }

    private static int add(int a, int b, int c) {
        return a + b + c;
    }

    private static double add(double a, double b) {
        return a + b;
    }
}
