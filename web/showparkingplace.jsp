
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
    <title>按日期查询车位信息</title>
</head>
<body>
<style type="text/css">
    #table thead, #table-3 tr {
        border-top-width: 1px;
        border-top-style: solid;
        border-top-color: rgb(235, 242, 224);
    }
    #table {
        border-bottom-width: 1px;
        border-bottom-style: solid;
        border-bottom-color: rgb(235, 242, 224);
    }

    /* Padding and font style */
    #table td, #table th {
        padding: 15px 75px;
        font-size: 12px;
        font-family: Verdana;
        color: rgb(33, 38, 24);
    }

    /* Alternating background colors */
    #table tr:nth-child(even) {
        background: rgb(169, 169, 169)
    }
    #table tr:nth-child(odd) {
        background: #FFF
    }
    #submit { width:143px; height:40px; color:#132461; }
</style>
<form action="parkingplace.jsp"method="post" >
    <table id="table">
        <tr>
            <th>时间格式：年-月-日 时：分：秒</th>
        </tr>
        <tr>
            <td>开始时间</td>
            <td><input type="text" name="start" id="start"></td>
        </tr>
        <tr>
            <td>结束时间</td>
            <td><input type="text" name="end" id="end"></td>
        </tr>


    </table>
    <tr><input type="submit"  name="Submit" value="查询" id="submit"></tr>
</form>
</body>
</html>
