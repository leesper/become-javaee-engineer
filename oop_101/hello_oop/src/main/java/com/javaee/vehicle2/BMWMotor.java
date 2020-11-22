package com.javaee.vehicle2;

public class BMWMotor extends Motor implements GPS {
    public BMWMotor(String brand, int price) {
        super(brand, price);
    }

    public void activateGPS() {
        System.out.printf("A %s motor priced at %d is activating GPS\n",
                getBrand(), getPrice());
    }
}
