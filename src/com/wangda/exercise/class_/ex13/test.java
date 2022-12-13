package com.wangda.exercise.class_.ex13;

public class test {
    public static void main(String[] args) {
        Person[] persons = new Person[4];
        persons[0] = new Student("小明", "男", 16, "3294435");
        persons[3] = new Teacher("李想", "男", 58, 38);
        persons[1] = new Student("小红", "女", 19, "3294434");
        persons[2] = new Teacher("李明", "女", 46, 18);

        Person temp;
        for (int i = 0; i < persons.length - 1; i++) {
            for (int j = 0; j < persons.length - i - 1; j++) {
                if (persons[j].getAge() > persons[j + 1].getAge()) {
                    temp = persons[j];
                    persons[j] = persons[j + 1];
                    persons[j + 1] = temp;
                }
            }
        }
        new test().run(persons[0]);
        new test().run(persons[2]);
    }

    public void run(Person p) {
        if (p instanceof Student)
            ((Student) p).study();
        else if (p instanceof Teacher)
            ((Teacher) p).teach();
    }
}
