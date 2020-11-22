package com.javaee.phone;

public class SmartPhone extends Phone {
    public SmartPhone() {}

    public SmartPhone(String brand, double price) {
        super(brand, price);
    }

    @Override
    public void displayCaller() {
        System.out.println(getBrand() + " display caller's phone number, head and location");
    }
}
