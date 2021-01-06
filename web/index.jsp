<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>人脸识别登录</title>
		<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
		<link rel="stylesheet" href="css/main.css" />
		<style>
			.container1 {
			background-color: #fff;
			width: 650px;
			border-radius: 50%;
			border: 4px solid #eaf4fb;
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
		</style>
	</head>
	<body>
		<div class="container1" style="height: 650px;background: rgba(255,255,255,0.5);">
		<div class="container ">
			<div class="container-fluid centerdiv"style="margin-left:-45%;">
				<!--<form id="loginform" action="Main.html" onsubmit="return check()">-->
				
				<div class="login-div cen">
					<div id="face-box" style="margin-top: 50%;">
						<video id="video"></video>
					</div>
					<div id="overflow">
						
					</div>
					<div style="display: none;">
						<canvas id="canvas"></canvas>
					</div>
				</div>
				<h1 class="title" style="color: black;">Login</h1>
				<!--</form>-->
			</div>
		</div>
	</div>

	</body>
	<script type="text/javascript" src="jquery-3.3.1/jquery-3.3.1.min.js" ></script>
	<script type="text/javascript" src="js/GetFace.js" ></script>
	<script type="text/javascript" src="js/Login.js" ></script>
	<script type="text/javascript" src="js/LoginAjax.js" ></script>
</html>
