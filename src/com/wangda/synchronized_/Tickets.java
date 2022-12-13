package com.wangda.synchronized_;

/**
 * @author WangDa
 * @version 1.0
 * <p>
 * 2022/11/14 21:43
 */
public class Tickets {
    public static void main(String[] args) throws InterruptedException {
        SellSystem sellSystem = new SellSystem(50);
        Thread thread1 = new Thread(sellSystem);
        Thread thread2 = new Thread(sellSystem);
        Thread thread3 = new Thread(sellSystem);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class SellSystem implements Runnable {

    private int ticketNum;
    private boolean loop = true;

    public SellSystem(int ticketNum) {
        this.ticketNum = ticketNum;
    }

    @Override
    public void run() {
        while (loop) {
            sell();
        }
    }

    public void sell() {
        synchronized (this) {
            if (ticketNum <= 0) {
                System.out.println("售票结束.");
                loop = false;
                return;
            }
            System.out.println(Thread.currentThread().getName() + " 卖出1张，还剩 " + --ticketNum + " 张.");

            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}