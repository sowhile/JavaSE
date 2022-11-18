package learn.file_;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

/**
 * @author sowhile
 * @version 1.0
 * <p>
 * 2022/11/18 22:39
 */
public class exercise {

    @Test
    public void ex01() throws IOException {
        File file = new File("c:\\io\\myfile");
        if (!file.isDirectory()) if (file.mkdir()) System.out.println("success create directory");
        File file1 = new File(file, "hello.txt");
        if (file1.exists()) System.out.println("exists");
        else if (file1.createNewFile()) System.out.println("success create file");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file1, true));
        bufferedWriter.write("hello,world!");
        bufferedWriter.close();
    }

    @Test
    public void ex02() throws IOException {
        File file = new File("c:\\io\\test.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), "gbk");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str = "";
        int line = 1;
        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(line++ + ":" + str);
        }
        bufferedReader.close();
    }

    @Test
    public void ex03() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileReader("src/learn/file_/dog.properties"));
        Dog dog = new Dog(properties.getProperty("name"), Integer.parseInt(properties.getProperty("age")), properties.getProperty("color"));
        System.out.println(dog);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("c:\\io\\dog.dat"));
        objectOutputStream.writeObject(dog);
        objectOutputStream.close();
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("c:\\io\\dog.dat"));
        Dog dog1 = (Dog) objectInputStream.readObject();
        System.out.println(dog1);
    }

    /**
     * crazy!
     */
    @Test
    public void test() throws IOException {
        File file = new File("c:\\io\\test.dat");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        char[] chars = new char[Integer.MAX_VALUE / 100];
        for (char c : chars)
            c = 'A';
        for (int i = 0; i < 99999999; i++)
            bufferedWriter.write(chars);
        bufferedWriter.close();
    }
}

class Dog implements Serializable {
    private String name;
    private int age;
    private String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" + "name='" + name + '\'' + ", age=" + age + ", color='" + color + '\'' + '}';
    }
}