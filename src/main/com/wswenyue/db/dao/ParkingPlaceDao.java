package main.com.wswenyue.db.dao;

import main.com.wswenyue.db.domain.ParkingPlace;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface ParkingPlaceDao {
    List<ParkingPlace> getSpareParkings(String parkingId);
    void updateSpare(String parkingId,Integer spacing) throws SQLException;
    void reservePlace(String car_number, String parking_ID,int location_x,int location_y) throws SQLException, ParseException;
    void setParkingPlaceST(String parkingId , int location_x , int location_y ,Date start_time);
    ParkingPlace getParkingPlace(String parkingId,int parkingplace_id) throws SQLException;
    void setParkingPlaceET(String parkingId , int parkingplace_id ,Date end_time);
}

