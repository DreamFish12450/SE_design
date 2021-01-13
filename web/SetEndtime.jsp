<%--
  Created by IntelliJ IDEA.
  User: 孤独之星
  Date: 2021/1/11
  Time: 14:54
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
    <div class="card">
        <div class="card-header d-flex align-items-center">
            <h3 class="h4">手动设置结束时间</h3>
        </div>
        <div class="card-body" style="margin: 10px">
            <form action="setend_time.jsp"method="post" >

                <div class="form-group">
                    <label class="form-control-label">车牌号</label>
                    <input type="text" name="car_number" id="car_number" class="form-control">

                </div>

                <div class="form-group">
                    <input type="submit" value="确认结束" class="btn btn-primary">
                </div>
            </form>
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