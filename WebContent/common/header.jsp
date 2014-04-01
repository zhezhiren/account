<%@page import="org.springframework.security.core.Authentication"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="org.springframework.security.core.context.SecurityContext"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link rel="stylesheet" href="<%=basePath%>css/header.css" type="text/css">
<nav>
	<div id="logo">
	</div>
	<div class="constrain">
		
	</div>
	<div id="welcom">
		<span>您好： 
			<%
			SecurityContext sc = (SecurityContext)  session.getAttribute("SPRING_SECURITY_CONTEXT");
			if(sc != null)
			{
				Authentication auto = (Authentication)sc.getAuthentication();
				if(auto != null)
				{
					%>
					<%= auto.getName() %>
					<%
				}else{
					%>
					游客
					<%
				}
			}else
			{
				 %>
				 游客
				 <%
			}
			;
			%>
		
		</span>
	</div>
	
</nav>