<%--
  Created by IntelliJ IDEA.
  User: 孤独之星
  Date: 2021/1/8
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>

<html>
<head>
    <title>按日期查询车位结果</title>
    <style type="text/css">
        #table thead, #table-3 tr {
            border-top-width: 1px;
            border-top-style: solid;
            border-top-color: rgb(235, 242, 224);
        }
        #table {
            border-bottom-width: 1px;
            border-bottom-style: solid;
            border-bottom-color: rgb(235, 242, 224);
        }

        /* Padding and font style */
        #table td, #table th {
            padding: 15px 75px;
            font-size: 12px;
            font-family: Verdana;
            color: rgb(33, 38, 24);
        }

        /* Alternating background colors */
        #table tr:nth-child(even) {
            background: rgb(169, 169, 169)
        }
        #table tr:nth-child(odd) {
            background: #FFF
        }

    </style>
</head>
<body>
<table id="table">
    <tr>
        <th>车位号</th>
        <th>停车场</th>
        <th>车牌号</th>
        <th>开始停车时间</th>
        <th>结束停车时间</th>
    </tr>
        <%
           request.setCharacterEncoding("utf-8");
           String start=request.getParameter("start");
           String end=request.getParameter("end");
            try {
                Class.forName("com.mysql.jdbc.Driver");

                String url = "jdbc:mysql://118.25.154.83:3306/esparking"; //数据库名
                String username1 = "root";  //数据库用户名
                String password = "123456";  //数据库用户密码
                Connection conn = DriverManager.getConnection(url, username1, password);  //连接状态

                if(conn != null){


                    Statement stmt = null;
                    ResultSet rs = null;
                    String sql = "SELECT * FROM showparkingplace;";  //查询语句
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery(sql);


                    while (rs.next()) {
                       String parkingplace_ID=rs.getString("parkingplace_ID");
                        String parking_name=rs.getString("parking_name");
                        String car_number=rs.getString("car_number");
                        String start_time=rs.getString("start_time");
                        String end_time=rs.getString("end_time");
                        if(start.equals("")||end.equals("")) {
                            out.print("<tr>");
                            out.print("<td>");
                            out.print(parkingplace_ID);
                            out.print("</td>");
                            out.print("<td>");
                            out.print(parking_name);
                            out.print("</td>");
                            out.print("<td>");
                            out.print(car_number);
                            out.print("</td>");
                            out.print("<td>");
                            out.print(start_time);
                            out.print("</td>");
                            out.print("<td>");
                            out.print(end_time);
                            out.print("</td>");
                            out.print("</tr>");
                        }
                        else if(!start_time.equals("null")&&!end_time.equals("null"))
                        {   if(start.compareTo(start_time)<0&&end.compareTo(end_time)>0)
                            {
                            out.print("<tr>");
                            out.print("<td>");
                            out.print(parkingplace_ID);
                            out.print("</td>");
                            out.print("<td>");
                            out.print(parking_name);
                            out.print("</td>");
                            out.print("<td>");
                            out.print(car_number);
                            out.print("</td>");
                            out.print("<td>");
                            out.print(start_time);
                            out.print("</td>");
                            out.print("<td>");
                            out.print(end_time);
                            out.print("</td>");
                            out.print("</tr>");
                        }
                        }
                    }
                }else{
                    out.print("连接失败！");
                }
            }catch (Exception e) {
                //e.printStackTrace();
                out.print("数据库连接异常！");
            }
        %>

</table>
</body>
</html>
