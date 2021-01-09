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
<<<<<<< Updated upstream
    void setParkingPlaceST(Sting parkingId , String parkingplace_id ,Date start_time);
    ParkingPlace getParkingPlace(String parkingId,String parkingplace_id);
=======
    ParkingPlace getParkingPlace(String parkingId,String parkingplace_id); //通过停车场标号和车位的ID返回车位
>>>>>>> Stashed changes
}

