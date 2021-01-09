package main.com.wswenyue.db.dao.impl;

import main.com.wswenyue.db.dao.ParkingFeeDao;
import main.com.wswenyue.db.domain.ParkingFee;
import main.com.wswenyue.db.utils.JdbcUtils;
import main.com.wswenyue.db.utils.JDBCUTIL;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ParkingFeeDaoImpl implements ParkingFeeDao {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://118.25.154.83:3306/esparking";
    static final String USER = "root";
    static final String PASS = "123456";
    JDBCUTIL jdbcutil = new JDBCUTIL();

    @Override
    public List<ParkingFee> find(String username , String car_number) throws SQLException {
        Connection conn = null;
        List<ParkingFee> parkingFeeList = new ArrayList<>();
        try {
            conn = jdbcutil.getConnection(); /*通过User帐号与数据库连接*/
            PreparedStatement ps = conn.prepareStatement("select * from parkingfee where username = ? and car_number = ?"); /*创建预处理对象，并进行数据库查询*/
            ps.setString(1, username);
            ps.setString(2, car_number);
            ResultSet rs = ps.executeQuery();  /*resultset对象表示select语句查询得到的记录集合*/
            while (rs.next()) { /*遍历select语句查询得到的记录表*/
                ParkingFee p = new ParkingFee(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getFloat(4), rs.getInt(5));
                parkingFeeList.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbcutil.closeConnection(conn);
        }

        return  parkingFeeList;

    }

    @Override
    public void add(ParkingFee parkingFee) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "insert into parkingfee(username,car_number,parking_time,fee,parkingplace_ID) values(?,?,?,?,?)";
        Object params[] = {parkingFee.getUsername(),parkingFee.getCar_number(),parkingFee.getParking_time(),parkingFee.getFee(),parkingFee.getParkplace_ID()};
        qr.update(sql, params);
    }

//    @Override
//    public void update(ParkingFee parkingFee) throws SQLException {
//        QueryRunner qr = new QueryRunner();
//        String sql = "update price set  unitprice=? where pname=?";
//        Object params[] = {price.getUnitprice(),price.getPname()};
//        qr.update(JdbcUtils.getConnection(),sql, params);
//
//    }
//
//    @Override
//    public void delete(String pname) throws SQLException {
//        QueryRunner qr = new QueryRunner();
//        String sql = "delete from price where pname=?";
//        qr.update(JdbcUtils.getConnection(),sql, pname);
//    }


//    public List<ParkingFee> find(String username , String car_number) throws SQLException { //每个人通过个人用户名和车辆编号查找费用信息表
//        QueryRunner qr = new QueryRunner();
//        String sql = "select * from parkingfee where username=? and car_number=?";
//        return (Price) qr.query(JdbcUtils.getConnection(),sql, username , car_number, new BeanHandler(Price.class));
//    }
}
