<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单管理</title>

	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/menu.css" >
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/ztree/css/zTreeStyle/zTreeStyle.css">
	<script type="text/javascript" src="<%=basePath%>js/jquery/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/ztree/js/jquery.ztree.core-3.5.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/ztree/js/jquery.ztree.excheck-3.5.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/ztree/js/jquery.ztree.exedit-3.5.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/Tip/Tip.js" ></script>
	<script type="text/javascript" src="<%=basePath%>js/custerm/common.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/custerm/admin/menuTree.js"></script>
	<SCRIPT type="text/javascript">
		
		$(document).ready(function(){
			$.post("<%=basePath%>menu/getMenus.json",
				{
				},
				function(data,status){
					$.fn.zTree.init($("#ztree"), simpleSetting, data);
				}
			);
		});
	</SCRIPT>

</head>
	<jsp:include page="/common/header.jsp"></jsp:include>
<body>
	<div id="page">
		<div id="menuUrl" class="rightContent ">
			<ul id="menuUrlUl" class="nopadding">
				<!-- <li class="urlDiv">
					<div style="padding:0px; margin:0px;">
						<ul class="urlContent">
							<li class="urlContent seri tableHead">序号</li> 
							<li class="urlContent urlName tableHead">地址名称</li> 
							<li class="urlContent matchType tableHead">表达式类型</li>
							<li class="urlContent url tableHead">请求路径</li>
							<li class="urlContent channel tableHead">访问通道</li>
							<li class="urlContent funcDesc tableHead">描述</li>
							<li class="urlContent authType tableHead">验证级别</li>
							<li class="urlContent operator tableHead">操作</li>
						</ul>
					</div>
				</li>
				<li class="urlDiv">
					<div>
						哈哈，哈哈哈
					</div>
				</li>
				<li class="urlDiv">
					<div>
						<ul class="urlContent">
							<li class="editable seri"></li> 
							<li class="editable urlName"><input class="editable"  /></li> 
							<li class="editable matchType"><select class="editable"><option value="ant">ant</option><option value="regix">正则表达式</option><option value="none">无</option></select></li>
							<li class="editable url"><input class="editable"  /></li>
							<li class="editable channel"><input class="editable"  /></li>
							<li class="editable funcDesc"><input class="editable"  /></li>
							<li class="editable authType"><input class="editable"  /></li>
							<li class="editable operate"><input class="editable"  /></li>
						</ul>
					</div>
				</li>
			 -->
			</ul>
		</div>
		<div id="menuEdit" class="rightContent noShow">
		
			<!-- <input id="menuId" type="hidden"/>
			<input id="parentMenuId" type="hidden" />
			<span class="menuProp"><span class="menuPropHead" style="margin-top:50px" >菜单基本信息</span></span>
			<span class="menuProp"><span class="menuPropDes">菜单名称:</span><input id="name" class="menuProp"/></span>
			<span class="menuProp"><span class="menuPropDes">菜单类型:</span><input id="menuType" class="menuProp"/> </span>
			<span class="menuProp"><span class="menuPropDes">子节点:</span>是<input name="isParent" type="radio" value="false" style="margin-right:20px;" />否<input name="isParent" type="radio" value="true" /></span>
			<span class="menuProp"><span class="menuPropDes">上传图表:</span><input id="imagePath" type="file"  class="menuProp"/></span>
			<span class="menuProp"><span class="menuPropDes">描述:</span><input id="menuDesc" class="menuProp"/></span>
			<span class="menuProp"><span class="menuPropHead">功能入口信息</span></span>
			<span class="menuProp"><span class="menuPropDes">入口地址:</span><input id="url" class="menuProp"/></span>
			<span class="menuProp"><span class="menuPropDes">入口通道:</span><input id="channel" class="menuProp"/></span>
			<span class="menuProp"><span class="menuPropDes">地址匹配类型:</span><input id="matchType" class="menuProp"/></span>
			<span class="menuProp"><span class="menuPropDes">地址验证级别:</span><input id="authType" class="menuProp"/></span>
			<span class="menuProp"> <span id="saveButton" class="menuButton mouseNotOn" style="margin-left:45px;margin-right:30px;"  onMouseOver="buttonMouseOver(this)" onMouseOut="buttonMouseOut(this)" onMouseDown="buttonMouseDown(this)" onMouseUp="buttonMouseUp(this)" onClick="saveMenu(this)">保存</span> <span id="resetButton" class="menuButton mouseNotOn"  onMouseOver="buttonMouseOver(this)" onMouseOut="buttonMouseOut(this)" onMouseDown="buttonMouseDown(this)" onMouseUp="buttonMouseUp(this)" onClick="saveUrl(this)">还原</span></span>
			 -->
		</div>
		<div id="menu">
			<div id="ztreeDesc">
				<span >菜单列表</span>
			</div>
			<ul id="ztree" class="ztree">
			</ul>
		</div>
	</div>
</body>
</html>