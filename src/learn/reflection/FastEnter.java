package learn.reflection;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * @author sowhile
 * @version 1.0
 * <p>
 * 2022/11/24 15:05
 */
public class FastEnter {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Properties properties = new Properties();
        properties.load(Files.newInputStream(Paths.get("src/learn/reflection/rt.properties")));
        String classname = properties.get("classname").toString();
        String method = properties.get("method").toString();

        Class aClass = Class.forName(classname);
        System.out.println(aClass);
        Object o = aClass.newInstance();
        System.out.println(o);

        Method method1 = aClass.getMethod(method);
        method1.invoke(o);
    }

    @Test
    public void forceAccess() throws Exception {
        Class<?> aClass = Class.forName("learn.reflection.Cat");
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class, int.class);
        declaredConstructor.setAccessible(true);
        Object o = declaredConstructor.newInstance("cat", 18);
        System.out.println(o);

        Field age = aClass.getDeclaredField("age");
        age.setAccessible(true);
        age.set(null, 19);
        System.out.println(age.get(null));
    }

    @Test
    public void t() throws Exception {
        Class<?> aClass = Class.forName("learn.reflection.Dog");
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
            Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println(parameterType);
            }
        }
    }

    /**
     * 得到一个类对应的额Class有4种方法
     *
     * @throws Exception
     */
    @Test
    public void getClassTest() throws Exception {
        //1
        Class<?> aClass = Class.forName("learn.reflection.Cat");
        System.out.println(aClass);

        //2
        Class<Cat> catClass = Cat.class;
        System.out.println(catClass);

        //3
        Cat cat = new Cat();
        System.out.println(cat.getClass());

        //4
        ClassLoader classLoader = cat.getClass().getClassLoader();
        Class<?> aClass1 = classLoader.loadClass("learn.reflection.Cat");
        System.out.println(aClass1);

        //5
        Class<Integer> integerClass = int.class;
        Class<Short> shortClass = short.class;
        Class<Double> doubleClass = double.class;

        //6
        Class<Integer> integerClass1 = Integer.class;
        Class<Integer> type = Integer.TYPE;
        System.out.println(integerClass1);
        System.out.println(type);
    }

    /**
     * 比较不使用反射和使用反射调用方法的时间
     *
     * @throws Exception
     */
    @Test
    public void compareTime() throws Exception {
        m1();
        m2();
        m3();
    }

    public static void m1() {
        Cat cat = new Cat();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 99999999; i++) {
            cat.timeTest();
        }
        long end = System.currentTimeMillis();
        System.out.println("m1 time = " + (end - start));
    }

    public static void m2() throws Exception {
        Class aClass = Class.forName("learn.reflection.Cat");
        Object o = aClass.newInstance();
        Method timeTest = aClass.getMethod("timeTest");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 99999999; i++) {
            timeTest.invoke(o);
        }
        long end = System.currentTimeMillis();
        System.out.println("m2 time = " + (end - start));
    }

    public static void m3() throws Exception {
        Class aClass = Class.forName("learn.reflection.Cat");
        Object o = aClass.newInstance();
        Method timeTest = aClass.getMethod("timeTest");
        timeTest.setAccessible(true);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 99999999; i++) {
            timeTest.invoke(o);
        }
        long end = System.currentTimeMillis();
        System.out.println("m3 time = " + (end - start));
    }
}
