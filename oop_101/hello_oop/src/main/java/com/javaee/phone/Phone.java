package com.javaee.phone;

public class Phone {
    private String brand;
    private double price;

    public Phone() {}

    public Phone(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void makeCall() {
        System.out.println(brand + " make a phone call");
    }

    public void sendMessage() {
        System.out.println(brand + " send a message");
    }

    public void displayCaller() {
        System.out.println(brand + " display caller's phone number");
    }
}
