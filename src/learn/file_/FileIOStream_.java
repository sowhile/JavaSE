package learn.file_;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author WangDa
 * @version 1.0
 * <p>
 * 2022/11/17 12:50
 */
public class FileIOStream_ {
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
            int strLen;
            while ((strLen = fileInputStream.read(a)) != -1) {
                System.out.print(new String(a, 0, strLen));
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
    public void output() {
        File file = new File("c:\\io\\test1");
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            byte[] b = "你好.".getBytes(StandardCharsets.UTF_8);
            fileOutputStream.write(b);
            System.out.println("success");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Test
    public void output2() {
        File file = new File("c:\\io\\test1");
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file, true);
            for (int i = 0; ; i++) {
                fileOutputStream.write('A');
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Test
    public void copy() {
        File fileFrom = new File("c:\\io", "software.zip");
        File fireTo = new File("c:\\io", "test.zip");
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(fileFrom);
            fileOutputStream = new FileOutputStream(fireTo);
            byte[] buf = new byte[4096];
            int readLen;
            long start, end;
            start = System.currentTimeMillis();
            while ((readLen = fileInputStream.read(buf)) != -1) {
                fileOutputStream.write(buf, 0, readLen);
            }
            end = System.currentTimeMillis();
            System.out.println("time=" + (end - start) / 1000.0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fileInputStream != null) fileInputStream.close();
                if (fileOutputStream != null) fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void buffCopy() throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("c:\\io\\software.zip"));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("c:\\io\\test.zip"));
        int readLen = 0;
        byte[] bytes = new byte[2048];
        while ((readLen = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, readLen);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
}
