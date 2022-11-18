package learn.file_;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * @author sowhile
 * @version 1.0
 * <p>
 * 2022/11/18 21:06
 */
public class properties_ {
    @Test
    public void read() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("c:\\io\\test.properties"));
        System.out.println(properties.getProperty("ip"));
        properties.list(System.out);
    }

    @Test
    public void write() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("c:\\io\\test.properties"));
        properties.setProperty("name", "qwqw");
        properties.store(new FileWriter("c:\\io\\test.properties"), "hello");
    }
}
