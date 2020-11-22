package com.javaee.phone;

public class PhoneDemo {
    public static void main(String[] args) {
        Phone nokia = new Phone("Nokia", 3000.00);
        SmartPhone apple = new SmartPhone("Apple", 8000.00);

        nokia.makeCall();
        nokia.sendMessage();
        nokia.displayCaller();

        apple.makeCall();
        apple.sendMessage();
        apple.displayCaller();
    }
}
