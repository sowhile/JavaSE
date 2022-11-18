package learn.file_.objectoutput;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author sowhile
 * @version 1.0
 * <p>
 * 2022/11/18 10:10
 */
public class Dog implements Serializable {
    private String name;
    private int age;
    private final static long serialVersionUID = 123456789L;
    private String nation;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
