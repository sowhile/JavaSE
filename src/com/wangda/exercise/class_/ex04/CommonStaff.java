package com.wangda.exercise.class_.ex04;

public class CommonStaff extends Staff {
    private double factor = 1.0;

    public CommonStaff(String name, int salary, int days) {
        super(name, salary, days);
    }

    public double getFactor() {
        return factor;
    }

    public void setFactor(double factor) {
        this.factor = factor;
    }

    @Override
    public void printSalary() {
        System.out.println("普通员工总工资 " + super.getDays() * super.getSalary() * this.factor);
    }
}
