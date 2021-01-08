<%--
  Created by IntelliJ IDEA.
  User: 孤独之星
  Date: 2021/1/7
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>

<%

    request.setCharacterEncoding("utf-8");
    String ID = request.getParameter("ID");
    String name = request.getParameter("name");
    String age = request.getParameter("age");
    String sex = request.getParameter("sex");
    String ID_number = request.getParameter("ID_number");
    String phone_number = request.getParameter("phone_number");
    String address = request.getParameter("address");
    String post = request.getParameter("post");
    try {
    Class.forName("com.mysql.jdbc.Driver");
//桥接

    String url = "jdbc:mysql://118.25.154.83:3306/esparking"; //数据库名
    String username1 = "root";  //数据库用户名
    String password = "123456";  //数据库用户密码
    Connection conn = DriverManager.getConnection(url, username1, password);
//连接数据库
        if(conn != null){
    String sql = "insert into personnel values(?,?,?,?,?,?,null,?,?)";

    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1,ID);
    ps.setString(2,name);
    ps.setString(3,age);
    ps.setString(4,sex);
    ps.setString(5,ID_number);
    ps.setString(6,phone_number);
    ps.setString(7,address);
    ps.setString(8,post);
    ps.executeUpdate();
    conn.close();
    response.sendRedirect("Modifyinformation.jsp");

    }else{
    out.print("连接失败！");
    }
    }
    catch (Exception e) {
        //e.printStackTrace();
        out.print("数据库连接异常！");
    }
%>