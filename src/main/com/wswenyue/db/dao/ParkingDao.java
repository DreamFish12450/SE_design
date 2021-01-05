package main.com.wswenyue.db.dao;

import main.com.wswenyue.db.domain.Parking;

import java.sql.SQLException;
import java.util.List;

public interface ParkingDao {
    List<Parking> getAll()throws SQLException;
}
