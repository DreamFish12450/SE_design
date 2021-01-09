package main.com.wswenyue.db.dao;

import main.com.wswenyue.db.domain.Amount;

import java.sql.SQLException;

public interface AmountDao {
    void charge(String username,Integer money) throws SQLException;
    Amount display_amount(String username) throws SQLException;
    void create_amount(String username) throws SQLException;
}
