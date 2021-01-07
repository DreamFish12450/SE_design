package test;

import main.com.wswenyue.db.dao.impl.CarDaoImpl;
import main.com.wswenyue.db.dao.impl.CardDaoimpl;
import main.com.wswenyue.db.domain.Car;
import org.junit.Test;

import java.sql.SQLException;

public class CarTest {
    CarDaoImpl carDaoimpl = new CarDaoImpl();
    @Test
    public void getCar(){
        carDaoimpl.getCarByUsername("zky");
    }
    @Test
    public void insertCar() throws SQLException {

        Car car = new Car("119","大众","轿车","是","zky");
        carDaoimpl.insertCar(car);
    }
}
