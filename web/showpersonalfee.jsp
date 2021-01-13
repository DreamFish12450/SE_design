<%--
  Created by IntelliJ IDEA.
  User: 孤独之星
  Date: 2021/1/6
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>




<html lang="zh-cn">
<head>
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
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>showfee</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="template/vendor/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="template/vendor/font-awesome/css/font-awesome.min.css">
    <!-- Fontastic Custom icon font-->
    <link rel="stylesheet" href="template/css/fontastic.css">
    <!-- Google fonts - Poppins -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="template/css/style.default.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="template/css/custom.css">
    <!-- Favicon-->
    <link rel="shortcut icon" href="template/img/favicon.ico">
</head>
<!--<script src="js/Url.js"></script>-->
<body>
<span class="username" style="visibility: hidden">${sessionScope.username}</span>
<app id="app" :info="info" :state="state">
    <!-- Content -->
    <!-- 填写内容 -->
    <div class="card" style="margin: 10px">

    <div class="card-header d-flex align-items-center">
        <h3 class="h4">费用记录</h3>
    </div>
    <div class="card-body">
        <div class="table-responsive">
    <table class="table table-striped table-sm">
        <thead>
        <tr>
            <th>用户名</th>
            <th>车型</th>
            <th>停车时长</th>
            <th>停车位置</th>
            <th>停车费</th>
        </tr>
        </thead>
        <tbody>
        <%
            String username2 = (String) session.getAttribute("username");
            System.out.println("aaaaaaaaaaaaaaaaa"+username2);
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://118.25.154.83:3306/esparking"; //数据库名
                String username1 = "root";  //数据库用户名
                String password = "123456";  //数据库用户密码
                Connection conn = DriverManager.getConnection(url, username1, password);  //连接状态
                if(conn != null){
                    Statement stmt = null;
                    ResultSet rs = null;
                    String sql = "SELECT * FROM showfee where username = ?;";  //查询语句
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setString(1,username2);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        String username = rs.getString("username");
                        String car_brand = rs.getString("car_brand");
                        int parking_time = rs.getInt("parking_time");
                        String parking_name = rs.getString("parking_name");
                        String fee = rs.getString("fee");
                        out.print("<tr>");
                        out.print("<td>");
                        out.print(username);
                        out.print("</td>");
                        out.print("<td>");
                        out.print(car_brand);
                        out.print("</td>");
                        out.print("<td>");
                        out.print(parking_time);
                        out.print("</td>");
                        out.print("<td>");
                        out.print(parking_name);
                        out.print("</td>");
                        out.print("<td>");
                        out.print(fee);
                        out.print("</td>");
                        out.print("</tr>");
                    }
                }else{
                    out.print("连接失败！");
                }
            }catch (Exception e) {
                //e.printStackTrace();
                out.print("数据库连接异常！");
            }
        %>
        </tbody>
    </table>
    </div>
    </div>
    </div>
</app>
<!-- JavaScript files-->
<script src="template/vendor/jquery/jquery.min.js"></script>
<script src="template/vendor/popper.js/umd/popper.min.js"></script>
<script src="template/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="template/vendor/jquery.cookie/jquery.cookie.js"></script>
<script src="template/vendor/chart.js/Chart.min.js"></script>
<script src="template/vendor/jquery-validation/jquery.validate.min.js"></script>
<script src="template/js/charts-home.js"></script>
<!-- Main File-->
<script src="template/js/front.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="components.js"></script>
<script src="js/convert.js"></script>
<script src="js/common.js"></script>
<script>
    <!-- Create a Vue app -->
    let app = new Vue({
        el: '#app',
        data: {
            // 用于存储用户的状态
            state: common.defaultAppState(),
            // 用于存储app的信息
            info: {
                title: '模板代码',
                menu: common.template
            },
            // 添加其他需要存储的数据
        },
        methods: {
            init: function () {
                common.getAppState((state) => app.state = state)
                // 添加初始化代码
            }
        }
    })

    window.addEventListener('load', () => {
        for(let i=1;i<document.querySelectorAll('ul > li > a').length;i++){
            let href=document.querySelectorAll('ul > li > a')[i].getAttribute("href")
            console.log(href)
            if(window.location.href === href){
                document.querySelectorAll('ul > li ')[i].setAttribute("class","active")
            }
        }
        app.init();
    });
</script>
</body>
</html>