package learn.file_;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author WangDa
 * @version 1.0
 * <p>
 * 2022/11/17 12:50
 */
public class FileInputStream_ {
    @Test
    public void create() {
        File file = new File("c:\\io\\test1.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("success");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void input() {
        File file = new File("c:\\io\\test1.txt");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            int a;
            while ((a = fileInputStream.read()) != -1) {
                System.out.print((char) a);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void input2() {
        File file = new File("c:\\io\\test1.txt");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            byte[] a = new byte[8];
            int strlen;
            while ((strlen = fileInputStream.read(a)) != -1) {
                System.out.print(new String(a, 0, strlen));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
