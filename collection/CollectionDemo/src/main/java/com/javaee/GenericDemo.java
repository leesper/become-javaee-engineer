package com.javaee;

import java.util.ArrayList;

public class GenericDemo {
    public static abstract class Person {}

    public static class Student extends Person {}

    public static class JavaStudent extends Student {}

    public static class UIStudent extends Student {}

    public static class Teacher extends Person {}

    public static class JavaTeacher extends Teacher {}

    public static class UITeacher extends Teacher {}

    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<Person> list2 = new ArrayList<>();
        ArrayList<Student> list3 = new ArrayList<>();
        ArrayList<JavaStudent> list4 = new ArrayList<>();
        ArrayList<UIStudent> list5 = new ArrayList<>();
        ArrayList<Teacher> list6 = new ArrayList<>();
        ArrayList<JavaTeacher> list7 = new ArrayList<>();
        ArrayList<UITeacher> list8 = new ArrayList<>();

        print1(list1);
        print1(list2);
        print1(list3);
        print1(list4);
        print1(list5);
        print1(list6);
        print1(list7);
        print1(list8);

        print2(list2);
        print2(list3);
        print2(list4);
        print2(list5);
        print2(list6);
        print2(list7);
        print2(list8);

        print3(list3);
        print3(list4);
        print3(list5);

        print4(list2);
        print4(list3);
        print4(list4);
    }

    //要求：参数可以接收任何泛型的ArrayList参数
    public static void print1(ArrayList list){}

    //要求：参数可以接收任何Person及其子类泛型的ArrayList参数
    public static void print2(ArrayList<? extends Person> list){}

    //要求：参数可以接收任何Student及其子类泛型的ArrayList参数
    public static void print3(ArrayList<? extends Student> list){}

    //要求：参数可以接收任何Java学员，及其父类泛型的ArrayList参数
    public static void print4(ArrayList<? super JavaStudent> list){}
}
