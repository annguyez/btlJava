<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Đăng nhập</title>
<link rel="stylesheet" type="text/css" href="login1.css">
<style type="text/css">
body {
	margin: 0;
	padding: 0;
	background: url(resources/image/thien-nhien.jpg);
	background-size: cover;
	background-repeat: no-repeat;
	font-family: sans-serif;
}

.loginbox {
	width: 320px;
	height: 420px;
	background: #000;
	color: #fff;
	top: 50%;
	left: 50%;
	position: absolute;
	transform: translate(-50%, -50%);
	box-sizing: border-box;
	padding: 70px 30px;
}

.avata {
	width: 100px;
	height: 100px;
	border-radius: 50%;
	position: absolute;
	top: -50px;
	left: calc(50% - 50px);
}

h1 {
	margin: 0;
	padding: 0 0 20px;
	text-align: center;
	font-size: 22px;
}

.loginbox p {
	margin: 0;
	padding: 0;
	font-weight: bold;
}

.loginbox input {
	width: 100%;
	margin-bottom: 20px;
}

.loginbox input[type="text"], input[type="password"] {
	border: none;
	border-bottom: 1px solid #fff;
	background: transparent;
	outline: none;
	height: 40px;
	color: #fff;
	font-size: 16px;
}

.loginbox input[type="submit"] {
	border: none;
	outline: none;
	height: 40px;
	background: #fb2525;
	color: #fff;
	font-size: 18px;
	border-radius: 20px;
}

.loginbox input[type="submit"]:hover {
	cursor: pointer;
	background: #ffc107;
	color: #000;
}

.loginbox a {
	text-decoration: none;
	font-size: 12px;
	line-height: 20px;
	color: darkgray;
}

.loginbox a:hover {
	color: #ffc107;
}
</style>
</head>
<body>
	<div class="loginbox">
		<img src="resources/image/thien-nhien.jpg" alt="avata" class="avata">
		<h1>Đăng nhập</h1>
		<form action='<c:url value="/login"></c:url>' method="post">
			<p>Tên đăng nhập</p>
			<input type="text" name="username" placeholder="Nhập tên đăng nhập">
			<p>Mật khẩu</p>
			<input type="password" name="password" placeholder="Nhập mật khẩu ">
			<input type="submit" name="" value="Đăng nhập"> 
			
		    <p style="color: white">${message}</p>
		</form>
	</div>
</body>
</html>


