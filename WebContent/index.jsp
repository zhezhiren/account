<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>首页</title>
<script type="text/javascript" src="js/jquery/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/jsTree/jquery.jstree.js"></script>
<script type="text/javascript">
	$(function () {
	    $("#demo1").jstree({
	        "plugins" : [ "themes", "html_data" ]
	    });
	});

</script>
</head>
<jsp:include page="/common/header.jsp"></jsp:include>
<body>
	首页
	<p> 惦记我 </p>
	<div id="demo1"></div>
</body>
</html>