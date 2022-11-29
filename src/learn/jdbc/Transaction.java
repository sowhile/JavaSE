package learn.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author sowhile
 * @version 1.0
 * <p>
 * 2022/11/29 23:22
 */
public class Transaction {

    @Test
    public void met1() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;

        String sql1 = "UPDATE test SET money = money - 100 WHERE id = 2";
        String sql2 = "UPDATE test SET money = money + 100 WHERE id = 3";
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql1);
            connection.setAutoCommit(false);
            preparedStatement.executeUpdate();

            int i = 1 / 0;

            preparedStatement1 = connection.prepareStatement(sql2);
            preparedStatement1.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            System.out.println("roll back.");
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(null, preparedStatement, connection);
            JDBCUtils.close(null, preparedStatement1, null);
        }
    }
}
