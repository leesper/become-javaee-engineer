package com.javaee.vehicle2;

public class BMWCar extends Car implements GPS{
    public BMWCar(String brand, int price) {
        super(brand, price);
    }

    public void activateGPS() {
        System.out.printf("A %s car priced at %d is activating GPS\n",
                getBrand(), getPrice());
    }
}
