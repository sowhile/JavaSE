package com.wangda.exercise.class_.ex03;

public class test {
    public static void main(String[] args) {
        Teacher liming = new Teacher("liming", 48, 3500);
        System.out.println(liming.introduce());
        Teacher huwen = new Professor("huwen", 59, 10000);
        System.out.println(huwen.introduce());
    }
}
