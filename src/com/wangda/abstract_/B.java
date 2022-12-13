package com.wangda.abstract_;

public class B extends Template {
    @Override
    public void job() {
        double sum = 0.0;
        for (double i = 0.0; i < 1000000; i++)
            sum += i;
    }
}
