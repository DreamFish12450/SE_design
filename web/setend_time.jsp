<%--
  Created by IntelliJ IDEA.
  User: 孤独之星
  Date: 2021/1/11
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>

<%

    request.setCharacterEncoding("utf-8");
    String parkingplace_ID = request.getParameter("parkingplace_ID");

    try {
        Class.forName("com.mysql.jdbc.Driver");
//桥接

        String url = "jdbc:mysql://118.25.154.83:3306/esparking"; //数据库名
        String username1 = "root";  //数据库用户名
        String password = "123456";  //数据库用户密码
        Connection conn = DriverManager.getConnection(url, username1, password);
//连接数据库

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String nowdate=df.format(new Date());// new Date()为获取当前系统时间

        if(conn != null){
            String sql = "update parkingplace set end_time=?where parkingplace_ID=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,nowdate);
            ps.setString(2,parkingplace_ID);

            ps.executeUpdate();
            conn.close();
            response.sendRedirect("SetEndtime.jsp");

        }else{
            out.print("连接失败！");
        }
    }
    catch (Exception e) {
        //e.printStackTrace();
        out.print("数据库连接异常！");
    }
%>