package main.com.wswenyue.db.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUTIL {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://118.25.154.83:3306/esparking";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "123456";
    Connection conn = null;

    public  Connection getConnection() throws  SQLException{
        try
        {
            Class.forName(JDBC_DRIVER);
            conn= DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("success");
            return conn;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("error");
            return null;
        }

    }
    public void closeConnection(Connection conn){
        try {

            if(this.conn !=null){
                this.conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
