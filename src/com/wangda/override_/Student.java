package com.wangda.override_;

public class Student extends Person {
    private int ID;
    private int score;

    public Student() {
    }

    public Student(String name, int age, int ID, int score) {
        super(name, age);
        this.ID = ID;
        this.score = score;
    }

    public String say() {
        return super.say() + " " + this.ID + " " + this.score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", score=" + score +
                '}';
    }
}