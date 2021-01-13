<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/6
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Home</title>
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
<script src="js/Url.js"></script>
<style>
    .number {
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
    }
</style>

<body>
<app id="app" :info="info" :state="state">
    <!-- Dashboard Counts Section-->
    <section class="dashboard-counts no-padding-bottom">
        <div class="container-fluid">
            <div class="row bg-white has-shadow">
                <!-- Item -->
                <div class="col-xl-3 col-sm-6">
                    <div class="item d-flex align-items-center">
                        <div class="icon bg-violet"><i class="icon-user"></i></div>
                        <div class="title"><span>用户<br>姓名</span>
                            <div class="progress">
                                <div role="progressbar" style="width: 25%; height: 4px;" aria-valuenow="25"
                                     aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-violet"></div>
                            </div>
                        </div>
                        <div class="number"><strong><%=session.getAttribute("username")%>
                        </strong></div>
                    </div>
                </div>
                <!-- Item -->
                <div class="col-xl-3 col-sm-6">
                    <div class="item d-flex align-items-center">
                        <div class="icon bg-red"><i class="icon-padnote"></i></div>
                        <div class="title"><span>电话<br>号码</span>
                            <div class="progress">
                                <div role="progressbar" style="width: 70%; height: 4px;" aria-valuenow="70"
                                     aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-red"></div>
                            </div>
                        </div>
                        <div class="number" title="${sessionScope.phone_number}"><strong><%=session.getAttribute("phone_number")%>
                        </strong></div>
                    </div>
                </div>
                <!-- Item -->
                <div class="col-xl-3 col-sm-6">
                    <div class="item d-flex align-items-center">
                        <div class="icon bg-green"><i class="icon-bill"></i></div>
                        <div class="title"><span>用户<br>密码</span>
                            <div class="progress">
                                <div role="progressbar" style="width: 40%; height: 4px;" aria-valuenow="40"
                                     aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-green"></div>
                            </div>
                        </div>
                        <div class="number"><strong>*********</strong></div>
                    </div>
                </div>
                <!-- Item -->
                <div class="col-xl-3 col-sm-6">
                    <div class="item d-flex align-items-center">
                        <div class="icon bg-orange"><i class="icon-check"></i></div>
                        <div class="title"><span>身份<br>证号</span>
                            <div class="progress">
                                <div role="progressbar" style="width: 50%; height: 4px;" aria-valuenow="50"
                                     aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-orange"></div>
                            </div>
                        </div>
                        <div class="number" title="${sessionScope.ID_number}"><strong><%=session.getAttribute("ID_number")%>
                        </strong></div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section class="dashboard-counts no-padding-bottom">
        <div class="container-fluid">
            <div class="row bg-white has-shadow">

                <!-- Item -->
                <div class="col-xl-3 col-sm-6">
                    <div class="item d-flex align-items-center">
                        <div class="icon bg-red"><i class="icon-padnote"></i></div>
                        <div class="title"><span>用户<br>年龄</span>
                            <div class="progress">
                                <div role="progressbar" style="width: 70%; height: 4px;" aria-valuenow="70"
                                     aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-red"></div>
                            </div>
                        </div>
                        <div class="number"><strong><%=session.getAttribute("age")%>
                        </strong></div>
                    </div>
                </div>
                <!-- Item -->
                <div class="col-xl-3 col-sm-6">
                    <div class="item d-flex align-items-center">
                        <div class="icon bg-violet"><i class="icon-user"></i></div>
                        <div class="title"><span>真实<br>姓名</span>
                            <div class="progress">
                                <div role="progressbar" style="width: 25%; height: 4px;" aria-valuenow="25"
                                     aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-violet"></div>
                            </div>
                        </div>
                        <div class="number" title="${sessionScope.name}"><strong><%=session.getAttribute("name")%>
                        </strong></div>
                    </div>
                </div>                <!-- Item -->

                <!-- Item -->
                <div class="col-xl-3 col-sm-6">
                    <div class="item d-flex align-items-center">
                        <div class="icon bg-orange"><i class="icon-check"></i></div>
                        <div class="title"><span>用户<br>余额</span>
                            <div class="progress">
                                <div role="progressbar" style="width: 50%; height: 4px;" aria-valuenow="50"
                                     aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-orange"></div>
                            </div>
                        </div>
                        <div class="number" title="${sessionScope.balance}"><strong><%=session.getAttribute("balance")%>
                        </strong></div>
                    </div>
                </div>
                <div class="col-xl-3 col-sm-6">
                    <div class="item d-flex align-items-center">
                        <div class="icon bg-green"><i class="icon-bill"></i></div>
                        <div class="title"><span>用户<br>性别</span>
                            <div class="progress">
                                <div role="progressbar" style="width: 40%; height: 4px;" aria-valuenow="40"
                                     aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-green"></div>
                            </div>
                        </div>
                        <div class="number"><strong><%=session.getAttribute("sex")%>
                        </strong></div>
                    </div>
                </div>
            </div>
        </div>
    </section>    <!-- Dashboard Header Section    -->
    <section class="dashboard-header">
        <div class="container-fluid">
            <div class="row">

                <div class="chart col-lg-3 col-12" style="height: 400px">
                    <!-- Bar Chart   -->
                    <div class="bar-chart has-shadow bg-white" style="height: 400px">
                        <div class="renewal-icon">
                            <img src="./img/set.png"
                                 style="width: 40%;height:40%;text-align: center;margin-left:30%;margin-top: 20%;"/>
                        </div>
                        <div class="title"><strong class="text-violet"></strong><br><small></small></div>
                        <canvas id="barChartHome1"></canvas>
                    </div>
                    <div class="card-body text-center">
                        <button type="button" data-toggle="modal" data-target="#myModal"
                                class="btn btn-primary" style="margin-top: -300px">&nbsp;修 改 密 码&nbsp;
                        </button>
                        <!-- Modal-->


                    </div>

                </div>
                <div class="chart col-lg-3 col-12" style="height: 400px">
                    <!-- Bar Chart   -->
                    <div class="bar-chart has-shadow bg-white" style="height: 400px">
                        <div class="renewal-icon">
                            <img src="./img/my.png"
                                 style="width: 40%;height:40%;text-align: center;margin-left:30%;margin-top: 20%;"/>
                        </div>
                        <div class="title"><strong class="text-violet"></strong><br><small></small></div>
                        <canvas id="barChartHome2"></canvas>
                    </div>
                    <div class="card-body text-center">
                        <button type="button" data-toggle="modal" data-target="#myModal"
                                class="btn btn-primary" style="margin-top: -300px">&nbsp;修 改 电 话&nbsp;
                        </button>
                        <!-- Modal-->

                    </div>
                </div>
                <div class="chart col-lg-3 col-12" style="height: 400px">
                    <!-- Bar Chart   -->
                    <div class="bar-chart has-shadow bg-white" style="height: 400px">
                        <div class="renewal-icon">
                            <img src="./img/3.png"
                                 style="width: 40%;height:40%;text-align: center;margin-left:30%;margin-top: 20%;"></img>
                        </div>
                        <div class="title"><strong class="text-violet"></strong><br><small></small></div>
                        <canvas id="barChartHome5"></canvas>
                    </div>
                    <div class="card-body text-center">
                        <button type="button" data-toggle="modal" data-target="#myModal" style="margin-top: -300px"
                                class="btn btn-primary">&nbsp;绑 定 人 脸 &nbsp;
                        </button>
                        <!-- Modal-->

                    </div>
                </div>
                <div class="chart col-lg-3 col-12" style="height: 400px;background-color: #f6f6f6">
                    <!-- Bar Chart   -->

                    <div class="bar-chart has-shadow bg-white" style="height: 400px;background-color: #f6f6f6">
                        <div class="renewal-icon">
                            <img src="./img/1.png"
                                 style="width: 40%;height:40%;text-align: center;margin-left:30%;margin-top: 20%;"></img>
                        </div>
                        <div class="title"><strong class="text-violet"></strong><br><small></small></div>
                        <canvas id="barChartHome4"></canvas>

                    </div>


                    <div class="card-body text-center">

                        <button type="button" data-toggle="modal" data-target="#myModal" style="margin-top: -300px"
                                class="btn btn-primary">&nbsp;修 改 用 户 名&nbsp;
                        </button>
                        <!-- Modal-->

                    </div>
                </div>
            </div>
        </div>
    </section>


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
                title: '主页',
                menu: common.index
            },
            // books: [{
            // 	cover: 'cover',
            // 	isbn: 'isbn',
            // 	price: 'price',
            // 	name: 'name'
            // }]
        },
        methods: {
            init: function () {
                common.getAppState((state) => app.state = state)
                // request(URL.ListBook, '',  (res) => {
                // 	console.log(res)
                // 	app.books = res.data;
                // 	convert.books(app.books)
                // })
            }
        }
    })

    window.addEventListener('load', () => {
        for (let i = 1; i < document.querySelectorAll('ul > li > a').length; i++) {
            let href = document.querySelectorAll('ul > li > a')[i].getAttribute("href")
            console.log(href)
            if (window.location.href === href) {
                document.querySelectorAll('ul > li ')[i].setAttribute("class", "active")
            }
        }
        app.init();
    });
</script>
</body>
</html>