<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<style type="text/css">
    @import url("https://fonts.googleapis.com/css2?family=Fredericka+the+Great&display=swap");

    *{
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    body {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        height: 100vh;
        font-family: sans-serif;
        font-weight: bold;
        background: url("pexels-jiarong-deng-1034662.jpg") no-repeat center center fixed;
        background-size: cover;
    }

    .container {
        background-color: #fff;
        width: 650px;
        border-radius: 50%;
        border: 4px solid #eaf4fb;
    }

    form {
        display: flex;
        flex-direction: column;
        justify-content: center;
        padding: 0px 120px 100px 120px;

    }

    input {
        height: 45px;
        padding: 10px;
        border-radius: 4px;
        border: 1px solid #E6E6F0 ;
        background-color: #FAFAFC;
    }

    input + input {
        margin-top: 15px;
    }

    input::placeholder {
        color: #9C98A6;
    }

    button {
        margin-top: 20px;
        height: 45px;
        background: #f14e54;
        border: 0;
        border-radius: 4px;
        color: #ffffff;
        font-size: 16px;
        font-weight: 600;
        cursor: pointer;
        text-transform: uppercase;
        margin-bottom: 10px;
    }

    .header-text {
        display: flex;
        flex-direction: column;
        margin-top: 10px;
        width: 100%;
        z-index: 2;
        padding: 0px 90px 0px 90px;
    }

    .header-text-logo{
        color: #000;
        margin-bottom: 16px;
        opacity: 1;
        margin-top: 7%;
        margin-bottom: 3%;
        background-size: contain;
        background-repeat: no-repeat;
        background-position: center;
        text-align: center;
        width: 250px;
        margin-left: 23%;
    }

    .header-text-description{
        display: inherit;
        color: #242d34;
        font-size: 2rem;
        font-weight: 400;
        line-height: 24px;
        margin: 25px 0 40px 0;
        align-self: center;
        font-family: 'Fredericka the Great',cursive;
    }
    .choice{
        border: 1px solid black;
    }

</style>

<body>
<div class="container" style="height: 650px;background: rgba(255,255,255,0.5);">
    <div class="header-text" style="margin-top: 50px;">

        <p class="header-text-description">Student Login</p>
    </div>
    <div align="left" style="float: left;display: block;margin-left: 25%; margin-top:3% ;">
        <table> <tr><button type="submit" class="choice" style="border-radius:0px;background-color:rgb(113, 227, 247);color:black;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Account&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button></tr>
            <tr><button  type="submit" class="choice"style="border-radius:0px;background-color:white;color:black;" onclick="window.location.href='index.jsp'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Face ID&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button></tr>
        </table>
    </div>
    <form style="margin-top: 150px;">


        <input type="text"
               placeholder="UserId"
               name="email"
               id="email"
               autofocus>
        <input type="password"
               name="password"
               id="password"
               placeholder="Password"
               required>
        <div align="left" style="float: left;display: block;margin-top: 50px; ">
            <button type="submit" name="login"style="margin-left:15px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Login&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
            <button type="button" name="Register" style="margin-left:40px ;"onclick="window.location.href='http://localhost:8080/SE_design_Web_exploded/inforegist.jsp'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Register&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
        </div>



</form>
</div>
</body>
</html>