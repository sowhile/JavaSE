package com.wangda.abstract_;

public class A extends Template {
    @Override
    public void job() {
        long sum = 0;
        for (long i = 0; i < 1000000; i++)
            sum += i;
    }
}
