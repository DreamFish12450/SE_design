package test;

import main.com.wswenyue.db.service.UpdateParkingTime;
import main.com.wswenyue.db.service.UpdatePickUpTime;
import org.junit.Test;

import java.sql.SQLException;
import java.text.ParseException;

public class UpdatePickUpTimeTest {
//    static ParkingPlaceDaoImpl placeDao = new ParkingPlaceDaoImpl();
//    public static void UpdateParkingTime(String parkingId,String parkingplace_id) {
//
//        ParkingPlace paringPlace = placeDao.getParkingPlace(String parkingId,String parkingplace_id);
//        paringPlace.start_time = new Date();
//    }
    @Test
    public void test() throws ParseException, SQLException {
        UpdatePickUpTime t = new UpdatePickUpTime();
        t.UpdatePickUpTime("1",2,"zky","1");
    }
}
