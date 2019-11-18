<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Create Account</title>
<charset="UTF-8">
<style type="text/css">
body {
	margin: 0;
	padding: 0;
	background: url(resources/image/thien-nhien.jpg);
	background-size: cover;
	background-repeat: no-repeat;
	font-family: sans-serif;
}

.signup {
	width: 370px;
	height: 580px;
	background: #000;
	color: #fff;
	top: 50%;
	left: 50%;
	position: absolute;
	transform: translate(-50%, -50%);
	box-sizing: border-box;
	padding: 40px 30px;
}

h1 {
	margin: 0;
	padding: 0 0 20px;
	text-align: center;
	font-size: 22px;
}

.signup p {
	margin: 0;
	padding: 0;
	font-weight: bold;
}

.signup input {
	width: 100%;
	margin-bottom: 20px;
}

.signup input[type="text"], input[type="password"] {
	border: none;
	border-bottom: 1px solid #fff;
	background: transparent;
	outline: none;
	height: 30px;
	color: #fff;
	font-size: 16px;
}

.signup input[type="submit"] {
	border: none;
	outline: none;
	height: 40px;
	background: #fb2525;
	color: #fff;
	font-size: 18px;
	border-radius: 20px;
}

.signup input[type="submit"]:hover {
	cursor: pointer;
	background: #ffc107;
	color: #000;
}

.cannel a {
	text-decoration: none;
	font-size: 30px;
	line-height: 20px;
	color: darkgray;
	text-align: center;
	text-align: center;
	padding: 5px 10px;
	top: 5px;
	position: absolute;
}

.cannel:hover {
	background-color: #ffc107;
}

.cannel {
	width: 40px;
	height: 40px;
	position: absolute;
	right: 0px;
	top: 0px;
	background-color: #fb2525;
}

.cannel a:hover {
	color: #fff;
}
</style>
<script type="text/javascript">
	function checkinput() {
		var data1 = document.getElementById("name").value;
		var data2 = document.getElementById("pass").value;
		var data3 = document.getElementById("cfpassword").value;
		var data4 = document.getElementById("email").value;
		var data5 = document.getElementById("phone").value;
		var data = "qwertyuiopasdfghjklzxcvbnm";
		var mail = document.all.email.value;
		var acong = mail.indexOf("@");
		var dodai = mail.length - 1;
		var daucham = mail.lastIndexOf(' ');
		if (data1 == "") {
			alert("Vui lòng điền đầy đủ thông tin");
			return false;
		}
		if (data2 == "") {
			alert("Vui lòng điền đầy đủ thông tin");
			return false;
		}
		if (data3 == "") {
			alert("Vui lòng điền đầy đủ thông tin");
			return false;
		} else {
			if (data2 != data3) {
				alert("Vui lòng điền đầy đủ thông tin");
				return false;
			}
		}
		if (data4 == "") {
			alert("Vui lòng điền đầy đủ thông tin");
			return false;
		}

		if (data5 == "") {
			alert("Vui lòng điền đầy đủ thông tin");
			return false;
		} else {
			for (var i = 0; i <= data5.length; i++) {
				if (data.indexOf(data5.charAt(i)) > -1) {
					alert("Chỉ được nhập kiểu số");

				}
				return false;
			}
		}
		return false;
	}
</script>
</head>
<body>
	<div class="signup">
		<div class="cannel">
			<a href="/BTLJavaWeb/Login_account.jsp">X</a>
		</div>
		<h1>Sign up</h1>
		<form action="add_login" method="post">
			<p>Yourname</p>
			<input type="text" name="fullname" placeholder="Enter Yourname"
				id="name">
			<p>Usernam</p>
			<input type="text" name="username" placeholder="Enter Username"
				id="name">
			<p>Password</p>
			<input type="password" name="password" placeholder="Enter Password"
				id="pass">
			<p>Confirm Password</p>
			<input type="password" name="confirm" placeholder="Enter Confirm"
				id="cfpassword">
			<p>Email Address</p>
			<input type="text" name="emailaddress"
				placeholder="Enter Enter Address" id="email">
			<p>Phone Number</p>
			<input type="text" name="phonenumber" placeholder="Enter PhoneNumber"
				id="phone"> <input type="submit" onClick="checkinput()"
				value="Create Account">
		</form>
	</div>

</body>

</html>