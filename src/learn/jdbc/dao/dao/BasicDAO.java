package learn.jdbc.dao.dao;

import learn.jdbc.dao.utils.JDBCDruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author sowhile
 * @version 1.0
 * <p>
 * 2022/11/30 17:06
 */
public class BasicDAO<T> {
    //Apache
    private QueryRunner qr = new QueryRunner();

    //DML language
    public int update(String sql, Object... parameters) {
        Connection connection = JDBCDruidUtils.getConnection();
        try {
            return qr.update(connection, sql, parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCDruidUtils.close(null, null, connection);
        }
    }

    /**
     * @param sql        SQL语句
     * @param clazz      传入一个类的Class对象
     * @param parameters ?的具体的值
     * @return 根据clazz返回对应的额ArrayList集合
     */
    public List<T> queryMulti(String sql, Class<T> clazz, Object... parameters) {
        Connection connection = JDBCDruidUtils.getConnection();
        try {
            return qr.query(connection, sql, new BeanListHandler<T>(clazz), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCDruidUtils.close(null, null, connection);
        }
    }

    //单条记录
    public T querySingle(String sql, Class<T> clazz, Object... parameters) {
        Connection connection = JDBCDruidUtils.getConnection();
        try {
            return qr.query(connection, sql, new BeanHandler<>(clazz), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCDruidUtils.close(null, null, connection);
        }
    }

    //单值
    public Object queryScalar(String sql, Object... parameters) {
        Connection connection = JDBCDruidUtils.getConnection();
        try {
            return qr.query(connection, sql, new ScalarHandler(), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCDruidUtils.close(null, null, connection);
        }
    }
}
