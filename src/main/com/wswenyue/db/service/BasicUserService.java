package main.com.wswenyue.db.service;


import main.com.wswenyue.db.dao.impl.UserDaoImpl;
import main.com.wswenyue.db.domain.UserW;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * 查找用户是否存在:FindUser()
 * 查询余额:InquireBalance()
 * 返回用户登录状态：UserStatus()
 * 查看用户账户余额是否大于零：CheckBalance()
 * 查看用户是否已登录：CheckAlreadyLogin()
 *通过手机号得到uid：FindUser()
 * Created by wswenyue on 2015/6/6.
 */
public class BasicUserService {
    static UserDaoImpl userDao = new UserDaoImpl();

    /**
     * 查找用户是否存在
     * @param uname
     * @param pass
     * @return 用户存在返回true，不存在返回false
     * */
    public static boolean FindUser(String uname,String pass){
        try {
            UserW user = userDao.find(uname,pass);
            if( user!= null && user.getUsername().equals(uname)){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }





    /**
     * 得到users
     * @return 用户存在返回uid，不存在返回null
     * */
    public static List<UserW> GetUsers(){
        try {
            List<UserW> users = userDao.find();
            if(users.size()!=0){
               return users;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }




    /**
     * 通过用户名得到user
     * @param uname
     * @return 用户存在返回uid，不存在返回null
     * */
    public static UserW GetUserByName(String uname){
        try {
            UserW user = userDao.findUserByName(uname);
            if(user != null){
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }







    /**查询余额
     * */
    public static Integer InquireBalance(UserW user){
        Integer balance = null;
        if(GetUserByName(user.getUsername())!=null){
            balance = user.getBalance();
        }
        return balance;
    }

    /**
     * 查看用户账户余额是否大于零
     * @param user
     * @return 余额大于零返回true，小于零返回false
     * */
    public static boolean CheckBalance(UserW user){
        Integer money = InquireBalance(user);
        if( money != null && money > 0){
            return true;
        }
        return false;
    }






    /**
     * 更新余额
     * */
    public static boolean UpdateBalance(String phone, int balance){
        try {
            userDao.updateBalance(phone,balance);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * 充值
     * */
    public static boolean Prepaid(String username, int money){
        try {
            UserW user = GetUserByName(username);
            if(user!=null){
                userDao.updateBalance(username,user.getBalance()+money);
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
