package com.wangda.enumeration;

/**
 * @author 王达
 * @version 1.0
 * 16:11
 */
public class test {
    public static void main(String[] args) {
        Week w = Week.MONDAY;
        Week[] ws = Week.values();
        for (Week week : ws) {
            System.out.println(week.getWeek());
        }
        new A();
    }
}

class A {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("s");
    }
}
