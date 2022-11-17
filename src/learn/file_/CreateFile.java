package learn.file_;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author WangDa
 * @version 1.0
 * <p>
 * 2022/11/17 10:56
 */
public class CreateFile {
    @Test
    public void create01() {
        File file = new File("c:\\io\\test01.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void create02() {
        File parentFile = new File("c:\\io");
        File file = new File(parentFile, "test02.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void create03() {
        File file = new File("c:\\io", "test03.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
