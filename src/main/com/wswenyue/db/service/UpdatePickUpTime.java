package main.com.wswenyue.db.service;

import main.com.wswenyue.db.dao.impl.ParkingPlaceDaoImpl;
import main.com.wswenyue.db.dao.impl.ParkingFeeDaoImpl;
import main.com.wswenyue.db.domain.ParkingPlace;
import main.com.wswenyue.db.domain.ParkingFee;
import org.junit.Test;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class UpdatePickUpTime {
    static ParkingFeeDaoImpl parkingFeeDao = new ParkingFeeDaoImpl();
    static ParkingPlaceDaoImpl placeDao = new ParkingPlaceDaoImpl();
    @Test
    public static void UpdatePickUpTime(String parkingId,int parkingplace_id,String username,String car_mumber) throws SQLException, ParseException { //更新取车时间并且返回费用信息
        SimpleDateFormat temp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        String date1 = temp.format(date);
        Date date2 = temp.parse(date1);
        Timestamp timestamp = java.sql.Timestamp.valueOf(date1);
        placeDao.setParkingPlaceET(parkingId,parkingplace_id,timestamp);

        //返回费用信息
        ParkingPlace parkingPlace = placeDao.getParkingPlace(parkingId,parkingplace_id);
        long diff = parkingPlace.getEnd_time().getTime() - parkingPlace.getStart_time().getTime();
        long hour = diff/1000/3600;
        hour = (int) (hour+0.5);
        float money = hour*5;
        ParkingFee parkingFee = new ParkingFee(username,car_mumber, (int) hour,money,parkingplace_id);
        parkingFeeDao.add(parkingFee);
    }
}
