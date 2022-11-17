package learn.file_;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @author WangDa
 * @version 1.0
 * <p>
 * 2022/11/17 11:24
 */
public class Directory {
    @Test
    public void deleteFile() {
        File file = new File("c:\\io\\test01.txt");
        if (file.exists()) {
            if (file.delete()) System.out.println("success");
            else System.out.println("fail");
        } else {
            System.out.println("no file");
        }
    }

    @Test
    public void deleteDirectory() {
        File file = new File("c:\\io\\dir");
        if (file.exists()) {
            if (file.delete()) System.out.println("success");
            else System.out.println("fail");
        } else {
            System.out.println("no directory");
        }
    }

    @Test
    public void createDir() {
        File dir = new File("c:\\io\\a\\b\\c");
        if (!dir.exists()) {
            if (dir.mkdirs()) System.out.println("success");
        }
    }
}