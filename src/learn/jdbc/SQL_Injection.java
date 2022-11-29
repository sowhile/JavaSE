package learn.jdbc;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author sowhile
 * @version 1.0
 * <p>
 * 2022/11/29 17:30
 */
public class SQL_Injection {
    public static void main(String[] args) throws Exception {
    }

    /**
     * 演示SQL注入
     *
     * @throws Exception
     */
    public static void met1() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileReader("src/learn/jdbc/jdbc.properties"));
        Class.forName(properties.getProperty("driver"));

        Connection connection = DriverManager.getConnection(properties.getProperty("url"),
                properties.getProperty("user"), properties.getProperty("password"));

        String user, passwd;
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名:");//1' OR
        user = scanner.nextLine();
        System.out.print("请输入密码:");//OR '1'='1
        passwd = scanner.nextLine();

        String sql = "SELECT * FROM login WHERE user = '" + user + "'AND password = '" + passwd + "'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println(resultSet.next() ? "success" : "fail");

        resultSet.close();
        statement.close();
        connection.close();
    }

    /**
     * 演示预防SQL注入
     *
     * @throws Exception
     */
    public static void met2() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileReader("src/learn/jdbc/jdbc.properties"));
        Class.forName(properties.getProperty("driver"));

        Connection connection = DriverManager.getConnection(properties.getProperty("url"),
                properties.getProperty("user"), properties.getProperty("password"));


        String user, passwd;
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名:");
        user = scanner.nextLine();
        System.out.print("请输入密码:");
        passwd = scanner.nextLine();
        String sql = "SELECT * FROM login WHERE user = ? AND password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user);
        preparedStatement.setString(2, passwd);
        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println(resultSet.next() ? "success" : "fail");

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
