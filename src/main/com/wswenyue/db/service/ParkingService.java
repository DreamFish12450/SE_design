package main.com.wswenyue.db.service;

import main.com.wswenyue.db.dao.impl.ParkingDaoImpl;
import main.com.wswenyue.db.domain.Parking;

import java.sql.SQLException;
import java.util.List;

public class ParkingService {
    static ParkingDaoImpl parkingDao = new ParkingDaoImpl();
    public static List<Parking> getAll() throws SQLException {
        return parkingDao.getAll();
    }
}
