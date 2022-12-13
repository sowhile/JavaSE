package com.wangda.enumeration;

/**
 * @author 王达
 * @version 1.0
 * 16:48
 */
public enum Week {
    MONDAY("星期一"), TUESDAY("星期二"), WEDNESDAY("星期三");
    private final String week;

    Week(String w) {
        this.week = w;
    }

    public String getWeek() {
        return week;
    }
}
