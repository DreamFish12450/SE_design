package main.com.wswenyue.db.dao.impl;

import cn.cy.domain.User;
import main.com.wswenyue.db.dao.UserDao;
import main.com.wswenyue.db.domain.Parking;
import main.com.wswenyue.db.domain.UserW;
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
    static final String DB_URL = "jdbc:mysql://118.25.154.83:3306/esparking";
    static final String USER = "root";
    static final String PASS = "123456";
    JDBCUTIL jdbcutil = new JDBCUTIL();




    @Override
    public void updateBalance(String username, int money) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "update user set balance=? where username=?";
        Object params[] = {money,username};
        qr.update(JdbcUtils.getConnection(),sql, params);
    }


    @Override
    public void add(UserW user) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "insert into user(username,password,name,age,sex,ID_number,phone_number,Face_ID,balance,VIP_level) values(?,?,?,?,?,?,?,?,?,?)";
        Object params[] = {user.getUsername(),user.getPassword(),user.getName(),user.getAge(),user.getSex(),user.getID_number(),user.getPhone_number(),null,null,null,};
        qr.update(sql, params);
    }

    @Override
    public UserW find(String username, String password) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "select * from user where username=? and password=?";
        Object params[] = {username,password};
        return (UserW) qr.query(JdbcUtils.getConnection(),sql,params, new BeanHandler(UserW.class));
    }

    @Override
    public List<UserW> find() throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "select * from user";
        return (List<UserW>) qr.query(JdbcUtils.getConnection(),sql, new BeanListHandler(UserW.class));
    }


    public UserW findUserByName(String uname) throws SQLException {
        //QueryRunner qr = new QueryRunner();
        //String sql = "select * from user where username=?";

        // UserW uu = (UserW) qr.query(JdbcUtils.getConnection(), sql, new Object[]{uname}, new BeanHandler(UserW.class));
        //return (UserW) qr.query(JdbcUtils.getConnection(), sql, uname, new BeanHandler(UserW.class));
        Connection conn = null;
        conn = jdbcutil.getConnection(); /*通过User帐号与数据库连接*/
        String sql="select * from user where username=?";
        PreparedStatement ps = conn.prepareStatement(sql); /*创建预处理对象，并进行数据库查询*/
        ps.setString(1,uname);
        ResultSet rs = ps.executeQuery();  /*resultset对象表示select语句查询得到的记录集合*/

        String name=null;
        UserW u1=null;
        while (rs.next()) { /*遍历select语句查询得到的记录表*/
            //int id=rs.getInt("user");
            name=rs.getString("username");
            String pw=rs.getString("password");
            String na=rs.getString("name");
            Integer age=rs.getInt("age");
            String sex=rs.getString("sex");
            String ID_number=rs.getString("ID_number");
            String ph=rs.getString("phone_number");
            u1=new UserW(name,pw,na,age,sex,ID_number,ph,null,null,null);
            //parkingList.add(p);
        }
        return u1;

        //  return uu;
    }

}
