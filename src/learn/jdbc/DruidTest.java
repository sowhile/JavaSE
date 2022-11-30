package learn.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author sowhile
 * @version 1.0
 * <p>
 * 2022/11/30 11:17
 */
public class DruidTest {
    @Test
    public void met1() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileReader("src/learn/jdbc/druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            Connection connection = dataSource.getConnection();
//            System.out.println("success");
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
