package com.leesper;

public class HelloJava {
    public static void main(String[] args) {
        printJava();
        printConstants();
    }

    private static void printJava() {
        System.out.println("Java is a cross-platform programming language");
        System.out.println("called \"write once, run everywhere\"");
    }

    private static void printConstants() {
        System.out.println("Constants in Java: ");
        System.out.println(123);
        System.out.println(3.14159f);
        System.out.println('L');
        System.out.println("USTC");
        System.out.println(true);
    }
}
