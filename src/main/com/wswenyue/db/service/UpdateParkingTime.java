package main.com.wswenyue.db.service;

import main.com.wswenyue.db.dao.impl.ParkingPlaceDaoImpl;
import main.com.wswenyue.db.domain.ParkingPlace;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.*;

public class UpdateParkingTime {
    static ParkingPlaceDaoImpl placeDao = new ParkingPlaceDaoImpl();
    public static void UpdateParkingTime(String parkingId,int location_x ,int location_y) {
        Date date =new Date();
        placeDao.setParkingPlaceST(parkingId,location_x,location_y,date);
    }
}
