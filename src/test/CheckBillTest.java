package test;

import main.com.wswenyue.db.domain.ParkingFee;
import main.com.wswenyue.db.service.CheckBill;
import main.com.wswenyue.db.service.UpdatePickUpTime;
import org.junit.Test;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class CheckBillTest {
//    static ParkingPlaceDaoImpl placeDao = new ParkingPlaceDaoImpl();
//    public static void UpdateParkingTime(String parkingId,String parkingplace_id) {
//
//        ParkingPlace paringPlace = placeDao.getParkingPlace(String parkingId,String parkingplace_id);
//        paringPlace.start_time = new Date();
//    }
    @Test
    public void test() throws ParseException, SQLException {
        List<ParkingFee> list1 = new ArrayList<>();
        CheckBill t = new CheckBill();
        list1 = t.checkBill("zky","1");
        for(ParkingFee pf : list1)
        {
            System.out.println(pf.toString());
        }
    }
}
