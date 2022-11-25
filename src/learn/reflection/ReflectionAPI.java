package learn.reflection;

/**
 * @author sowhile
 * @version 1.0
 * <p>
 * 2022/11/24 20:28
 */
public class ReflectionAPI {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Class<?> aClass = systemClassLoader.loadClass("learn.reflection.Cat");
        System.out.println(aClass.getName());
    }
}
