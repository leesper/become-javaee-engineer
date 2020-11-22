package com.javaee.vehicle2;

public class Car extends Vehicle {
    public Car(String brand, int price) {
        super(brand, price);
    }

    public void run() {
        System.out.printf("A %s car priced at %d is running with 4 wheels\n",
                getBrand(), getPrice());
    }
}
