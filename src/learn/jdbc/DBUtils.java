package learn.jdbc;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.List;

/**
 * @author sowhile
 * @version 1.0
 * <p>
 * 2022/11/30 15:00
 */
public class DBUtils {
    //查询多条记录，会封装到一个List中
    @Test
    public void testQueryMany() throws Exception {
        //通过Druid工具类得到连接
        Connection connection = JDBCDruidUtils.getConnection();

        QueryRunner queryRunner = new QueryRunner();
        String sql = "SELECT * FROM login";

        /**
         * query()方法就是执行SQL语句，将resultSet封装到ArrayList中，然后返回该集合
         * connection 连接
         * sql 要执行的SQL语句
         * new BeanListHandler<>(Login.class) 底层用反射机制获取Login类的属性，然后进行封装
         * 后面给SQL语句的?赋值，可以有多个值，是可变形参
         * 底层会将resultSet和prepareStatement关闭
         */
        List<Login> query = queryRunner.query(connection, sql, new BeanListHandler<>(Login.class));
        for (Login login : query) {
            System.out.println(login);
        }
        JDBCDruidUtils.close(null, null, connection);
    }

    //查询单行记录，会封装到Login对象中
    @Test
    public void testQuerySingle() throws Exception {
        //通过Druid工具类得到连接
        Connection connection = JDBCDruidUtils.getConnection();

        QueryRunner queryRunner = new QueryRunner();
        String sql = "SELECT * FROM login WHERE user = ?";
        Login wd = queryRunner.query(connection, sql, new BeanHandler<>(Login.class), "wd");
        System.out.println(wd);
        JDBCDruidUtils.close(null, null, connection);
    }

    //查询单行单列的值，会封装到Object中
    @Test
    public void testQueryScalar() throws Exception {
        //通过Druid工具类得到连接
        Connection connection = JDBCDruidUtils.getConnection();

        QueryRunner queryRunner = new QueryRunner();
        String sql = "SELECT password FROM login WHERE user = ?";
        Object wd = queryRunner.query(connection, sql, new ScalarHandler(), "wd");
        System.out.println(wd);

        JDBCDruidUtils.close(null, null, connection);
    }

    //Apache DBUtils 完成DML
    @Test
    public void testDML() throws Exception {
        //通过Druid工具类得到连接
        Connection connection = JDBCDruidUtils.getConnection();

        QueryRunner queryRunner = new QueryRunner();
        String sql = "INSERT INTO login VALUES(?, ?)";
        int rows = queryRunner.update(connection, sql, "apache", "666");
        System.out.println(rows != 0 ? "success" : "fail");

        JDBCDruidUtils.close(null, null, connection);
    }
}
