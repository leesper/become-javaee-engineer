package com.javaee.vehicle2;

public class Motor extends Vehicle {
    public Motor(String brand, int price) {
        super(brand, price);
    }

    @Override
    public void run() {
        System.out.printf("A %s motorcycle priced at %d is running with 2 wheels\n",
                getBrand(), getPrice());
    }
}
