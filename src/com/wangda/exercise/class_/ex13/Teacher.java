package com.wangda.exercise.class_.ex13;

public class Teacher extends Person {
    private int work_age;

    public Teacher(String name, String sex, int age, int work_age) {
        super(name, sex, age);
        this.work_age = work_age;
    }

    public void teach() {
        System.out.println("我承诺，我会认真教学");

    }

    public String play() {
        return this.getName() + "爱玩象棋";
    }

    public int getWork_age() {
        return work_age;
    }

    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "work_age=" + work_age +
                '}';
    }
}
