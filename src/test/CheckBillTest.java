package test;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import main.com.wswenyue.db.dao.impl.ParkingPlaceDaoImpl;
import main.com.wswenyue.db.dao.impl.ParkingFeeDaoImpl;
import main.com.wswenyue.db.domain.ParkingPlace;
import main.com.wswenyue.db.domain.ParkingFee;
import main.com.wswenyue.db.dao.ParkingPlaceDao;
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
    public static void main(String[] args)
    {
        UpdateParkingTime t = new UpdateParkingTime();
        t.UpdateParkingTime(1,2);
    }
}
