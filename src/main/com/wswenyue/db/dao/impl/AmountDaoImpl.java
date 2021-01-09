package main.com.wswenyue.db.dao.impl;

import main.com.wswenyue.db.dao.AmountDao;
import main.com.wswenyue.db.domain.Amount;
import main.com.wswenyue.db.domain.Car;
import main.com.wswenyue.db.utils.JDBCUTIL;
import main.com.wswenyue.db.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AmountDaoImpl implements AmountDao {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://118.25.154.83:3306/esparking";
    static final String USER = "root";
    static final String PASS = "123456";
    JDBCUTIL jdbcutil = new JDBCUTIL();
    @Override
    public void charge(String username,Integer money) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "update vipInfo set totalAmount = ? where username = ?";
        Object params[] = {money,username};
        qr.update(jdbcutil.getConnection(),sql, params);
    }
    //TODO  注册新用户的时候要调用;
    @Override
    public void create_amount(String username) throws SQLException{
        QueryRunner queryRunner = new QueryRunner();
        String sql = "insert into vipInfo values(?,?,?)";
        Object params[] ={username,0,0};
        queryRunner.update(jdbcutil.getConnection(),sql, params);
    }
    @Override
    public Amount display_amount(String username) throws SQLException{
        Connection conn = null;
        Amount amount = null;
        try {
            conn = jdbcutil.getConnection(); /*通过User帐号与数据库连接*/
            PreparedStatement ps = conn.prepareStatement("select viplevel,totalAmount from vipInfo where username = ?"); /*创建预处理对象，并进行数据库查询*/
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();  /*resultset对象表示select语句查询得到的记录集合*/
            while (rs.next()) { /*遍历select语句查询得到的记录表*/
                amount = new Amount(username,rs.getInt(1),rs.getInt(2));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbcutil.closeConnection(conn);
        }

        return amount;
    };
}
