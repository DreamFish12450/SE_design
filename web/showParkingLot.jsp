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
        // function draw(id) {
        //     var canvas = document.getElementById(id);
        //     if (canvas == null)
        //         return false;
        //     var context = canvas.getContext('2d');
        //     //context.fillStyle = "#eeefff";
        //     //context.fillRect(0,0,1000,5000);
        //     for (var i = 0; i < 6; i++) {
        //         for (var j = 0; j < 5; j++) {
        //             context.fillStyle = "grey";
        //             context.strokeStyle = "black";
        //             context.lineWidth = 1;
        //             context.fillRect(50 + i * 150, 50 + j * 250, 100, 150);
        //             context.strokeRect(50 + i * 150, 50 + j * 250, 100, 150);
        //         }
        //     }
        //
        // }
        function retu(){
            document.forms[0].action="<%=application.getContextPath()%>/updateParkingTime.do";
            document.forms[0].submit();
        }
        formSubmit = function (){
            $.ajax({
                type: 'post',
                cache: 'false',
                data: {car_number: carNumber,whether_new:temp},
                url: '<%=application.getContextPath()%>/updateParkingTime.do',
                success: function (data) {
                    console.log(data)
                }
            })

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
</head>
<body onload="draw('canvas');">
<h1 align="center">ParkingLot</h1>
<%--<canvas id="canvas" width="1500" height="1500" ></canvas>--%>
<%--<%--%>
<%--session.setAttribute("car_x",1);--%>
<%--session.setAttribute("car_y",3);--%>
<%--%>--%>
<h3>您预订的车位在第<span class="car_x">${sessionScope.car_x}</span>列，第<span class="car_y">${sessionScope.car_y}</span>行</h3>
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
            type:'get',
            cache: false,
            data: {},
            url: '<%=application.getContextPath()%>/initParkingPlace.do',
            success(data){
                console.log(data);
                data.forEach((value)=>{
                    // console.log(value.location_x+"+"+value.location_y)
                    let str = value.location_y+"+"+value.location_x
                    document.getElementById(str).style.background = "SpringGreen"
                    $(document.getElementById(str)).append('<p>空闲</p>')
                })
                let str = $('.car_y').html()+"+"+$('.car_x').html()

                document.getElementById(str).style.background="LightSkyBlue"
                $(document.getElementById(str)).append("<button  class='btn btn-primary' onclick='formSubmit()' >停车完毕</button>")
            }
        })
    }
</script>
</body>
</html>
