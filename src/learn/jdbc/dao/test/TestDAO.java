package learn.jdbc.dao.test;

import learn.jdbc.dao.dao.EmpDAO;
import learn.jdbc.dao.domain.Emp;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author sowhile
 * @version 1.0
 * <p>
 * 2022/11/30 17:26
 */
public class TestDAO {
    @Test
    public void testLoginDAO() {
        EmpDAO empDAO = new EmpDAO();
        String sql = "SELECT * FROM emp";
        List<Emp> emps = empDAO.queryMulti(sql, Emp.class);
        for (Emp emp : emps) {
            System.out.println(emp);
        }
    }
}
