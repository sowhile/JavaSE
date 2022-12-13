package com.wangda.synchronized_;

import java.util.Scanner;

/**
 * @author WangDa
 * @version 1.0
 * <p>
 * 2022/11/15 20:04
 */
public class exercise01 {
    public static void main(String[] args) {
        B b = new B(new A());
        Thread threadA = new Thread(b.a);
        Thread threadB = new Thread(b);
        threadA.start();
        threadB.start();
    }
}

class A implements Runnable {
    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            try {
                printNum();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("A线程退出.");
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    private void printNum() throws InterruptedException {
        System.out.println((int) (Math.random() * 100) + 1);
        Thread.sleep(1000);
    }
}

class B implements Runnable {
    A a;
    private boolean loop2 = true;
    Scanner scanner = new Scanner(System.in);

    public B(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        while (loop2) {
            scex();
        }
        System.out.println("B线程退出.");
    }

    private void scex() {
        System.out.print("请输入Q表示退出：");
        if (scanner.next().toUpperCase().charAt(0) == 'Q') {
            a.setLoop(false);
            loop2 = false;
        }
    }
}