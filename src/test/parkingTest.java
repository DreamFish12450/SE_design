package test;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import main.com.wswenyue.db.dao.impl.PriceDaoImpl;
import main.com.wswenyue.db.domain.Parking;
import org.junit.*;
import main.com.wswenyue.db.dao.impl.ParkingDaoImpl;

import java.sql.SQLException;
import java.util.List;

public class parkingTest {
    static ParkingDaoImpl pdl = new ParkingDaoImpl();
    @Test
    public void getList() throws SQLException {
//        ComboPooledDataSource db=new ComboPooledDataSource();
        List<Parking> l = pdl.getAll();
        for (Parking x : l) {
            System.out.println(x.toString());
        }
    }

}
