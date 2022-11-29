package learn.jdbc;

import com.mysql.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author sowhile
 * @version 1.0
 * <p>
 * 2022/11/29 14:22
 */
public class FastEnter {
    @Test
    public void meth1() throws Exception {
        //1.创建Driver对象
        Driver driver = new Driver();
        //2.得到连接
        String url = "jdbc:mysql://localhost:3306/practice";
        Properties properties = new Properties();
        properties.load(Files.newInputStream(Paths.get("src/learn/jdbc/jdbc.properties")));

        Connection connect = driver.connect(url, properties);
        //3.执行SQL
        Statement statement = connect.createStatement();
        String sql = "insert into test values (null, 'wd')";
        int rows = statement.executeUpdate(sql);
        System.out.println(rows > 0 ? "success" : "fail");
        //4.关闭连接
        statement.close();
        connect.close();
    }

    @Test
    public void meth2() throws Exception {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        String url = "jdbc:mysql://localhost:3306/practice";
        Properties properties = new Properties();
        properties.load(Files.newInputStream(Paths.get("src/learn/jdbc/jdbc.properties")));

        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
        connect.close();
    }

    @Test
    public void meth3() throws Exception {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        String url = "jdbc:mysql://localhost:3306/practice";
        Properties properties = new Properties();
        properties.load(Files.newInputStream(Paths.get("src/learn/jdbc/jdbc.properties")));

        //注册driver
        DriverManager.registerDriver(driver);

        Connection connection = DriverManager.getConnection(url, properties);
        System.out.println(connection);
        connection.close();
    }

    @Test
    public void meth4() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/practice";
        Properties properties = new Properties();
        properties.load(Files.newInputStream(Paths.get("src/learn/jdbc/jdbc.properties")));

        Connection connection = DriverManager.getConnection(url, properties);
        System.out.println(connection);
        connection.close();
    }

    @Test
    public void meth5() throws Exception {
        Properties properties = new Properties();
        properties.load(Files.newInputStream(Paths.get("src/learn/jdbc/jdbc.properties")));

        Class.forName(properties.getProperty("driver"));

        Connection connection = DriverManager.getConnection(properties.getProperty("url"),
                properties.getProperty("user"), properties.getProperty("password"));
        System.out.println(connection);
        connection.close();
    }
}
