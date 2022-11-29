package learn.jdbc;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author sowhile
 * @version 1.0
 * <p>
 * 2022/11/29 22:28
 */
public class JDBCUtils {
    public static String user;
    public static String password;
    public static String driver;
    public static String url;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/learn/jdbc/jdbc.properties"));
        } catch (IOException e) {
            //这里将IO编译时异常转成运行时异常抛出去
            throw new RuntimeException(e);
        }
        user = properties.getProperty("user");
        password = properties.getProperty("password");
        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
    }

    public static Connection getConnection() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null)
                resultSet.close();
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
