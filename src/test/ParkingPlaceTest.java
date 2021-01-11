package test;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import main.com.wswenyue.db.dao.ParkingPlaceDao;
import main.com.wswenyue.db.dao.impl.ParkingPlaceDaoImpl;
import main.com.wswenyue.db.dao.impl.PriceDaoImpl;
import main.com.wswenyue.db.domain.Parking;
import main.com.wswenyue.db.service.ParkingPlaceService;
import main.com.wswenyue.db.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.junit.*;
import main.com.wswenyue.db.dao.impl.ParkingDaoImpl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ParkingPlaceTest {
    static ParkingPlaceDaoImpl pdl = new ParkingPlaceDaoImpl() ;
    @Test
    public void getSpare(){
        pdl.getSpareParkings("1");
    }
    @Test
    public void getSpareWithP(){
        ParkingPlaceService.getFreeParking("1");
    }
    @Test
    public void getList() throws SQLException, ParseException {
        Date date=new Date();
        SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date1=temp.format(date);
        Date date2=temp.parse(date1);
        Timestamp timestamp = java.sql.Timestamp.valueOf(date1);
        //得到一个timestamp格式的时间，存入mysql中的时间格式为"yyyy-MM-dd HH:mm:ss"
//
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        pdl.reservePlace("3","1",1,7);
//        ComboPooledDataSource db=new ComboPooledDataSource();
//        QueryRunner qr = new QueryRunner();
//        String sql = "select * from parkinglot ";
//        List<Object> parkingList = new ArrayList<>();
////        parkingList = (List<Object>);
//        Object x =  qr.query(JdbcUtils.getConnection(),sql,new ArrayHandler());
//        System.out.println(x);

//        for (Object x : parkingList) {
//            System.out.println(x.toString());
//        }
    }
    @Test
    public void reservedNew() throws SQLException, ParseException {
        ParkingPlaceService.reserveLocationForNewMan("1","982");
    }
    @Test
    public void updateSpare() throws SQLException{
        pdl.updateSpare("1",19);
    }

}
