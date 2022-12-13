package com.wangda.synchronized_;

/**
 * @author WangDa
 * @version 1.0
 * <p>
 * 2022/11/15 20:33
 */
public class exercise02 {
    public static void main(String[] args) {
        Get get = new Get();
        Thread thread1 = new Thread(get);
        Thread thread2 = new Thread(get);
        thread1.setName("A");
        thread2.setName("B");
        thread1.start();
        thread2.start();
    }
}

class Get implements Runnable {

    private int money = 10000;
    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            getMoney();
        }
    }

    private void getMoney() {
        synchronized (this) {
            if (money < 1000) {
                loop = false;
                return;
            }
            System.out.println(Thread.currentThread().getName() + "用户取走了1000，还剩" + (money -= 1000) + "元.");
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}