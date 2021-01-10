package test;

import main.com.wswenyue.db.service.UserService;
import org.junit.Test;

import java.sql.SQLException;

public class UserTest {
    @Test
    public void testUser() throws SQLException {

        System.out.println(UserService.getUserPasswordAndBalance("zky"));
    }
}
