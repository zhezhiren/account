<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="js/ztree/css/demo.css" type="text/css">
	<link rel="stylesheet" href="js/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="js/jquery/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="js/ztree/js/jquery.ztree.core-3.5.js"></script>
	<script type="text/javascript" src="js/ztree/js/jquery.ztree.excheck-3.5.js"></script>
	<script type="text/javascript" src="js/custerm/admin/menuTree.js"></script>
	<SCRIPT type="text/javascript">
		var zNodes =[
			{ id:1, pId:0, name:"随意勾选 1", open:true},
			{ id:11, pId:1, name:"随意勾选 1-1", open:true},
			{ id:111, pId:11, name:"随意勾选 1-1-1"},
			{ id:112, pId:11, name:"随意勾选 1-1-2"},
			{ id:12, pId:1, name:"随意勾选 1-2", open:true},
			{ id:121, pId:12, name:"随意勾选 1-2-1"},
			{ id:122, pId:12, name:"随意勾选 1-2-2"},
			{ id:2, pId:0, name:"随意勾选 2", checked:true, open:true},
			{ id:21, pId:2, name:"随意勾选 2-1"},
			{ id:22, pId:2, name:"随意勾选 2-2", open:true},
			{ id:221, pId:22, name:"随意勾选 2-2-1", checked:true},
			{ id:222, pId:22, name:"随意勾选 2-2-2"},
			{ id:23, pId:2, name:"随意勾选 2-3"}
		];
		
		
		$(document).ready(function(){
			initCheckBoxTree("#treeDemo", zNodes);
		});
	</SCRIPT>
</HEAD>

<BODY>
<h1>Checkbox 勾选操作</h1>
<h6>[ 文件路径: excheck/checkbox.html ]</h6>
<div class="content_wrap">
	<div class="zTreeDemoBackground left">
		<ul id="treeDemo" class="ztree"></ul>
	</div>
	<div class="right">
		<ul class="info">
			<li class="title"><h2>1、setting 配置信息说明</h2>
				<ul class="list">
				<li class="highlight_red">使用 checkbox，必须设置 setting.check 中的各个属性，详细请参见 API 文档中的相关内容</li>
				<li><p>父子关联关系：<br/>
						被勾选时：<input type="checkbox" id="py" class="checkbox first" checked /><span>关联父</span>
						<input type="checkbox" id="sy" class="checkbox first" checked /><span>关联子</span><br/>
						取消勾选时：<input type="checkbox" id="pn" class="checkbox first" checked /><span>关联父</span>
						<input type="checkbox" id="sn" class="checkbox first" checked /><span>关联子</span><br/>
						<ul id="code" class="log" style="height:20px;"></ul></p>
				</li>
				</ul>
			</li>
			<li class="title"><h2>2、treeNode 节点数据说明</h2>
				<ul class="list">
				<li class="highlight_red">1)、如果需要初始化默认节点被勾选，请设置 treeNode.checked 属性，详细请参见 API 文档中的相关内容</li>
				<li class="highlight_red">2)、如果某节点禁用 checkbox，请设置 treeNode.chkDisabled 属性，详细请参见 API 文档中的相关内容 和 'chkDisabled 演示'</li>
				<li class="highlight_red">3)、如果某节点不显示 checkbox，请设置 treeNode.nocheck 属性，详细请参见 API 文档中的相关内容 和 'nocheck 演示'</li>
				<li class="highlight_red">4)、如果更换 checked 属性，请参考 API 文档中 setting.data.key.checked 的详细说明</li>
				<li>5)、其他请参考 API 文档中 treeNode.checkedOld / getCheckStatus / check_Child_State / check_Focus 的详细说明</li>
				</ul>
			</li>
		</ul>
	</div>
</div>
</BODY>
</HTML>