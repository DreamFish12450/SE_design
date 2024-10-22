package main.com.wswenyue.db.service;

import main.com.wswenyue.db.dao.impl.ParkingPlaceDaoImpl;
import main.com.wswenyue.db.dao.impl.ParkingFeeDaoImpl;
import main.com.wswenyue.db.domain.ParkingPlace;
import main.com.wswenyue.db.domain.ParkingFee;
import main.com.wswenyue.db.domain.UserW;
import org.junit.Test;

import javax.servlet.http.HttpServlet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class UpdatePickUpTime extends HttpServlet {
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

        //返回费用信息写入数据库
        ParkingPlace parkingPlace = placeDao.getParkingPlace(parkingId,parkingplace_id);
        System.out.printf("开始时间："+parkingPlace.getEnd_time().getTime()+" "+"结束时间："+parkingPlace.getStart_time().getTime());
        long diff = parkingPlace.getEnd_time().getTime() - parkingPlace.getStart_time().getTime();
        long hour = diff/1000/3600;
        hour = (int) (hour+0.5);
        float money = hour*5;
        ParkingFee parkingFee = new ParkingFee(username,car_mumber, (int) hour,money,parkingplace_id);
        if(money != 0) parkingFeeDao.add(parkingFee);

        //扣费 如果账户余额充足则直接扣 写入数据库； 如果账户余额不充足则转向充值页面
        UserW userW = new UserW();
        userW = parkingFeeDao.getUser(username);
        int balance = userW.getBalance();
        if(money <= balance){
            parkingFeeDao.updateBalance(username, (int) (balance-money));
        }
        else{
         //   request.getRequestDispatcher("showStaff.jsp").forward(request, response);
        }
    }
}
