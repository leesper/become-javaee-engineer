package com.javaee;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class StudentDemo {
    public static class Student {
        private String name;
        private String sex;
        private int age;

        public Student(String name, String sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return age == student.age &&
                    Objects.equals(this.name, student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public String toString() {
            return String.format("%s+%s+%d", name, sex, age);
        }
    }

    public static void main(String[] args) {
        Student a = new Student("ZS", "MALE", 20);
        Student b = new Student("LS", "FEMALE", 21);
        Student c = new Student("ZS", "MALE", 20);

        Set<Student> students = new HashSet<>();
        students.add(a);
        students.add(b);
        students.add(c);

        for (Student s : students) {
            System.out.println(s);
        }
    }
}
