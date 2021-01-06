<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>人脸注册</title>
		<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
		<link rel="stylesheet" href="css/main.css" />
	</head>
	<body>
		<div class="container">
			<div class="container-fluid centerdiv">
				<!--<form id="loginform" action="Main.html" onsubmit="return check()">-->
				<h2 class="title">Register</h2>
				<p style="text-align: center;">同一个id只能录取同一个人的图片，不要一个人注册多个id,这是demo实际id可以由后台session直接传入</p>
				<p style="text-align: center;">演示的demo，没有实际的用户表所以在前端输入</p>
				<input style="display:block;margin:0 auto" type="text" name="imgId" id="imgId" value="" placeholder="输入用户id"/>
				<div class="login-div cen">
					<div id="face-box">
						<video id="video"></video>
					</div>
					<div id="overflow">
						
					</div>
					<div style="display: none;">
						<canvas id="canvas"></canvas>
					</div>
				</div>
				<!--</form>-->
			</div>
			<br />
			<br />
			<button id="register" type="button" class="btn btn-primary"/>--注册--</button>
		</div>
	</body>
	<script type="text/javascript" src="jquery-3.3.1/jquery-3.3.1.min.js" ></script>
	<script type="text/javascript" src="js/GetFace.js" ></script>
	<script type="text/javascript" src="js/Register.js" ></script>
	<script type="text/javascript" src="js/RegisterAjax.js" ></script>
</html>
