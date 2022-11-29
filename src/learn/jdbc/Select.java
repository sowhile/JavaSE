package learn.jdbc;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author sowhile
 * @version 1.0
 * <p>
 * 2022/11/29 15:27
 */
public class Select {
    @Test
    public void met1() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileReader("src/learn/jdbc/jdbc.properties"));
        Class.forName(properties.getProperty("driver"));

        Connection connection = DriverManager.getConnection(properties.getProperty("url"),
                properties.getProperty("user"), properties.getProperty("password"));

        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM news";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int anInt = resultSet.getInt(1);
            String string = resultSet.getString(2);
            System.out.println(anInt + " " + string);
        }

        resultSet.close();
        statement.close();
        connection.close();
    }

}
