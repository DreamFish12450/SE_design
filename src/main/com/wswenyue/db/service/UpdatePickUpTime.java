package main.com.wswenyue.db.service;

import main.com.wswenyue.db.dao.impl.ParkingPlaceDaoImpl;
import main.com.wswenyue.db.dao.impl.ParkingFeeDaoImpl;
import main.com.wswenyue.db.domain.ParkingPlace;
import main.com.wswenyue.db.domain.ParkingFee;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class UpdatePickUpTime {
    static ParkingFeeDaoImpl parkingFeeDao = new ParkingFeeDaoImpl();
    static ParkingPlaceDaoImpl placeDao = new ParkingPlaceDaoImpl();
    public static void UpdatePickUpTime(String parkingId,String parkingplace_id,String username,String car_mumber) { //更新取车时间并且返回费用信息

        ParkingPlace paringPlace = placeDao.getParkingPlace(String parkingId,String parkingplace_id);
        paringPlace.end_time = new Date();

        //返回费用信息
        long diff = paringPlace.end_time.getTime() - paringPlace.start_time.getTime();
        long hour = diff/1000/3600;
        float money = hour*5;
        ParkingFee parkingFee = new ParkingFee(username,car_mumber,hour,money,parkingplace_id);
        parkingFeeDao.add(parkingFee);
    }
}
