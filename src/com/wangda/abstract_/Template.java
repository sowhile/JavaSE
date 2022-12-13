package com.wangda.abstract_;

abstract public class Template {
    public abstract void job();

    public void runTime() {
        long start = System.currentTimeMillis();
        job();
        long end = System.currentTimeMillis();
        System.out.println("执行时间：" + (end - start));
    }
}
