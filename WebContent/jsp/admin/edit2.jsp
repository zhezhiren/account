<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<HTML>
<HEAD>
	<TITLE> ZTREE DEMO - edit</TITLE>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="../../../css/demo.css" type="text/css">
	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/ztree/css/zTreeStyle/zTreeStyle.css">
	<script type="text/javascript" src="<%=basePath%>js/jquery/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/ztree/js/jquery.ztree.core-3.5.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/ztree/js/jquery.ztree.excheck-3.5.js"></script>
	<script type="text/javascript" src="../../../js/jquery.ztree.exedit-3.5.js"></script>
	<SCRIPT type="text/javascript">
		<!--
		var setting = {
			check: {
				enable: true
			},
			edit: {
				enable: true
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeDrag: beforeDrag
			}
		};

		var zNodes =[
			{ id:1, pId:0, name:"ç¶èç¹ 1", open:true},
			{ id:11, pId:1, name:"å¶å­èç¹ 1-1"},
			{ id:12, pId:1, name:"å¶å­èç¹ 1-2"},
			{ id:13, pId:1, name:"å¶å­èç¹ 1-3"},
			{ id:2, pId:0, name:"ç¶èç¹ 2", open:true},
			{ id:21, pId:2, name:"å¶å­èç¹ 2-1"},
			{ id:22, pId:2, name:"å¶å­èç¹ 2-2"},
			{ id:23, pId:2, name:"å¶å­èç¹ 2-3"},
			{ id:3, pId:0, name:"ç¶èç¹ 3", open:true},
			{ id:31, pId:3, name:"å¶å­èç¹ 3-1"},
			{ id:32, pId:3, name:"å¶å­èç¹ 3-2"},
			{ id:33, pId:3, name:"å¶å­èç¹ 3-3"}
		];

		function beforeDrag(treeId, treeNodes) {
			return false;
		}
		
		
		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		
		});
		//-->
	</SCRIPT>
</HEAD>

<BODY>
<h1>åºæ¬ å¢ / å  / æ¹ èç¹</h1>
<h6>[ æä»¶è·¯å¾: exedit/edit.html ]</h6>
<div class="content_wrap">
	<div class="zTreeDemoBackground left">
		<ul id="treeDemo" class="ztree"></ul>
	</div>
	<div class="right">
		<ul class="info">
			<li class="title"><h2>1ãsetting éç½®ä¿¡æ¯è¯´æ</h2>
				<ul class="list">
				<li>æ­¤ Demo ä»ä»åè½ä¸æ¼ç¤ºç¼è¾èç¹çåºæ¬æ¹æ³åéç½®åæ°</li>
				<li class="highlight_red">1)ãä½¿ç¨ ç¼è¾åè½ï¼å¿é¡»è®¾ç½® setting.edit ä¸­çåä¸ªå±æ§ï¼è¯¦ç»è¯·åè§ API ææ¡£ä¸­çç¸å³åå®¹</li>
				<li class="highlight_red">2)ãä½¿ç¨ ç¼è¾åè½çäºä»¶åè°å½æ°ï¼å¿é¡»è®¾ç½® setting.callback.beforeRemove / onRemove / beforeRename / onRename ç­å±æ§ï¼è¯¦ç»è¯·åè§ API ææ¡£ä¸­çç¸å³åå®¹</li>
				<li class="highlight_red">3)ãzTree ä¸æä¾é»è®¤çå¢å æé®ï¼å¦éå®ç°è¯·å©ç¨èªå®ä¹æ§ä»¶çæ¹æ³ addHoverDom / removeHoverDom ï¼è¯¦ç»è¯·åè§ API ææ¡£ä¸­çç¸å³åå®¹ï¼å¦å¤ä¹å¯ä»¥åè "é«çº§ å¢ / å  / æ¹ èç¹" ç Demo</li>
				<li><p>åºæ¬ç¼è¾æé®è®¾ç½®ï¼<br/>
						<input type="checkbox" id="remove" class="checkbox first" checked /><span>æ¾ç¤ºå é¤æé®</span>
						<input type="checkbox" id="rename" class="checkbox " checked /><span>æ¾ç¤ºç¼è¾æé®</span><br/>
						remove æé®ç title: <input type="text" id="removeTitle" value="remove" /><br/>
						rename æé®ç title: <input type="text" id="renameTitle" value="rename" />
						<ul id="code" class="log" style="height:85px;"></ul></p>
				</li>
				</ul>
			</li>
			<li class="title"><h2>2ãtreeNode èç¹æ°æ®è¯´æ</h2>
				<ul class="list">
				<li>å¯¹ èç¹æ°æ® æ²¡æç¹æ®è¦æ±ï¼ç¨æ·å¯ä»¥æ ¹æ®èªå·±çéæ±æ·»å èªå®ä¹å±æ§</li>
				</ul>
			</li>
		</ul>
	</div>
</div>
</BODY>
</HTML>