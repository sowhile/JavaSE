package com.wangda.exercise.class_.ex03;

public class Professor extends Teacher {
    public Professor(String name, int age, int salary) {
        super(name, age, salary);
        super.setPost("教授");
        super.setSalary(1.3);
    }

    @Override
    public String introduce() {
        return super.getPost() + " " + super.introduce();
    }
}
