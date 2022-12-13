package com.wangda.project.houserent.service;

import com.wangda.project.houserent.domain.House;

public class HouseService {
    private House[] houses;
    private int size;
    private int count = 0;

    public HouseService(int size) {
        houses = new House[size];
    }

    //扩容
    public void expand() {
        House[] newHouses = new House[houses.length + 1];
        for (int i = 0; i < houses.length; i++)
            newHouses[i] = houses[i];
        houses = newHouses;
    }

    public boolean add(House house) {
        if (houses.length <= size)
            return false;
        house.setId(++count);
        houses[size++] = house;
        return true;
    }

    public boolean delete(int id) {
        int i = 0;
        for (; i < size; i++) {
            if (houses[i].getId() == id)
                break;
        }
        if (i == size)
            return false;
        for (; i < size - 1; i++)
            houses[i] = houses[i + 1];
        size--;
        return true;
    }

    public int search(int n) {
        int i = 0;
        for (; i < size; i++) {
            if (houses[i].getId() == n) {
                System.out.println(houses[i].toString());
                break;
            }
        }
        return i;
    }

    public House[] getList() {
        return houses;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
