package learn.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author sowhile
 * @version 1.0
 * <p>
 * 2022/11/30 10:39
 */
public class C3P0 {
    @Test
    public void met1() throws Exception {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        Properties properties = new Properties();
        properties.load(new FileReader("src/learn/jdbc/jdbc.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        //初始连接数
        comboPooledDataSource.setInitialPoolSize(10);
        //最大连接数
        comboPooledDataSource.setMaxPoolSize(50);
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println("success");
        connection.close();
    }

    @Test
    public void met2() throws Exception {
        ComboPooledDataSource hello = new ComboPooledDataSource("hello");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            Connection connection = hello.getConnection();
//            System.out.println("success");
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
