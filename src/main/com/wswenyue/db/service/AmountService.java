package main.com.wswenyue.db.service;

import main.com.wswenyue.db.dao.AmountDao;
import main.com.wswenyue.db.dao.impl.AmountDaoImpl;
import main.com.wswenyue.db.domain.Amount;

import java.sql.SQLException;

public class AmountService {
    static AmountDaoImpl amountDao = new AmountDaoImpl();
    static public Amount getAmount(String user) throws SQLException {
        return(amountDao.display_amount(user));
    }
    static public void charges(String user,int money) throws SQLException {
        amountDao.charge(user,money);
    }
}
