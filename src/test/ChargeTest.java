package test;

import main.com.wswenyue.db.dao.impl.AmountDaoImpl;
import org.junit.Test;

import java.sql.SQLException;

public class ChargeTest {
    AmountDaoImpl amountDao = new AmountDaoImpl();
    @Test
    public void charge() throws SQLException {
        amountDao.charge("zky",20);
    }
    @Test
    public void create() throws SQLException{
        amountDao.create_amount("1234568");
    }
    @Test
    public void showCharge() throws SQLException{
       System.out.println(amountDao.display_amount("zky"));
    }
}
