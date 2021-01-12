<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<!DOCTYPE html>
<style>
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
	.container1 {
		background-color: #fff;
		width: 650px;
		border-radius: 50%;
		border: 4px solid #eaf4fb;
	}

</style>
<html>
<head>


	<meta charset="utf-8" />

	<title>人脸注册</title>
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
	<link rel="stylesheet" href="css/main.css" />
</head>
<body>
<div class="container1" style="height: 650px;background: rgba(255,255,255,0.5);">
	<div class="container">
		<div class="container-fluid centerdiv" style="margin-left:-45%;">
			<!--<form id="loginform" action="Main.html" onsubmit="return check()">-->

			<div class="login-div cen">
				<div id="face-box" style="margin-top: 30%;">
					<video id="video"></video>
				</div>
				<div id="overflow">

				</div>
				<div style="display: none;">
					<canvas id="canvas"></canvas>
				</div>
			</div>
			<h2 class="title">Register</h2>

			<input style="display:block;margin:0 auto" type="text" name="imgId" id="imgId" disabled value="<%=session.getAttribute("username")%>" placeholder="username"/>
			<!--</form>-->
		</div>
		<br />
		<br />
		<button id="register" type="button" class="btn btn-primary" style="margin-left: 24%;">&nbsp;  注册&nbsp;  </button>
	</div>
</div>
</body>
<script type="text/javascript" src="jquery-3.3.1/jquery-3.3.1.min.js" ></script>
<script type="text/javascript" src="js/GetFace.js" ></script>
<script type="text/javascript" src="js/Register.js" ></script>
<script type="text/javascript" src="js/RegisterAjax.js" ></script>
</html>