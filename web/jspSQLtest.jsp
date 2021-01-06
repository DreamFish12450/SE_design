
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<html>
<head>
    <title>成功测试模板，利用jsp直接导出数据库数据，运行需在tomcat的lib中添加mysql-connector-java-5.1.46.jar</title>
</head>
<body>

<%
    try {
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://118.25.154.83:3306/esparking"; //数据库名
        String username = "root";  //数据库用户名
        String password = "123456";  //数据库用户密码
        Connection conn = DriverManager.getConnection(url, username, password);  //连接状态

        if(conn != null){
            out.print("数据库连接成功！");
            out.print("<br />");
            Statement stmt = null;
            ResultSet rs = null;
            String sql = "SELECT * FROM parkinglot;";  //查询语句
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            out.print("查询结果：");
            out.print("<br />");
            out.println("parking_ID"+"  "+"parking_name");
            out.print("<br />");
            while (rs.next()) {
                int id  = rs.getInt("parking_ID");
                String name = rs.getString("parking_name");
                out.println(id+" "+name); //将查询结果输出
                out.print("<br />");
            }
        }else{
            out.print("连接失败！");
        }
    }catch (Exception e) {
        //e.printStackTrace();
        out.print("数据库连接异常！");
    }
%>
</body>
</html>
