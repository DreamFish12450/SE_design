<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zdj
  Date: 2021/1/9
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title style：text-align：center>ParkingLot</title>
    <script>
        function draw(id)
        {
            var canvas = document.getElementById(id);
            if(canvas == null)
                return false;
            var context = canvas.getContext('2d');
            //context.fillStyle = "#eeefff";
            //context.fillRect(0,0,1000,5000);
            for (var i=0;i<6;i++)
            {
                for (var j=0;j<5;j++)
                {
                    context.fillStyle = "grey";
                    context.strokeStyle = "black";
                    context.lineWidth = 1;
                    context.fillRect(50+i*150,50+j*250,100,150);
                    context.strokeRect(50+i*150,50+j*250,100,150);
                }
            }

        }
    </script>
</head>
<body onload="draw('canvas');">
<h1 align="center">ParkingLot</h1>
<%--<canvas id="canvas" width="1500" height="1500" ></canvas>--%>
<c:forEach  var="s" begin="1" end="5">
    <c:forEach var="s2" begin="1" end="6">
        <div  class="box" id="${s}+${s2}" style=" display:inline-block;background-color:grey;width: 100px;height: 150px;margin: 50px" >
<%--                                <c:out value="${s}+${s2}"/>--%>
        </div>
    </c:forEach>
    <br>
    <!-- 这个是输出的标签，相当于System.out.println(s); -->
</c:forEach>
</body>
</html>
