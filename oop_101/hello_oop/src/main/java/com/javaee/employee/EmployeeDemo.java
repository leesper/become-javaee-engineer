package com.javaee.employee;

public class EmployeeDemo {
    public static void main(String[] args) {
        Employee zs = new JavaTeacher("ZhangSan", "Male", 38);
        Employee ls = new UITeacher("LiSi", "Female", 28);

        zs.work();
        ls.work();
        ((UITeacher)ls).draw();
    }
}
