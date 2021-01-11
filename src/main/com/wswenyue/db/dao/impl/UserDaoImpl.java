package main.com.wswenyue.db.dao.impl;

import cn.cy.domain.User;
import main.com.wswenyue.db.dao.UserDao;

import main.com.wswenyue.db.domain.Parking;
import main.com.wswenyue.db.domain.UserW;
import main.com.wswenyue.db.domain.personnel;
import main.com.wswenyue.db.utils.JDBCUTIL;
import main.com.wswenyue.db.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wswenyue on 2015/6/6.
 */
public class UserDaoImpl implements UserDao {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://118.25.154.83:3306/esparking?characterEncoding=UTF-8";
    static final String USER = "root";
    static final String PASS = "123456";
    JDBCUTIL jdbcutil = new JDBCUTIL();


    @Override
    public void updateBalance(String username, int money) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "update user set balance = ? where username = ?";
        Object params[] = {money, username};
        qr.update(JdbcUtils.getConnection(), sql, params);
    }
    public personnel findad(String ID,String ID_number) throws SQLException {
        Connection conn = null;
        conn = jdbcutil.getConnection();
        try {
            //uname = "zjut";
            /*通过User帐号与数据库连接*/
            PreparedStatement ps = conn.prepareStatement("select * from personnel where ID = ? and ID_number=?"); /*创建预处理对象，并进行数据库查询*/
            ps.setString(1, ID);
            ps.setString(2,ID_number);
            ResultSet rs = null;
            if(ps.executeQuery() != null) { rs = ps.executeQuery();}
//            else {};
            /*resultset对象表示select语句查询得到的记录集合*/

            String id = null;
            personnel u1 = null;
//            while (rs.next()) {}
            if(rs!=null){
                while (rs.next()) { /*遍历select语句查询得到的记录表*/
                    //int id=rs.getInt("user");
                    id = rs.getString(1);
                    String name = rs.getString(2);
                    //String age = rs.getString(3);
                    Integer age = rs.getInt(3);
                    String sex = rs.getString(4);
                    String ID_num = rs.getString(5);
                    String ph = rs.getString(6);
                    String f=rs.getString(7);
                    String ad=rs.getString(8);
                    String po=rs.getString(9);
                    u1 = new personnel(id,name,age, sex, ID_num, ph, f,ad,po);
//            parkingList.add(p);
                    System.out.println(u1);
                    return u1;
                }
            }else {return null;}

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbcutil.closeConnection(conn);
        }

        return null;
    }

    public UserW getBalanceAndPassword(String user) throws SQLException{
        Connection conn = null;
        UserW userW = new UserW();
        try {
            conn = jdbcutil.getConnection(); /*通过User帐号与数据库连接*/
            PreparedStatement ps = conn.prepareStatement("select password,balance from user where username = ?"); /*创建预处理对象，并进行数据库查询*/
            ps.setString(1,user);
            ResultSet rs = ps.executeQuery();  /*resultset对象表示select语句查询得到的记录集合*/
            while (rs.next()) { /*遍历select语句查询得到的记录表*/

                userW.setPassword(rs.getString(1));
                userW.setUsername(user);
                userW.setBalance(rs.getInt(2));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbcutil.closeConnection(conn);
        }

        return userW;
    }

    @Override
    public void add(UserW user) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "insert into user(username,password,name,age,sex,ID_number,phone_number,Face_ID,balance) values(?,?,?,?,?,?,?,?,?)";
        Object params[] = {user.getUsername(), user.getPassword(), user.getName(), user.getAge(), user.getSex(), user.getID_number(), user.getPhone_number(), null,0};
        System.out.println(user.getSex());
        qr.update(sql, params);
    }

    @Override
    public UserW find(String username, String password) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "select * from user where username=? and password=?";
        Object params[] = {username, password};
        return (UserW) qr.query(JdbcUtils.getConnection(), sql, params, new BeanHandler(UserW.class));
    }

    @Override
    public List<UserW> find() throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "select * from user";
        return (List<UserW>) qr.query(JdbcUtils.getConnection(), sql, new BeanListHandler(UserW.class));
    }


    public UserW findUserByName(String uname) throws SQLException {
        //QueryRunner qr = new QueryRunner();
        //String sql = "select * from user where username=?";

        // UserW uu = (UserW) qr.query(JdbcUtils.getConnection(), sql, new Object[]{uname}, new BeanHandler(UserW.class));
        //return (UserW) qr.query(JdbcUtils.getConnection(), sql, uname, new BeanHandler(UserW.class));
        Connection conn = null;
        conn = jdbcutil.getConnection();
        try {
            //uname = "zjut";
 /*通过User帐号与数据库连接*/
            String sql = "select * from user where username = ?";
            PreparedStatement ps = conn.prepareStatement("select * from user where username = ?"); /*创建预处理对象，并进行数据库查询*/
            ps.setString(1, uname);
            ResultSet rs = null;
            if(ps.executeQuery() != null) { rs = ps.executeQuery();}
//            else {};
              /*resultset对象表示select语句查询得到的记录集合*/

            String name = null;
            UserW u1 = null;
//            while (rs.next()) {}
            if(rs!=null){
                while (rs.next()) { /*遍历select语句查询得到的记录表*/
                    //int id=rs.getInt("user");
                    name = rs.getString(1);
                    String pw = rs.getString(2);
                    String na = rs.getString(3);
                    Integer age = rs.getInt(4);
                    String sex = rs.getString(5);
                    String ID_number = rs.getString(6);
                    String ph = rs.getString(7);
                    u1 = new UserW(name, pw, na, age, sex, ID_number, ph, null, null);
//            parkingList.add(p);
                    System.out.println(u1);
                    return u1;
                }
            }else {return null;}

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbcutil.closeConnection(conn);
        }
//        return u1;

        //  return uu;
        return null;
    }

}
