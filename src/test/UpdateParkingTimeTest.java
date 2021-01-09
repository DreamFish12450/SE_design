package test;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import main.com.wswenyue.db.dao.ParkingPlaceDao;
import main.com.wswenyue.db.dao.impl.ParkingPlaceDaoImpl;
import main.com.wswenyue.db.dao.impl.PriceDaoImpl;
import main.com.wswenyue.db.domain.Parking;
import main.com.wswenyue.db.service.ParkingPlaceService;
import main.com.wswenyue.db.service.UpdateParkingTime;
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

public class UpdateParkingTimeTest {
//    static ParkingPlaceDaoImpl placeDao = new ParkingPlaceDaoImpl();
//    public static void UpdateParkingTime(String parkingId,String parkingplace_id) {
//
//        ParkingPlace paringPlace = placeDao.getParkingPlace(String parkingId,String parkingplace_id);
//        paringPlace.start_time = new Date();
//    }
    @Test
    public void test() throws ParseException {
        UpdateParkingTime t = new UpdateParkingTime();
        t.updateParkingTime(1,1,1);
    }
}
