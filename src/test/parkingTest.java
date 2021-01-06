package test;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import main.com.wswenyue.db.dao.impl.UserDaoImpl;
import main.com.wswenyue.db.domain.UserW;
import main.com.wswenyue.db.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.junit.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class parkingTest {
    //static ParkingDaoImpl pdl = new ParkingDaoImpl();
    static UserDaoImpl ud=new UserDaoImpl();
    @Test
    public void getList() throws SQLException {
     // ComboPooledDataSource db=new ComboPooledDataSource();
    //    QueryRunner qr = new QueryRunner();
        UserW u1=new UserW("czy2","123","cc",18,"男","330","189",null,null,null);
        if(ud.findUserByName("czy2")==null) {
            ud.add(u1);
            System.out.println("允许");
        }
        else System.out.println("不允许！");

    }


}
