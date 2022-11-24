package learn.reflection;

/**
 * @author sowhile
 * @version 1.0
 * <p>
 * 2022/11/24 15:06
 */
public class Cat {
    public String name;
    private int age;

    public Cat() {
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void mt() {
        System.out.println("a method");
    }

    public void timeTest() {
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
}
