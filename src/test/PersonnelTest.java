package test;

import main.com.wswenyue.db.dao.impl.UserDaoImpl;
import org.junit.Test;

import java.sql.SQLException;

public class PersonnelTest {
    UserDaoImpl userDaoImpl = new UserDaoImpl();
    @Test
    public void testAdmin() throws SQLException {
        System.out.println(userDaoImpl.findad("1","13").toString());
    }
}
