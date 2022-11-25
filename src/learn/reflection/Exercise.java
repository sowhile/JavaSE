package learn.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author sowhile
 * @version 1.0
 * <p>
 * 2022/11/25 13:14
 */
public class Exercise {
    @Test
    public void ex01() throws Exception {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Class<?> aClass = systemClassLoader.loadClass("learn.reflection.PrivateTest");
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        Object o = aClass.newInstance();
        name.set(o, "123");

        Method getName = aClass.getMethod("getName");
        System.out.println(getName.invoke(o));
    }

    @Test
    public void ex02() throws Exception {
        Class<?> aClass = Class.forName("java.io.File");
        Constructor[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        Constructor<?> constructor = aClass.getConstructor(String.class);
        Object o = constructor.newInstance("c:\\io\\ex02.txt");
        Method createNewFile = aClass.getMethod("createNewFile");
        createNewFile.invoke(o);
    }
}

class PrivateTest {
    private String name = "hello,kitty";

    public String getName() {
        return name;
    }
}
