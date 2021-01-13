<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>ParkingLot</title>
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
    <script type="text/javascript" src="jquery-3.3.1/jquery-3.3.1.min.js" ></script>
    <script>

        function retu(){
            document.forms[0].action="updatePickUpTime.do";
            document.forms[0].submit();
        }
    </script>
    <style>
        .wrapper{
            /*width:450px;*/

            background: #e5e5e5;
            text-align:center;
            /*display: inline-grid;*/
            display: grid;
            grid-template-columns: repeat(5,20%);
            grid-template-rows: repeat(6,200px);
        }
        .box{
            border:1px solid #fff;
            color:#fff;
            margin: 0 auto;
        }
    </style>
    <script src="template/vendor/jquery/jquery.min.js"></script>
    <script src="template/vendor/popper.js/umd/popper.min.js"></script>
    <script src="template/vendor/jquery.cookie/jquery.cookie.js"></script>
    <script src="template/vendor/chart.js/Chart.min.js"></script>
    <script src="template/vendor/jquery-validation/jquery.validate.min.js"></script>
    <script src="template/js/charts-home.js"></script>
    <script src="template/js/front.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
</head>
<body onload="draw('canvas');">
<form action="" method="post">
<h1 align="center">ParkingLot</h1>


<h3>您预订的车位在第<span class="car_x">${sessionScope.car_x}</span>列，第<span class="car_y">${sessionScope.car_y}</span>行</h3>
    <h3>推荐路线：从此出入口向前驶<span class="car_x">${(sessionScope.car_x*2-0.5)*2.5}></span>米后右转，然后直行<span class="car_y">${(sessionScope.car_y-0.5)*5}</span>米后车位在你的右方</h3>
    <span class="parking_id" style="visibility: hidden">${sessionScope.parking_id}</span>
    <span class="username" style="visibility: hidden">${sessionScope.username}</span>
    <span class="parkingplace_id" style="visibility: hidden">${sessionScope.plid}</span>
    <span class="car_number" style="visibility: hidden">${sessionScope.car_number}</span>
    <button class="btn btn-primary" onclick="gotoHome()" id="go_to_btn" style="visibility: hidden">回到首页</button>
    <div class="wrapper">
    <c:forEach var="s" begin="1" end="6">
        <c:forEach var="s2" begin="1" end="5">
            <div class="box" id="${s}+${s2}"
                 style=" display:inline-block;background-color:grey;width: 150px;height: 170px;">
                    <%--                                <c:out value="${s}+${s2}"/>--%>
            </div>
        </c:forEach>
<%--        <br>--%>
        <!-- 这个是输出的标签，相当于System.out.println(s); -->
    </c:forEach>
    </div>
<script>
    window.onload = function (){
        $.ajax({
                type: 'get',
                cache: false,
                data: {},
                url: '<%=application.getContextPath()%>/initParkingPlace.do',
                success(data) {
                    console.log(data);
                    data.forEach((value) => {
                        // console.log(value.location_x+"+"+value.location_y)
                        let str = value.location_y + "+" + value.location_x
                        document.getElementById(str).style.background = "SpringGreen"
                        $(document.getElementById(str)).append('<p>空闲</p>')
                    })
                }
            })
            //String parkingId,int parkingplace_id,String username,String car_number
            let str = $('.car_y').html() + "+" + $('.car_x').html()
            //alert(str);
            document.getElementById(str).style.background = "LightSkyBlue";
            $(document.getElementById(str)).append("<button id='btn'  class='btn btn-primary' onclick='testupdate()' >取车完毕</button>");

    }
    gotoHome = ()=>{
        let index = window.location.href.lastIndexOf("\/")
        let str = window.location.href.substring(0, index)
        window.location.href = str +'/home.jsp'
    }
    testupdate = function () {
        let username = $('.username').html();
        let car_number = $('.car_number').html();
        let parking_id = $(".parking_id").html();
        let parkingplace_id = $(".parkingplace_id").html();
        console.log("1111"+username + car_number + parking_id + parkingplace_id)
        $.ajax({
            async:false,
            type: 'post',
            cache: 'false',
            data: {username: username, car_number: car_number, parking_id: parking_id,parkingplace_id:parkingplace_id},
            url: '<%=application.getContextPath()%>/updatePickUpTime.do',
            success: function (data) {
                // alert(data)
                let index = window.location.href.lastIndexOf("\/")
                let str = window.location.href.substring(0, index)
                if(data === "\"finish\"")  {
                    document.getElementById('btn').style.display='none'
                    document.getElementById('go_to_btn').style.visibility='visible'
                    alert('缴费成功');
                    setTimeout("javascript:location.href='home.jsp'", 0);
                    // location.assign()
                    window.event.returnValue = false

                }
                else if(data === "\"unfinished\"") {
                    setTimeout("javascript:location.href='charge..jsp'", 0);
                    // location.assign()
                    
                    window.event.returnValue = false
                }
            },
            error:function (data){
                alert(data)
            }
        })
    }
</script>
</form>
</body>
</html>
