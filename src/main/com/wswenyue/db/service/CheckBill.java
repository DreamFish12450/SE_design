package main.com.wswenyue.db.service;

import main.com.wswenyue.db.dao.impl.ParkingPlaceDaoImpl;
import main.com.wswenyue.db.dao.impl.ParkingFeeDaoImpl;
import main.com.wswenyue.db.domain.ParkingPlace;
import main.com.wswenyue.db.domain.ParkingFee;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Test
public class List<parkingFee> CheckBill {
    static ParkingPlaceDaoImpl placeDao = new ParkingPlaceDaoImpl();
    static ParkingFeeDaoImpl parkingFeeDao = new ParkingFeeDaoImpl();
    public static List<parkingFee> CheckBill(String username,String car_number) {
        return parkingFeeDao.find(String username , String car_number);
    }
}
