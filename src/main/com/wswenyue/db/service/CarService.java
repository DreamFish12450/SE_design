package main.com.wswenyue.db.service;

import main.com.wswenyue.db.dao.impl.CarDaoImpl;
import main.com.wswenyue.db.dao.impl.CardDaoimpl;
import main.com.wswenyue.db.domain.Car;

import java.sql.SQLException;
import java.util.List;

public class CarService {
    static CarDaoImpl carDao = new CarDaoImpl();
    static public List<Car> getCarByUserName(String userName){
        return carDao.getCarByUsername(userName);
    }
    static public void insertCar(Car car) throws SQLException {carDao.insertCar(car);};
}
