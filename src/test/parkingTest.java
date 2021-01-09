package test;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import main.com.wswenyue.db.dao.impl.PriceDaoImpl;
import main.com.wswenyue.db.domain.Parking;
import main.com.wswenyue.db.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.junit.*;
import main.com.wswenyue.db.dao.impl.ParkingDaoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class parkingTest {
    static ParkingDaoImpl pdl = new ParkingDaoImpl();

    public void getList() throws SQLException {
//        ComboPooledDataSource db=new ComboPooledDataSource();
        QueryRunner qr = new QueryRunner();
        String sql = "select * from parkinglot ";
        List<Object> parkingList = new ArrayList<>();
//        parkingList = (List<Object>);
        Object x =  qr.query(JdbcUtils.getConnection(),sql,new ArrayHandler());
        System.out.println(x);

//        for (Object x : parkingList) {
//            System.out.println(x.toString());
//        }
    }

}
