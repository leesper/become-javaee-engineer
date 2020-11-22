package com.javaee.vehicle2;

public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle benz = new BenzCar("Benz", 500000);
        Vehicle bmw = new BMWCar("BMW", 800000);
        Vehicle yamaha = new YamahaMotor("YAMAHA", 50000);
        Vehicle bmw2 = new BMWMotor("BMW", 80000);

        benz.run();
        bmw.run();
        ((GPS) bmw).activateGPS();
        yamaha.run();
        bmw2.run();
        ((GPS) bmw2).activateGPS();
    }
}
