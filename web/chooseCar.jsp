<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/1/6
  Time: 21:41
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
<!--<script src="js/Url.js"></script>-->
<body>

<app id="app" :info="info" :state="state">
    <!-- Content -->
    <div class="form-group">
        <div class="input-group">
            <div class="input-group-prepend">
                <div class="input-group-text">
                    <input type="checkbox" class="checkbox-template" name="whether_new" id="whether_new">
                </div>
            </div>
            <input type="text" class="form-control" name="whether_new" disabled="disabled" value="若您对自己的停车没有自信，请勾选右边的框，系统将自动为您选择合适的车位">
        </div>
    </div>
    <script>
        window.test =  document.getElementById("whether_new").checked ? '是' : '否'
    </script>
    <div class="row">
        <c:forEach items="${sessionScope.carList}" var="car">
        <div class="col-lg-4">

                <div class="work-amount card">
                    <div class="card-close">
                        <div class="dropdown">
                            <%--                        <button type="button" id="closeCard1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="dropdown-toggle"><i class="fa fa-ellipsis-v"></i></button>--%>
                            <div aria-labelledby="closeCard1" class="dropdown-menu dropdown-menu-right has-shadow"><a
                                    href="#" class="dropdown-item remove"> <i class="fa fa-times"></i>Close</a><a
                                    href="#" class="dropdown-item edit">
                                <i class="fa fa-gear"></i>Edit</a></div>
                        </div>
                    </div>
                    <div class="card-body">
                        <h3>车牌号是${car.car_number}</h3>
                        <h3>您的车型是:${car.car_model}</h3>
<%--                        <input type="submit" class="btn-primary btn" value="出行" onclick="formSubmit(${car.car_number})">--%>
                        <button  class="btn btn-primary"   onclick="formSubmit(${car.car_number})">出行</button>
                        <div class="chart text-center">
                            <div class="chartjs-size-monitor"
                                 style="position: absolute; inset: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
                                <div class="chartjs-size-monitor-expand"
                                     style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;">
                                    <div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div>
                                </div>
                                <div class="chartjs-size-monitor-shrink"
                                     style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;">
                                    <div style="position:absolute;width:200%;height:200%;left:0; top:0"></div>
                                </div>
                            </div>
                            <%--                        <div class="text"><strong>90</strong><br><span>Hours</span></div>--%>
                            <%--                        <canvas id="pieChart" width="428" height="213" class="chartjs-render-monitor" style="display: block; height: 171px; width: 343px;"></canvas>--%>
                            <c:if test="${car.car_model.equals('轿车')}">
                                <img src="img/car.png" height="200px" width="200px">
                            </c:if>
                            <c:if test="${car.car_model.equals('货车')}">
                                <img src="img/truck.png" height="200px" width="200px">
                            </c:if>

                        </div>
                    </div>
                </div>

        </div>

        </c:forEach>
        <br>
        <div class="col-lg-4">
            <div class="work-amount card">
                <div class="card-close">
                    <div class="dropdown">
                        <div aria-labelledby="closeCard1" class="dropdown-menu dropdown-menu-right has-shadow"><a
                                href="#" class="dropdown-item remove"> <i class="fa fa-times"></i>Close</a><a href="#" class="dropdown-item edit">
                            <i class="fa fa-gear"></i>Edit</a></div>
                    </div>
                </div>
                <div class="card-body">
                    <h3>添加新车</h3>
                    <br>
                    <br>
                    <br>
                    <div id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                         class="modal fade text-left" style="display: none;" aria-hidden="true">
                        <div role="document" class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 id="exampleModalLabel" class="modal-title">请输入相关您爱车的数据</h4>
                                    <button type="button" data-dismiss="modal" aria-label="Close" class="close"><span
                                            aria-hidden="true">×</span></button>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label>车牌号</label>
                                        <input id='car_number' type="text" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label>车辆品牌</label>
                                        <input id='car_brand' type="text" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label>车型</label>
                                        <select name="account" class="form-control mb-3" id="car_model">
                                            <option value="轿车">轿车</option>
                                            <option value="货车">货车</option>
                                            <option value="客车">客车</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <input id="checkboxCustom1" type="checkbox" value="" class="checkbox-template">
                                        <label for="checkboxCustom1">已经拥有驾照</label>
                                    </div>
                                    <div class="form-group">
                                        <button class="btn btn-primary" value="" onclick="insertCar()">注册该车辆</button>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" data-dismiss="modal" class="btn btn-secondary">Close</button>
                                    <button type="button" class="btn btn-primary">Save changes</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="chart text-center">
                        <div class="chartjs-size-monitor"
                             style="position: absolute; inset: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
                            <div class="chartjs-size-monitor-expand"
                                 style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;">
                                <div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div>
                            </div>
                            <div class="chartjs-size-monitor-shrink"
                                 style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;">
                                <div style="position:absolute;width:200%;height:200%;left:0; top:0"></div>
                            </div>
                        </div>
                        <div>
                            <img src="img/addCar.png" height="200px" width="200px" data-toggle="modal"
                                 data-target="#myModal">
                        </div>
                    </div>
                </div>
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
                // common.getAppState((state) => app.state = state)
                // 添加初始化代码
                $.ajax({
                    type: 'post',
                    // ansyv:true,
                    cache: false,
                    data: {},
                    url: '<%=application.getContextPath()%>/listCar.do',
                    success: function (data) {
                        console.log(data)
                        // window.parking = new Array();
                        // data.forEach((value, index) => {
                        //     console.log(value)
                        //     window.parking.push(new Parking(value.parkingName, value.lat, value.lng, value.charges, value.spare, value.maxSize))
                        // })
                    },
                    error: function () {
                    }
                })
            }
        }
    })
    insertCar = () => {
        let carNumber = document.getElementById("car_number").value
        let carBrand = document.getElementById("car_brand").value
        let getPermit = document.getElementById("checkboxCustom1").checked ? '是' : '否'
        let index = document.getElementById("car_model").selectedIndex
        let carModel = document.getElementById("car_model").options[index].value
        $.ajax({
            type: 'post',
            cache: 'false',
            data: {car_number: carNumber, car_brand: carBrand, get_permit: getPermit, car_model: carModel},
            url: '<%=application.getContextPath()%>/addNewCar.do',
            success: function (data) {
                window.location.href('/chooseCar.jsp')
            }
        })
    }
    formSubmit = function (carNumber){
        let index = window.location.href .lastIndexOf("\/")
        let temp = document.getElementById("whether_new").checked?"是":"否"
        let str  =  window.location.href.substring(0,index)
        console.log(str)
        $.ajax({
            type: 'post',
            cache: 'false',
            data: {car_number: carNumber,whether_new:temp},
            url: '<%=application.getContextPath()%>/chooseCar.do',
            success: function (data) {
                window.location.href=str+"/guide.jsp"
            }
        })

    }
    chooseThisCar = (car_number) => {
        <%--$.ajax({--%>
        <%--    type: 'post',--%>
        <%--    // ansyv:true,--%>
        <%--    cache: false,--%>
        <%--    data: {car_number:car_number},--%>
        <%--    url: '<%=application.getContextPath()%>/chooseCar.do',--%>
        <%--    success: function (data) {--%>
        <%--        console.log(data)--%>
        <%--        // window.parking = new Array();--%>
        <%--        // data.forEach((value, index) => {--%>
        <%--        //     console.log(value)--%>
        <%--        //     window.parking.push(new Parking(value.parkingName, value.lat, value.lng, value.charges, value.spare, value.maxSize))--%>
        <%--        // })--%>
        <%--    },--%>
        <%--    error: function () {--%>
        <%--    }--%>
        <%--})--%>
    }
    window.addEventListener('load', () => {
        app.init();
    });
</script>
</body>
</html>