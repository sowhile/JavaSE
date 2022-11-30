package learn.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author sowhile
 * @version 1.0
 * <p>
 * 2022/11/29 23:41
 */
public class Batch {
    @Test
    public void traditionalMethod() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        String sql = "INSERT INTO admin VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setInt(1, i);
            preparedStatement.setString(2, "lala" + i);
            preparedStatement.setString(3, "666");
            preparedStatement.executeUpdate();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);//19054
        JDBCUtils.close(null, preparedStatement, connection);
    }

    @Test
    public void batchMethod() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        String sql = "INSERT INTO admin VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setInt(1, i);
            preparedStatement.setString(2, "lala" + i);
            preparedStatement.setString(3, "666");
            //将SQL语句加入批处理包中
            preparedStatement.addBatch();
            //每1000次执行一次
            if ((i + 1) % 1000 == 0) {
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        JDBCUtils.close(null, preparedStatement, connection);
    }
}
