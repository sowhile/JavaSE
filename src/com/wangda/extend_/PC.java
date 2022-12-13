package com.wangda.extend_;

public class PC extends Computer {
    private String Brand;

    public PC() {
    }

    public PC(String CPU, String memory, String HDD, String Brand) {
        super(CPU, memory, HDD);
        setBrand(Brand);
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getDetails() {
        return super.getDetails() + this.getBrand();
    }

    public String m1() {
        return null;
    }
}
