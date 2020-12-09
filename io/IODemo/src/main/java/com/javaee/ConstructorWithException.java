package com.javaee;

public class ConstructorWithException {
    public static class WeightOutOfBoundsException extends Exception {
        public WeightOutOfBoundsException() {}
        public WeightOutOfBoundsException(String message) {
            super(message);
        }
    }

    public static class Person {
        private int weight;
        public Person(int weight) throws WeightOutOfBoundsException {
            if (weight < 0 || weight > 300) {
                throw new WeightOutOfBoundsException("体重不符合要求");
            }
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        try {
            Person person = new Person(70);
        } catch (WeightOutOfBoundsException ex) {
            System.out.println(ex);
        }
    }
}
