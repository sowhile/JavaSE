package com.wangda.interface_;

public class test {
    public static void main(String[] args) {
        new Outer().mt1();
    }
}

class Outer {
    private int a = 3;

    public void mt1() {
        ID i = new ID() {
            @Override
            public void play() {
                System.out.println("s");
            }
        };
    }

    public void mt2() {
    }
}

interface ID {
    void play();
}

class A{

}