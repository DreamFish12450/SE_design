package test;

import main.com.wswenyue.db.dao.impl.CarDaoImpl;
import main.com.wswenyue.db.dao.impl.CardDaoimpl;
import org.junit.Test;

public class CarTest {
    CarDaoImpl carDaoimpl = new CarDaoImpl();
    @Test
    public void getCar(){
        carDaoimpl.getCarByUsername("zky");
    }
}
