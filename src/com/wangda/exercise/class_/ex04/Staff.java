package com.wangda.exercise.class_.ex04;

public class Staff {
    private String name;
    private int salary;
    private int days;

    public Staff(String name, int salary, int days) {
        this.name = name;
        this.salary = salary;
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void printSalary() {
        System.out.println("员工总工资 " + this.days * this.salary);
    }
}
