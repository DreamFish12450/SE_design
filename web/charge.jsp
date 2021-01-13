<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/1/8
  Time: 19:20
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
    <style>
        *[class*="icon-"] {
            -webkit-transform: translateY(4px);
            transform: translateY(4px);
        }
    </style>
</head>
<!--<script src="js/Url.js"></script>-->
<body>
<app id="app" :info="info" :state="state">
    <!-- Content -->
    <div class="col-lg-6" style="min-width: 100%;flex: 0 0 100%;margin-top:30px ">
        <div class="card">
            <div class="card-close">
                <div class="dropdown">
                    <button type="button" id="closeCard1" data-toggle="dropdown" aria-haspopup="true"
                            aria-expanded="false" class="dropdown-toggle"><i class="fa fa-ellipsis-v"></i></button>
                    <div aria-labelledby="closeCard1" class="dropdown-menu dropdown-menu-right has-shadow"><a href="#"
                                                                                                              class="dropdown-item remove">
                        <i class="fa fa-times"></i>Close</a><a href="#" class="dropdown-item edit"> <i
                            class="fa fa-gear"></i>Edit</a></div>
                </div>
            </div>
            <div class="card-header d-flex align-items-center">
                <h3 class="h4">个人信息</h3>
            </div>
            <div class="card-body">
                <p>您的账户余额是<span id="balance">${sessionScope.balance}</span></p>
                <p>您已充值<span>${sessionScope.totalMoney}</span></p>
                <p>您当前的VIP等级是<span>${sessionScope.VIP_level}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span
                        data-toggle="modal" data-target="#myModal" class="btn btn-primary">查看详情</span></p>
                <div id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true"
                     class="modal fade text-left">
                    <div role="document" class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 id="exampleModalLabel" class="modal-title">VIP详情</h4>
                                <button type="button" data-dismiss="modal" aria-label="Close" class="close"><span
                                        aria-hidden="true">×</span></button>
                            </div>
                            <div class="modal-body">
                                <p>VIP详情</p>
                                <p>总冲销金额1~100为0级会员</p>
                                <p>总冲销金额100~200为1级会员</p>
                                <p>总冲销金额200~300为2级会员</p>
                                <p>总冲销金额300~400为3级会员</p>
                                <p>总冲销金额400~600为4级会员</p>
                                <p>总冲销金额600~800为5级会员</p>
                                <p>总冲销金额800~1000为6级会员</p>
                                <p>总冲销金额1000以上为7级会员</p>
                            </div>
                            <div class="modal-footer">
                                <button type="button" data-dismiss="modal" class="btn btn-secondary">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="form-control-label">输入您的用户密码</label>
                    <input type="password" placeholder="Password" class="form-control" id="pass">
                    <div class="invalid-feedback" id="invalid-div"></div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-prepend"><span class="input-group-text">￥</span></div>
                        <input type="text" class="form-control" id="amount">
                        <div class="input-group-append"><span class="input-group-text">.00</span></div>
                    </div>
                </div>
                <div class="form-group">
                    <button class="btn-primary btn" onclick="chargeMoney()">充值</button>
                </div>
            </div>
            <section class="dashboard-counts no-padding-bottom">

                <div class="container-fluid">
                    <h3>VIP享受的特权</h3>
                    <div class="row bg-white has-shadow">

                        <div class="col-xl-3 col-sm-6">
                            <div class="item d-flex align-items-center">
                                <div class="icon bg-violet"><i class="icon-user"></i></div>
                                <div class="title"><span>专人<br>服务</span>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-sm-6">
                            <div class="item d-flex align-items-center">
                                <div class="icon bg-red"><i class="icon-padnote"></i></div>
                                <div class="title"><span>停车<br>打折</span>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-sm-6">
                            <div class="item d-flex align-items-center">
                                <div class="icon bg-green"><i class="icon-bill"></i></div>
                                <div class="title"><span>拒绝<br>广告</span>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-sm-6">
                            <div class="item d-flex align-items-center">
                                <div class="icon bg-orange"><i class="icon-check"></i></div>
                                <div class="title"><span>冲销<br>奖励</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
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
    chargeMoney = ()=>{
        let password = document.getElementById('pass').value
        let amount = document.getElementById('amount').value
        if(amount === ""){
            document.getElementById('pass').classList.add("is-invalid")
            document.getElementsByClassName('invalid-feedback')[0].innerHTML = '请输入金额'
            return
        }

        $.ajax({
            type: 'post',
            cache: 'false',
            data: {pass: password, amount:amount},
            url: '<%=application.getContextPath()%>/charge.do',
            success: function (data) {
                alert(data)
                if(data==='no'){
                    let index = window.location.href .lastIndexOf("\/")
                    let str  =  window.location.href.substring(0,index)
                    window.location.href=str+'/charge.jsp'
                }else {
                    document.getElementById('pass').classList.add("is-invalid")
                    document.getElementsByClassName('invalid-feedback')[0].innerHTML = data;
                }

            }
        })
    }
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
            }
        },
        component: {}
    })

    window.addEventListener('load', () => {
        for(let i=1;i<document.querySelectorAll('ul > li > a').length;i++){
            let href=document.querySelectorAll('ul > li > a')[i].getAttribute("href")
            console.log(href)
            if(window.location.href === href){
                document.querySelectorAll('ul > li ')[i].setAttribute("class","active")
            }
        }
    });
</script>
</body>
</html>

