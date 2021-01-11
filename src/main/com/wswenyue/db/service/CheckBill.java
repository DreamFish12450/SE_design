package main.com.wswenyue.db.service;

import main.com.wswenyue.db.dao.impl.ParkingPlaceDaoImpl;
import main.com.wswenyue.db.dao.impl.ParkingFeeDaoImpl;
import main.com.wswenyue.db.domain.ParkingFee;

import java.sql.SQLException;
import java.util.List;


public class  CheckBill {
    static ParkingPlaceDaoImpl placeDao = new ParkingPlaceDaoImpl();
    static ParkingFeeDaoImpl parkingFeeDao = new ParkingFeeDaoImpl();
    public static List<ParkingFee> checkBill(String username, String car_number) throws SQLException {
        return parkingFeeDao.find(username , car_number);
    }
}
