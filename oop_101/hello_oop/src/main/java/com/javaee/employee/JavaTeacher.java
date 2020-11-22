package com.javaee.employee;

public class JavaTeacher extends Employee {
    public JavaTeacher(String name, String sex, int age) {
        super(name, sex, age);
    }

    public void work() {
        System.out.printf("name %s, sex %s, age %d is teaching Object-Oriented Programming\n",
                getName(), getSex(), getAge());
    }
}
