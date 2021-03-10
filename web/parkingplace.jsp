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




<html lang="zh-cn">
<head>

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
            <th>车位号</th>
            <th>停车场</th>
            <th>车牌号</th>
            <th>开始停车时间</th>
            <th>结束停车时间</th>
        </tr>
                    </thead>
                    <tbody>
        <%
            request.setCharacterEncoding("utf-8");
            String start=request.getParameter("start");
            String end=request.getParameter("end");
            while(start.length()<10&&start.length()>6)
            {
                if(start.length()==9)
                {
                    if(start.charAt(6)=='-')
                    {
                        StringBuffer sb = new StringBuffer();
                        sb.append(start).insert(5,'0');
                        start=sb.toString();
                    }
                    else
                    {
                        StringBuffer sb = new StringBuffer();
                        sb.append(start).insert(8,'0');
                        start=sb.toString();
                    }
                }
                else
                {
                    StringBuffer sb = new StringBuffer();
                    sb.append(start).insert(5,'0').insert(8,'0');
                    start=sb.toString();
                }
            }
            while(end.length()<10&&end.length()>6)
            {
                if(end.length()==9)
                {
                    if(end.charAt(6)=='-')
                    {
                        StringBuffer sb = new StringBuffer();
                        sb.append(end).insert(5,'0');
                        end=sb.toString();
                    }
                    else
                    {
                        StringBuffer sb = new StringBuffer();
                        sb.append(end).insert(8,'0');
                        end=sb.toString();
                    }
                }
                else
                {
                    StringBuffer sb = new StringBuffer();
                    sb.append(end).insert(5,'0').insert(8,'0');
                    end=sb.toString();
                }
            }
            System.out.println(start);
            System.out.println(end);
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://118.25.154.83:3306/esparking"; //数据库名
            String username1 = "root";  //数据库用户名
            String password = "123456";  //数据库用户密码
            Connection conn = DriverManager.getConnection(url, username1, password);  //连接状态
            try {

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
                        String end_time = null;
                        if(rs.getString("end_time")==null) {end_time=null;}
                        else { end_time=rs.getString("end_time");};
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
                        }else if(end_time == null&&start.compareTo(start_time.substring(0,10))<=0){
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

                        else if(!start_time.equals("null")&&!end_time.isEmpty())
                        {
                            if(start.compareTo(start_time.substring(0,10))<=0&& end.compareTo(end_time.substring(0,10))>=0)
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
                    conn.close();
                }else{
                    out.print("连接失败！");
                }
            }catch (Exception e) {
                e.printStackTrace();
                System.out.print("数据库连接异常！");
                conn.close();
            }finally {

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
<script src="components1.js"></script>
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