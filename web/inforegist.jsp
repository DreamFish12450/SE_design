<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/6
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <title>注册</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title></title>
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


<div class="page-content d-flex align-items-stretch">
    <!-- Forms Section-->
    <section class="forms" style="width:60%;margin-left: 35%;">
        <div class="container-fluid">
            <div class="row">
                <!-- Basic Form-->
                <div class="col-lg-6">
                    <div class="card">
                        <div class="card-close">
                            <div class="dropdown">
                                <button type="button" id="closeCard1" data-toggle="dropdown"
                                        aria-haspopup="true" aria-expanded="false" class="dropdown-toggle"><i
                                        class="fa fa-ellipsis-v"></i></button>
                                <div aria-labelledby="closeCard1"
                                     class="dropdown-menu dropdown-menu-right has-shadow"><a href="#"
                                                                                             class="dropdown-item remove">
                                    <i class="fa fa-times"></i>Close</a><a href="#" class="dropdown-item edit">
                                    <i class="fa fa-gear"></i>Edit</a></div>
                            </div>
                        </div>
                        <div class="card-header d-flex align-items-center">
                            <h3 class="h4">个人信息 注册页面</h3>
                        </div>
                        <div class="card-body">
                            <p>以下信息为用户必填项</p>
                            <form action="Register" method="post" >
                                <div class="form-group">
                                    <label class="form-control-label">用户名</label>
                                    <input type="text" name="username" placeholder="username" class="form-control" maxlength="5" required>
<%--                                    <small>用户名长度小于5</small>--%>
                                </div>
                                <div class="form-group">
                                    <label class="form-control-label">密码</label>
                                    <input type="password"  name="password" placeholder="密码" class="form-control" maxlength="15" required>
                                </div>
                                <div class="form-group">
                                    <label class="form-control-label">姓名</label>
                                    <input type="text" name="name" placeholder="name" class="form-control" maxlength="15" required>
                                </div>
                                <div class="form-group">
                                    <label class="form-control-label">年龄</label>
                                    <input type="text" name="age" placeholder="age" class="form-control" maxlength="3" required>
                                </div>
                                <div class="form-group">
                                    <label class="form-control-label">性别</label>
                                    <div class="form-group row" style="margin-left: 30%">

                                        <div class="col-sm-9">
                                            <label class="checkbox-inline" style="margin-right: 20%">
                                                <input id="inlineRadio1" name="radio1" type="radio" value="true" > 男
                                            </label>
                                            <label class="checkbox-inline">
                                                <input id="inlineRadio2" name="radio1" type="radio" value="false"> 女
                                            </label>

                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="form-control-label">身份证</label>
                                    <input type="text" name="ID_number" placeholder="ID_number" class="form-control" maxlength="20" required>
                                </div>
                                <div class="form-group">
                                    <label class="form-control-label">电话</label>
                                    <input type="text"name="phone_number" placeholder="phone_number" class="form-control"maxlength="13" required>
                                </div>
                                <div class="form-group" style="margin-left: 40%">
                                    <input type="submit" value="Sign up" class="btn btn-primary" >
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

</div>
</body>
<script src="template/vendor/jquery/jquery.min.js"></script>
<script src="template/vendor/popper.js/umd/popper.min.js"></script>
<%--<script src="template/vendor/bootstrap/js/bootstrap.min.js"></script>--%>
<script src="template/vendor/jquery.cookie/jquery.cookie.js"></script>
<script src="template/vendor/chart.js/Chart.min.js"></script>
<script src="template/vendor/jquery-validation/jquery.validate.min.js"></script>
<!-- Main File-->
<script src="template/js/front.js"></script>
</html>
