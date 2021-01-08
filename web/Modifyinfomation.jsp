<%--
  Created by IntelliJ IDEA.
  User: 孤独之星
  Date: 2021/1/7
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改工作人员信息</title>
</head>
<body>
<form action="addpersonnel.jsp"method="post" name="re">
    ID
    <input type="text" name="ID" id="ID">
    <br/>
    姓名
    <input type="text" name="name" id="name">
    <br/>
    年龄
    <input type="text" name="age" id="age">
    <br/>
    性别
    <input type="text" name="sex" id="sex">
    <br/>
    身份证号码
    <input type="text" name="ID_number" id="ID_number">
    <br/>
    电话号码
    <input type="text" name="phone_number" id="phone_number">
    <br/>
    地址
    <input type="text" name="address" id="address">
    <br/>
    工作岗位
    <input type="text" name="post" id="post">
    <br/>
    <input type="submit"  name="Submit" value="添加" >
</form>

</body>

</html>