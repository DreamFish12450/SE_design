package test;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import main.com.wswenyue.db.dao.impl.ParkingDaoImpl;
import main.com.wswenyue.db.dao.impl.UserDaoImpl;
import main.com.wswenyue.db.domain.UserW;
import main.com.wswenyue.db.domain.personnel;
import main.com.wswenyue.db.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.junit.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class parkingTest {

    static ParkingDaoImpl pdl = new ParkingDaoImpl();


    //static ParkingDaoImpl pdl = new ParkingDaoImpl();
    static UserDaoImpl ud=new UserDaoImpl();
    @Test

    public void getList() throws SQLException {

        UserW u1=new UserW("czy","123","cc",18,"男","330","189",null,null);
        if(ud.findUserByName("czy")==null) {
           ud.add(u1);
            System.out.println("允许");
        }
        else System.out.println("不允许！");

       personnel p1=ud.findad("5","334561848957515672");
       if(p1==null) System.out.println("不允许！");
       else System.out.println("允许！");
    }


}
