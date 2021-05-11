package com.we.Array;

public class Student {
    private String name;
    private int age;

    public Student(String studentName, int studentAge) {
        name = studentName;
        age = studentAge;
    }

    @Override
    public String toString() {
        return String.format("Student: name= %s, age = %d", name, age);
    }
}
