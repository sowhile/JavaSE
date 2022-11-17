package learn.file_;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @author WangDa
 * @version 1.0
 * <p>
 * 2022/11/17 11:07
 */
public class FileInformation {
    @Test
    public void test() {
        File file = new File("c:\\io\\test02\\");
        System.out.println(file.getName());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getPath());
        System.out.println(file.length());
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
    }
}
