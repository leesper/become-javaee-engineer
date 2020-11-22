package com.javaee.employee;

public class UITeacher extends Employee implements Draw {
    public UITeacher(String name, String sex, int age) {
        super(name, sex, age);
    }

    public void draw() {
        System.out.printf("name %s, sex %s, age %d is teaching every body how to draw\n",
                getName(), getSex(), getAge());
    }

    public void work() {
        System.out.printf("name %s, sex %s, age %d is teaching the workflow of product design\n",
                getName(), getSex(), getAge());
    }
}
