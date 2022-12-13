package com.wangda.exercise.class_.ex04;

public class test {
    public static void main(String[] args) {
        Staff com = new CommonStaff("xiaowang", 100, 30);
        Staff jingli = new Manager("zhangzong", 300, 30);
        com.printSalary();
        jingli.printSalary();
    }
}
