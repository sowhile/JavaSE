package com.wangda.project.houserent.domain;

/**
 * @author wangda
 * @version 1.0
 * House类的每个对象代表一个房屋
 */
public class House {
    private int id;
    private String name;
    private String phone;
    private String address;
    private double rent;
    private String state;

    public House() {
    }

    public House(int id, String name, String phone, String address, double rent, String state) {
        setId(id);
        setName(name);
        setPhone(phone);
        setAddress(address);
        setRent(rent);
        setState(state);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return id + "\t\t" + name + "\t" + phone + "\t\t" + address + "\t" + rent + "\t\t" + state;
    }
}
