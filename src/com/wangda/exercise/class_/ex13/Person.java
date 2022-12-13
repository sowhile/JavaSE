package com.wangda.exercise.class_.ex13;

public class Person {
    private String name;
    private String sex;
    private int age;

    public Person(String name, String sex, int age) {
        setName(name);
        setSex(sex);
        setAge(age);
    }

    public String play() {
        return null;
    }

//    public void study() {
//    }
//
//    public void teach() {
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
