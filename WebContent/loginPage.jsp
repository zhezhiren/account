<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>login page</title>
	<link rel="stylesheet" href="css/login.css" type="text/css" />
	<script type="text/javascript" src="js/jquery/jquery-1.11.0.min.js"></script>
	<script type="text/javascript">
		function onlogin(){
			var username = document.getElementById("username").value;
			var password = document.getElementById("password").value;
			if(username==""){
				alert("用户名不能为空!");
				return;
			}
			if(password==""){
				alert("密码不能为空!");
				return;
			}
			document.getElementById("form").submit()
		}
		
		var isError = false;
		
	<%
		Object error = session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
		if(error != null)
		{
	%>
		isError = true;
	<%
		}
	%>
	
	$(document).ready(function(){
		if(isError){
			$("#error_tips").css('display','block');
			$("#warning").append("用户名密码错误");
		}
	});
	
	
	</script>
	</head>
	<jsp:include page="/common/header.jsp"></jsp:include>
	<body >
		<div id="bg">
				<div id="dlk">
					<form id = "form" action ="login_check" method="post">
						<div id="error_tips" class="error_tips" style="display:none;">
							<span id="warning_logo" class="warning_logo">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
							<span id="warning"></span>
						</div>
						<div id="shu">
							<img src="images/login/icon_5.jpg" height="31" width="31" class="tu" />
							<input id="username" name="username" type="text" value="" class="shuru"  value="" />
		                </div>
						<div id="shu">
							<img src="images/login/icon_6.jpg" height="31" width="31" class="tu" />
							<input id ="password" name="password" type="password" value="" class="shuru" value="" />
							<font id="mypassword" style="color:red">&nbsp;</font>
						</div>
						<div id="anniu">
							<a href="javascript:onlogin();"><span id="denglu"></span></a>
							<a href="javascript:onReset();"><span id="quxiao"></span></a>
						</div>
					</form>
				</div>
		</div>
	</body>
</html>