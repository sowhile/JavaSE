package com.wangda.synchronized_;

/**
 * @author WangDa
 * @version 1.0
 * <p>
 * 2022/11/15 19:52
 */
public class DeadLock {
    public static void main(String[] args) {
        Test t1 = new Test(true);
        Test t2 = new Test(false);
        Thread a = new Thread(t1);
        Thread b = new Thread(t2);
        a.setName("a");
        b.setName("b");
        a.start();
        b.start();
    }
}

class Test implements Runnable {

    static Object o1 = new Object();
    static Object o2 = new Object();
    public boolean bool;

    public Test(boolean bool) {
        this.bool = bool;
    }

    @Override
    public void run() {
        if (bool) {
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() + "-1");
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + "-2");
                }
            }
        } else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + "-3");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + "-4");
                }
            }
        }
    }
}