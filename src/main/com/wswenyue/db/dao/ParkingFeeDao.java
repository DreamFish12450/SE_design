package main.com.wswenyue.db.dao;


import main.com.wswenyue.db.domain.ParkingFee;
import main.com.wswenyue.db.domain.ParkingPlace;
import main.com.wswenyue.db.domain.UserW;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by wswenyue on 2015/6/6.
 */
public interface ParkingFeeDao {
    void add(ParkingFee parkingFee) throws SQLException;

//    void update(ParkingFee parkingFee) throws SQLException;
//
//    void delete(ParkingFee parkingFee) throws SQLException;

    List<ParkingFee> find(String username , String car_number) throws SQLException;

    UserW getUser(String username) throws SQLException;

    void updateBalance(String username , int balance);
}
