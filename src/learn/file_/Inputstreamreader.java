package learn.file_;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author sowhile
 * @version 1.0
 * <p>
 * 2022/11/18 13:04
 */
public class Inputstreamreader {

    @Test
    public void output() throws IOException {
        File file = new File("c:\\io", "test.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "gbk"));
        bufferedWriter.write("injection额福好是");
        bufferedWriter.close();
    }

    @Test
    public void input() throws IOException {
        File file = new File("c:\\io", "test.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "gbk"));
        System.out.println(bufferedReader.readLine());
        bufferedReader.close();
    }
}
