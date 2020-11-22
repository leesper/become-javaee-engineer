package com.javaee.vehicle;

public class Vehicle {
    private String brand;
    private String type;

    public Vehicle() {}

    public Vehicle(String brand, String type) {
        this.brand = brand;
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void start() {
        System.out.printf("%s %s is starting\n", brand, type);
    }

    public void run() {
        System.out.printf("%s %s is running on the highway\n", brand, type);
    }
}
