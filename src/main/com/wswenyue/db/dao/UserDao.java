package main.com.wswenyue.db.dao;


import main.com.wswenyue.db.domain.UserW;

import java.sql.SQLException;
import java.util.List;


public interface UserDao {

	/** 添加用户*/
	void add(UserW user) throws SQLException;

	/** 通过账户查找用户 */
	UserW find(String  username, String password) throws SQLException;

	/** 查找所有用户 */
	List<UserW> find() throws SQLException;

	/** 对用户的金额进行处理*/
	void updateBalance(String phone, int money) throws SQLException;

	UserW getBalanceAndPassword(String user) throws SQLException;

	/** 修改密码*/
	//void updatePasswd(String phone, String NewPasswd) throws SQLException;












}