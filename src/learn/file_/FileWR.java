package learn.file_;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author sowhile
 * @version 1.0
 * <p>
 * 2022/11/17 15:36
 */
public class FileWR {

    @Test
    public void read() {
        File file = new File("c:\\io", "a.txt");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            int readLen = 0;
            char[] chars = new char[8];
            while ((readLen = fileReader.read(chars)) != -1) {
                System.out.print(new String(chars, 0, readLen));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * FileWriter写入后必须 close()或 flush()，否则没有进行写入
     */
    @Test
    public void write() {
        File file = new File("c:\\io", "ab.txt");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            String str = "风雨之后，定见彩虹";
            fileWriter.write(str.toCharArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Test
    public void bufWrite() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("c:\\io\\test"));
        bufferedWriter.newLine();
        bufferedWriter.write("hello,world!");
        bufferedWriter.close();
    }

    @Test
    public void bufRead() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("c:\\io\\test"));
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str);
        }
        bufferedReader.close();
    }
}
