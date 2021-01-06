package main.com.wswenyue.db.dao;

import main.com.wswenyue.db.domain.Car;

import java.util.List;

public interface CarDao {
     List<Car> getCarByUsername(String username);
}
