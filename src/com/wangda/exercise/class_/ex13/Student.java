package com.wangda.exercise.class_.ex13;

public class Student extends Person {
    private String stu_id;

    public Student(String name, String sex, int age, String stu_id) {
        super(name, sex, age);
        this.stu_id = stu_id;
    }

    public void study() {
        System.out.println("我承诺，我会好好学习");

    }

    public String play() {
        return this.getName() + "爱玩足球";
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stu_id='" + stu_id + '\'' +
                '}';
    }
}
