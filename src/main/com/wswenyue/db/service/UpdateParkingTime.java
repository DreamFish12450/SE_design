package main.com.wswenyue.db.service;

import main.com.wswenyue.db.dao.impl.ParkingPlaceDaoImpl;
import main.com.wswenyue.db.domain.ParkingPlace;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.*;

public class UpdateParkingTime {
    static ParkingPlaceDaoImpl placeDao = new ParkingPlaceDaoImpl();
    @Test
    public static void updateParkingTime(int parkingId, int location_x , int location_y) throws ParseException {
        SimpleDateFormat temp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        String date1 = temp.format(date);
        Date date2 = temp.parse(date1);
        Timestamp timestamp = java.sql.Timestamp.valueOf(date1);
        placeDao.setParkingPlaceST(String.valueOf(parkingId),location_x,location_y,timestamp);
        //placeDao.setParkingPlaceST(String.valueOf(1),1,1,timestamp);
    }
}
