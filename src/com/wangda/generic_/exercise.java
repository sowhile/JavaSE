package com.wangda.generic_;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author WangDa
 * @version 1.0
 * <p>
 * 2022/11/14 21:00
 */

public class exercise {

    @Test
    public void m1() {
        DAO<User> userDAO = new DAO<>();
        userDAO.save("002", new User(2, "wd"));
        userDAO.save("001", new User(1, "xm"));
        userDAO.save("003", new User(3, "ab"));
        for (User next : userDAO.list())
            System.out.println(next);
    }
}

class DAO<T> {
    private final HashMap<String, T> hashMap = new HashMap<>();

    public void save(String id, T entity) {
        hashMap.put(id, entity);
    }

    public T get(String id) {
        return hashMap.get(id);
    }

    public void update(String id, T entity) {
        hashMap.put(id, entity);
    }

    public List<T> list() {
        return new ArrayList<>(hashMap.values());
    }

    public void delete(String id) {
        hashMap.remove(id);
    }
}

class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}