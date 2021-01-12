<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/1/10
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<%--    <jsp:useBean id="str" scope="request" type="java.util.List"/>--%>
    <c:forEach  var="s" begin="1" end="5">
        <c:forEach var="s2" begin="1" end="6">
            <div  class="box" id="${s}+${s2}" style=" display:inline-block;background-color: red;width: 30px;height: 30px;margin: 3px" >
<%--                <c:out value="${s}+${s2}"/>--%>
                <br>
            </div>
        </c:forEach>
        <!-- 这个是输出的标签，相当于System.out.println(s); -->
    </c:forEach>
</body>
</html>
