package main.com.wswenyue.db.dao.impl;

import main.com.wswenyue.db.dao.ParkingDao;
import main.com.wswenyue.db.domain.Parking;
import main.com.wswenyue.db.utils.JDBCUTIL;
import main.com.wswenyue.db.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParkingDaoImpl implements ParkingDao {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://118.25.154.83:3306/esparking";
    static final String USER = "root";
    static final String PASS = "123456";
    JDBCUTIL jdbcutil = new JDBCUTIL();

    @Override

    public  List<Parking> getAll()throws SQLException{
        Connection conn=null;
        List<Parking> parkingList = new ArrayList<>();
        try {
            conn = jdbcutil.getConnection(); /*通过User帐号与数据库连接*/
            PreparedStatement ps=conn.prepareStatement("select * from parkinglot "); /*创建预处理对象，并进行数据库查询*/

            ResultSet rs=ps.executeQuery();  /*resultset对象表示select语句查询得到的记录集合*/
            while(rs.next()){ /*遍历select语句查询得到的记录表*/
                Parking p = new Parking(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getDouble(4),rs.getDouble(5));
                parkingList.add(p);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            jdbcutil.closeConnection(conn);
        }

        return parkingList;

    }
}
