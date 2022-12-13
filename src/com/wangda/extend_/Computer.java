package com.wangda.extend_;

public class Computer {
    private String CPU;
    private String memory;
    private String HDD;

    public Computer() {
    }

    public Computer(String CPU, String memory, String HDD) {
        setCPU(CPU);
        setMemory(memory);
        setHDD(HDD);
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getHDD() {
        return HDD;
    }

    public void setHDD(String HDD) {
        this.HDD = HDD;
    }

    public String getDetails() {
        return this.CPU + " " + this.memory + " " + this.HDD;
    }

    public Object m1() {
        return null;
    }
}
