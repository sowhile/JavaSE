package com.wangda.exercise.class_.person;

public class person_main {
    public static void main(String[] args) {
        Person[] per = new Person[3];
        per[0] = new Person("dan", 19, "job");
        per[1] = new Person("jeny", 18, "student");
        per[2] = new Person("limi", 35, "teacher");
        Person temp;
        for (int i = 0; i < per.length - 1; i++) {
            for (int j = 0; j < per.length - i - 1; j++) {
                if (per[j].getAge() > per[j + 1].getAge()) {
                    temp = per[j];
                    per[j] = per[j + 1];
                    per[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < per.length; i++) {
            System.out.println(per[i]);
        }
    }
}
