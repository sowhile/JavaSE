package com.wangda.extend_;

public class NotePad extends Computer {
    private String color;

    public NotePad() {
    }

    public NotePad(String CPU, String memory, String HDD, String color) {
        super(CPU, memory, HDD);
        setColor(color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
