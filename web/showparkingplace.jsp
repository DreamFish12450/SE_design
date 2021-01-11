

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
            <h3 class="h4">根据日期查询车位记录</h3>
        </div>
        <div class="card-body" style="margin: 10px">
    <form action="parkingplace.jsp"method="post" >

            <div class="form-group">
            <label class="form-control-label">开始时间</label>
            <input type="text" name="start" id="start" class="form-control">
                <small>时间格式：年-月-日 时：分：秒</small>
            </div>
            <div class="form-group">
            <label class="form-control-label">结束时间</label>
            <input type="text" name="end" id="end" class="form-control">
             </div>

        <div class="form-group">
            <input type="submit" value="查询" class="btn btn-primary">
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
        app.init();
    });
</script>
</body>
</html>