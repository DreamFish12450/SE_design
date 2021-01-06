package main.com.wswenyue.db.dao.impl;

import main.com.wswenyue.db.dao.ParkingPlaceDao;
import main.com.wswenyue.db.domain.ParkingPlace;
import main.com.wswenyue.db.utils.BeanListHandler;
import main.com.wswenyue.db.utils.JDBCUTIL;
import main.com.wswenyue.db.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
//import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ParkingPlaceDaoImpl implements ParkingPlaceDao {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://118.25.154.83:3306/esparking";
    static final String USER = "root";
    static final String PASS = "123456";
    JDBCUTIL jdbcutil = new JDBCUTIL();
    @Override
    public void reservePlace(String car_number, String parking_ID, int location_x, int location_y) throws SQLException, ParseException {
        final long l = System.currentTimeMillis();
        final int i = (int)( l % 10000 );
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "insert into parkingplace values(?,?,?,?,?,?,?,?)";
        SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date=new Date();
        String date1=temp.format(date);
        Date date2=temp.parse(date1);
        Timestamp timestamp = java.sql.Timestamp.valueOf(date1);
        Object params[] = {i,car_number,timestamp,null,parking_ID,1,location_y,location_x};
        qr.update(sql, params);
    }
    @Override
    public List<ParkingPlace> getSpareParkings(String parkingId){
            Connection conn = null;
            List<ParkingPlace> parkingPlaceList = new ArrayList<>();
            try {
                conn = jdbcutil.getConnection(); /*通过User帐号与数据库连接*/
                PreparedStatement ps = conn.prepareStatement("select * from parkingplace where parking_ID = ?"); /*创建预处理对象，并进行数据库查询*/
                ps.setString(1,parkingId);
                ResultSet rs = ps.executeQuery();  /*resultset对象表示select语句查询得到的记录集合*/
                while (rs.next()) { /*遍历select语句查询得到的记录表*/
                    ParkingPlace pl = new ParkingPlace(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getDate(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getInt(8));
                    System.out.println(pl.toString());
                    parkingPlaceList.add(pl);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                jdbcutil.closeConnection(conn);
            }

            return parkingPlaceList;

        }
        @Override
        public void updateSpare(String parkingId,Integer spacing) throws SQLException {
            QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "update parkinglot set spare_space = ? where parking_id=?";
//            SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//            Date date=new Date();
//            String date1=temp.format(date);
//            Date date2=temp.parse(date1);
//            Timestamp timestamp = java.sql.Timestamp.valueOf(date1);
            Object params[] = {spacing,parkingId};
            qr.update(sql, params);
        };


}
