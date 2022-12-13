package com.wangda.bind;

public class A {
    public int i = 20;
     protected int a = 80;

    public int sum() {
        return getI() + 10;
    }

    public int getI() {
        return this.i;
    }
}
