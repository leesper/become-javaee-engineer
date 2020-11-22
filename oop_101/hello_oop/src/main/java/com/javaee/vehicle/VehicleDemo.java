package com.javaee.vehicle;

public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle car = new Vehicle("Porsche", "Car");
        car.start();
        car.run();
    }
}
