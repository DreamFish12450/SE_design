package main.com.wswenyue.db.dao.impl;

import main.com.wswenyue.db.dao.CarDao;
import main.com.wswenyue.db.domain.Car;
import main.com.wswenyue.db.domain.ParkingPlace;
import main.com.wswenyue.db.utils.JDBCUTIL;
import main.com.wswenyue.db.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl implements CarDao {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://118.25.154.83:3306/esparking";
    static final String USER = "root";
    static final String PASS = "123456";
    JDBCUTIL jdbcutil = new JDBCUTIL();
    @Override
    public List<Car> getCarByUsername(String username){

        Connection conn = null;
        List<Car> CarList = new ArrayList<>();
//        JDBCUTIL jdbcutil;
        try {
            conn = jdbcutil.getConnection(); /*通过User帐号与数据库连接*/
            PreparedStatement ps = conn.prepareStatement("select * from vehicle where username = ?"); /*创建预处理对象，并进行数据库查询*/
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();  /*resultset对象表示select语句查询得到的记录集合*/
            while (rs.next()) { /*遍历select语句查询得到的记录表*/
                Car car = new Car(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5) );
                System.out.println(car.toString());
                CarList.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbcutil.closeConnection(conn);
        }

        return CarList;
    }


    @Override
    public void insertCar(Car car) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "insert into vehicle values(?,?,?,?,?)";
//            SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//            Date date=new Date();
//            String date1=temp.format(date);
//            Date date2=temp.parse(date1);
//            Timestamp timestamp = java.sql.Timestamp.valueOf(date1);
        Object params[] = {car.getCar_number(),car.getCar_brand(),car.getCar_model(),car.getTraffic_permit(),car.getUsername()};
        qr.update(jdbcutil.getConnection(), sql,params);
    }
}
