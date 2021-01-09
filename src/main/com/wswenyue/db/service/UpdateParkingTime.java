package main.com.wswenyue.db.service;

import main.com.wswenyue.db.dao.impl.ParkingPlaceDaoImpl;
import main.com.wswenyue.db.domain.ParkingPlace;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;

public class UpdateParkingTime {
    static ParkingPlaceDaoImpl placeDao = new ParkingPlaceDaoImpl();
    @Test
    public static void UpdateParkingTime(String parkingId,String parkingplace_id) {

        ParkingPlace parkingPlace = placeDao.getParkingPlace(String parkingId,String parkingplace_id);
        parkingPlace.start_time = new Date();
        parkingPlace.
    }
}
