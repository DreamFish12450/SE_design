package main.com.wswenyue.db.service;

import main.com.wswenyue.db.dao.impl.UserDaoImpl;
import main.com.wswenyue.db.domain.UserW;

import java.sql.SQLException;

public class UserService {
    static UserDaoImpl userDao = new UserDaoImpl();
    public static UserW getUserPasswordAndBalance(String user) throws SQLException {
        return userDao.getBalanceAndPassword(user);
    }
}
