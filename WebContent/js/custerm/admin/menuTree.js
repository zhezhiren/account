var checkboxSetting = {
	check : {
		enable : true
	},
	view : {
		showLine : true
	},
	edit : {
		enable : true,
		editNameSelectAll : true,
		removeTitle : '删除',
		renameTitle : '修改',
		showRemoveBtn : showRemoveBtn,
		showRenameBtn : showRenameBtn
	},
	data : {
		simpleData : {
			enable : true
		}
	}
};

function initCheckBoxTree(domId, data) {
	$.fn.zTree.init($(domId), checkboxSetting, data);
	setCheck();
	$("#py").bind("change", setCheck);
	$("#sy").bind("change", setCheck);
	$("#pn").bind("change", setCheck);
	$("#sn").bind("change", setCheck);
}

var code;

function setCheck() {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo"), py = $("#py").attr(
			"checked") ? "p" : "", sy = $("#sy").attr("checked") ? "s" : "", pn = $(
			"#pn").attr("checked") ? "p" : "", sn = $("#sn").attr("checked") ? "s"
			: "", type = {
		"Y" : py + sy,
		"N" : pn + sn
	};
	zTree.setting.check.chkboxType = type;
	showCode('setting.check.chkboxType = { "Y" : "' + type.Y + '", "N" : "'
			+ type.N + '" };');
}

function showCode(str) {
	if (!code)
		code = $("#code");
	code.empty();
	code.append("<li>" + str + "</li>");
}

var simpleSetting = {
	view : {
		showLine : false,
		selectedMulti : false,
		addHoverDom : addHoverDom,
		removeHoverDom : removeHoverDom
	},
	edit : {
		enable : true,
		editNameSelectAll : true,
		removeTitle : '删除',
		renameTitle : '编辑',
		showRemoveBtn : showRemoveBtn,
		showRenameBtn : showRenameBtn
	},
	data : {
		simpleData : {
			enable : true
		}
	},
	callback : {
		onClick : onSimpleClick,
		beforeDrag : beforeDrag,
		beforeEditName : beforeEditName,
		beforeRemove : beforeRemove,
		beforeRename : beforeRename
	}
};

function showRemoveBtn(treeId, treeNode) {
	if(treeNode.id == 0){
		return false;
	}
	return true;
}

function showRenameBtn(treeId, treeNode) {
	if(treeNode.id == 0){
		return false;
	}
	return true;
}

function beforeDrag() {
	return false;
}
function beforeEditName(treeId, treeNode) {
	createMenuForm();
	var menuId = treeNode.id;
	completeMenuInfo(menuId, treeNode);
	completeUrlInfo(menuId);
	return false;
}
function createMenuForm(){
	var content = '<input id="menuId" type="hidden"/>'+
	'<input id="parentMenuId" type="hidden" />'+
	'<span class="menuProp"><span class="menuPropHead" style="margin-top:50px" >菜单基本信息</span></span>'+
	'<span class="menuProp"><span class="menuPropDes">菜单名称:</span><input id="name" class="menuProp"/></span>'+
	'<span class="menuProp"><span class="menuPropDes">菜单类型:</span><input id="menuType" class="menuProp"/> </span>'+
	'<span class="menuProp"><span class="menuPropDes">子节点:</span>是<input name="isParent" type="radio" value="false" style="margin-right:20px;" />否<input name="isParent" type="radio" value="true" /></span>'+
	'<span class="menuProp"><span class="menuPropDes">上传图标:</span><input id="icon" type="file"  class="menuProp"/></span>'+
	'<span class="menuProp"><span class="menuPropDes">描述:</span><input id="menuDesc" class="menuProp"/></span>'+
	'<span class="menuProp"><span class="menuPropHead">功能入口信息</span></span>'+
	'<span class="menuProp"><span class="menuPropDes">入口地址:</span><input id="url" class="menuProp"/></span>'+
	'<span class="menuProp"><span class="menuPropDes">地址匹配类型:</span>' + createSelectFromObj(matchTypeDataObj, 'menuProp', 'matchType') + '</span>'+
	'<span class="menuProp"><span class="menuPropDes">入口通道:</span>' + createSelectFromObj(channelDataObj, 'menuProp', 'channel') + '</span>'+
	'<span class="menuProp"><span class="menuPropDes">地址验证级别:</span>'+ createSelectFromObj(authTypeDataObj,'menuProp', 'authType') + '</span>'+
	'<span class="menuProp"> <span id="saveButton" class="menuButton mouseNotOn" style="margin-left:45px;margin-right:30px;"  onMouseOver="buttonMouseOver(this)" onMouseOut="buttonMouseOut(this)" onMouseDown="buttonMouseDown(this)" onMouseUp="buttonMouseUp(this)" onClick="saveMenu(this)">保存</span> <span id="resetButton" class="menuButton mouseNotOn"  onMouseOver="buttonMouseOver(this)" onMouseOut="buttonMouseOut(this)" onMouseDown="buttonMouseDown(this)" onMouseUp="buttonMouseUp(this)" onClick="saveUrl(this)">还原</span></span>';
	$("#menuUrl").addClass("noShow");
	$("#menuEdit").removeClass("noShow").empty().html(content);
}

/*function clearMenuForm() {
	$("#menuUrl").addClass("noShow");
	$("#menuEdit").removeClass("noShow");
	$("#menuEdit").find("input:text").val("");
	$("#menuEdit").find("input:hidden").val("");
	$("#menuEdit").find("input:file").val("");
	$("#menuEdit").find("input:radio").removeAttr("checked");
}*/
function completeMenuInfo(menuId, treeNode) {
	var menuIdInput = $("#menuEdit").find("#menuId");
	$(menuIdInput).val(treeNode.id);
	var parentMenuIdInput = $("#menuEdit").find("#parentMenuId");
	$(parentMenuIdInput).val(treeNode.pId);
	var nameInput = $("#menuEdit").find("#name");
	$(nameInput).val(treeNode.name);
	var menuTypeInput = $("#menuEdit").find("#menuType");
	$(menuTypeInput).val(treeNode.menuType);
	$("#menuEdit").find("input:radio").each(function() {
		var v1 = this.value;
		var v3 = (new Boolean(treeNode.isParent)).toString();
		var v4 = v1 == v3;
		if (v4) {
			$(this).attr("checked", "checked");
			$(this).attr("defaultChecked", "checked");
		}
	});
	var menuDescInput = $("#menuEdit").find("#menuDesc");
	$(menuDescInput).val(treeNode.menuDesc);
}
function completeUrlInfo(menuId){
	$.post("../../menu/getAccessUrlByMenu.json", 
		{menuId: menuId}, 
		function(data, status) {
			if (status == 'success') {
				if(data != null){
					var urlInput = $("#menuEdit").find("#url");
					$(urlInput).val(data.url);
					var channelInput = $("#menuEdit").find("#channel");
					$(channelInput).val(data.channel);
					var matchTypeInput = $("#menuEdit").find("#matchType");
					$(matchTypeInput).val(data.matchType);
					var authTypeInput = $("#menuEdit").find("#authType");
					$(authTypeInput).val(data.authType);
				}
			} else {
				// TODO
			}
	});
	
	
	
}

function beforeRemove(treeId, treeNode) {
	var warningStr = "";
	if(treeNode.isParent){
		warningStr = "删除菜单，将删除子节点，同时将删除菜单和子节点所有关联url。\r\n这将导致相关url无法访问，或者不受权限管理监控。\r\n确认删除？";
	}else{
		warningStr = "删除菜单，同时将删除菜单所有关联url。\r\n这将导致相关url无法访问，或者不受权限管理监控。\r\n确认删除？";
	}
	if(confirm(warningStr)){
		$.post("../../menu/deleteMenuById.json", 
			{menuId: treeNode.id },
			function(data, status) {
				if (status == 'success') {
					if(data != null && data){
						alert("删除成功");//TODO
					}else{
						alert("删除失败");
						return false;
					}
				} else {
					alert("删除失败");// TODO
					return false;
				}
			}
		);
		return true;
	}else{
		return false;
	}
}
function beforeRename() {
	return false;
}

/**
 * 菜单书添加删除管理 相关代码
 */

function addHoverDom(treeId, treeNode) {
	var sObj = $("#" + treeNode.tId + "_span");
	if (treeNode.editNameFlag || $("#addBtn_" + treeNode.tId).length > 0 || !treeNode.isParent)
		return;
	var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
			+ "' title='增加' onfocus='this.blur();'></span>";
	sObj.after(addStr);
	var btn = $("#addBtn_" + treeNode.tId);
	if (btn)
		btn.bind("click", function() {
			createMenuForm();
			var parentMenuIdInput = $("#menuEdit").find("#parentMenuId");
			$(parentMenuIdInput).val(treeNode.id);
			return false;
		});
};

function removeHoverDom(treeId, treeNode) {
	$("#addBtn_" + treeNode.tId).unbind().remove();
};

function saveMenu() {
	var menu = new Object();
	var menuIdInput = $("#menuEdit").find("#menuId");
	menu.id = $(menuIdInput).val();
	var parentMenuIdInput = $("#menuEdit").find("#parentMenuId");
	menu.pId = $(parentMenuIdInput).val();
	var nameInput = $("#menuEdit").find("#name");
	menu.name = $(nameInput).val();
	var menuTypeInput = $("#menuEdit").find("#menuType");
	menu.menuType = $(menuTypeInput).val();
	var isParentInput = $("#menuEdit").find("input[name='isParent']:checked");
	menu.isParent = $(isParentInput).val();
	var menuDescInput = $("#menuEdit").find("#menuDesc");
	menu.menuDesc = $(menuDescInput).val();
	var urlInput = $("#menuEdit").find("#url");
	menu.url = $(urlInput).val();
	var channelInput = $("#menuEdit").find("#channel");
	menu.channel = $(channelInput).val();
	var matchTypeInput = $("#menuEdit").find("#matchType");
	menu.matchType = $(matchTypeInput).val();
	var authTypeInput = $("#menuEdit").find("#authType");
	menu.authType = $(authTypeInput).val();

	$.post("../../menu/saveMenu.json", menu, function(data, status) {
		if (status == 'success') {
			alert("success");
			updateMenuUl();
		} else {
			alert("新增菜单失败");
		}
	});
}

function updateMenuUl(){
	var rootPath = getRootPath();
	$.post(rootPath + "/menu/getMenus.json",
		{
		},
		function(data,status){
			$.fn.zTree.init($("#ztree"), simpleSetting, data);
		}
	);
}

/**
 * 菜单关联地址列表管理 相关代码
 */

/*var matchTypeData = [
    ["none", "无"],
	["ant", "ant"],
	["regix", "正则表达式"]
];*/
var matchTypeDataObj = {
	none:"无",
	ant:"ant",
	regix:"正则表达式"
};
                 	
/*var channelData = [
    ["none", "无"],
	["http", "http"],
	["https", "https"],
];*/
var channelDataObj={
	none:"无",
	http:"http",
	https:"https"
};

/*var authTypeData = [
	["none", "无"],
  	["all", "全验证"],
  	["remeberMe", "记住用户"]
];*/
var authTypeDataObj = {
	none:"无",
	all:"全验证",
  	remeberMe:"记住用户"
};

var currentUrls = null;
var currentViewMenuId = null;

function onSimpleClick(event, treeId, treeNode, clickFlag) {
	$("#menuUrl").removeClass("noShow");
	$("#menuEdit").addClass("noShow");
	currentViewMenuId = treeNode.id;
	updateMenuUrlUl();
}

function updateMenuUrlUl() {
	$.post("../../menu/getMenuUrls.json", {
		menuId : currentViewMenuId
	}, function(data, status) {
		if (status == 'success') {
			currentUrls = data;
			var result = createUrls(data);
			$("#menuUrlUl").empty();
			$("#menuUrlUl").html(result);
		} else {
			// TODO
		}
	});
}

function createUrls(urls) {
	var result = '<li class="operatorHead"><div id="addButtonDiv"><span class="addUrlButton mouseNotOn"  onMouseOver="buttonMouseOver(this)" onMouseOut="buttonMouseOut(this)" onMouseDown="buttonMouseDown(this)" onMouseUp="buttonMouseUp(this)" onClick="addUrl(this)"/></div></li>';
	result += '<li id="urlDivHead" class="urlDiv">' + '<div>'
			+ '<ul class="urlContent">'
			+ '<li class="urlContent seri tableHead">' + '序号' + '</li> '
			+ '<li class="urlContent urlName tableHead">' + '地址名称' + '</li> '
			+ '<li class="urlContent matchType tableHead">' + '表达式类型' + '</li>'
			+ '<li class="urlContent url tableHead">' + '请求路径' + '</li>'
			+ '<li class="urlContent channel tableHead">' + '访问通道'
			+ '</li>' + '<li class="urlContent funcDesc tableHead">' + '描述'
			+ '</li>' + '<li class="urlContent authType tableHead">' + '验证级别'
			+ '</li>' + '<li class="urlContent operate tableHead">' + '操作'
			+ '</li>' + '</ul>' + '</div>' + '</li>';
	if (urls.length > 0)
		for ( var i = 0; i < urls.length; i++) {
			var url = urls[i];
			url.urlName == null ? url.urlName = "" : url.urlName;
			var urlName = url.urlName;
			url.matchType == null ? url.matchType = "" : url.matchType;
			var matchType = url.matchType;
			url.url == null ? url.url = "" : url.url;
			var urlPath = url.url;
			url.channel == null ? url.channel = "" : url.channel;
			var channel = url.channel;
			url.funcDesc == null ? url.funcDesc = "" : url.funcDesc;
			var funcDesc = url.funcDesc;
			url.authType == null ? url.authType = "" : url.authType;
			var authType = url.authType;
			result += '<li id="url_view_' + url.id + '" urlId="' + url.id + '" seri="' + (i + 1)
					+ '" class="urlDiv" onDblClick="urlOnDbclick(this)">';
			result += '<div>';
			result += '<ul class="urlContent">';
			result += '<li class="urlContent seri">' + (i + 1) + '</li>';
			result += '<li class="urlContent urlName">' + urlName + '</li> ';
			result += '<li class="urlContent matchType">' + getObjValue(matchTypeDataObj, matchType) + '</li>';
			result += '<li class="urlContent url">' + urlPath + '</li>';
			result += '<li class="urlContent channel">' + getObjValue(channelDataObj, channel) + '</li>';
			result += '<li class="urlContent funcDesc">' + funcDesc + '</li>';
			result += '<li class="urlContent authType">' + getObjValue(authTypeDataObj, authType) + '</li>';
			result += '<li class="urlContent operate"><span class="urlOperator updateUrlButton mouseNotOn" onMouseOver="buttonMouseOver(this)" onMouseOut="buttonMouseOut(this)" onMouseDown="buttonMouseDown(this)" onMouseUp="buttonMouseUp(this)" onClick="updatOnclick(this)"/><span class="urlOperator deleteUrlButton mouseNotOn" onMouseOver="buttonMouseOver(this)" onMouseOut="buttonMouseOut(this)"  onMouseDown="buttonMouseDown(this)" onMouseUp="buttonMouseUp(this)" onClick="deleteOnclick(this)"/></li>';
			result += '</ul>';
			result += '</div>';
			result += '</li>';
		}
	return result;
}

function urlOnDbclick(obj) {
	
/*	var edit =  $(parent).children("#editableUrl");
	if(edit.length > 0){
		if(confirm("您选择编辑下一条地址信息，但您当前地址信息还未保存，是否放弃编辑？")){
			$(edit).prev().show();
			$(edit).remove();
		}else{
			return;
		}
	}
*/	
	var editable = createEditableUrl();
	var seri = $(obj).attr("seri");
	var index = parseInt(seri) - 1;
	var id = $(obj).attr("urlId");
	/*var editable = '<li id="editableUrl" urlId="' + id + '" seri=" ' + seri + '" class="urlDiv" tabIndex="' + parseInt(seri) + '" >'
			+ '<div>'
			+ '<ul class="urlContent" >'
			+ '<li class="editable seri"> '
			+ (parseInt(index ))
			+ '</li> '
			+ '<li class="editable urlName"><input class="editable" value="'
			+ (currentUrls[index].urlName)
			+ '" /></li>'
			+ '<li class="editable matchType">' + createSelect(matchTypeData, 'editable') + '</li>'
			+ '<li class="editable menuUrl"><input class="editable" value="'
			+ (currentUrls[index].url)
			+ '" /></li>'
			+ '<li class="editable channelType">' + createSelect(channelData, 'editable') + '</li>'
			+ '<li class="editable funcDesc"><input class="editable" value="'
			+ (currentUrls[index].funcDesc)
			+ '" /></li>'
			+ '<li class="editable authType">'+ createSelect(authTypeData,'editable') + '</li>'
			+ '<li class="editable operate"><span class="urlOperator saveUrlButton mouseNotOn" onMouseOver="buttonMouseOver(this)" onMouseOut="buttonMouseOut(this)" onMouseDown="buttonMouseDown(this)" onMouseUp="buttonMouseUp(this)" onClick="saveUrl(this)"/></li>'
			+ '</ul>' + '</div>' + '</li>';*/
	/*(currentUrls[seri].channel)*/
	/*(currentUrls[seri].authType)*/
	
	$(obj).hide();
	$(obj).after(editable);
	var parent = $(obj).parent();
	edit =  $(parent).children("#editableUrl");
	$(edit).attr("urlId", id);
	$(edit).find(".seri").html(seri);
	$(edit).find(".url input").val(currentUrls[index].url);
	$(edit).find(".urlName input").val(currentUrls[index].urlName);
	/*setSelectValue($(edit).find(".matchType select"), matchTypeData, currentUrls[seri].matchType);
	setSelectValue($(edit).find(".authType select"), authTypeData, currentUrls[seri].authType);
	setSelectValue($(edit).find(".channel select"), channelData, currentUrls[seri].channel);
	*/
	$(edit).find(".matchType select").val(currentUrls[index].matchType);
	$(edit).find(".authType select").val(currentUrls[index].authType);
	$(edit).find(".channel select").val(currentUrls[index].channel);
	$(edit).find(".funcDesc input").val(currentUrls[index].funcDesc);
}
function updatOnclick(obj) {
	var urlLi = $(obj).parent().parent().parent().parent();

	urlOnDbclick(urlLi);
}
function buttonMouseOver(obj) {
	$(obj).removeClass("mouseNotOn");
	$(obj).addClass("mouseOn");
}
function buttonMouseOut(obj) {
	$(obj).addClass("mouseNotOn");
	$(obj).removeClass("mouseOn");
}
function buttonMouseDown(obj) {
	$(obj).addClass("onMouseDown");
}
function buttonMouseUp(obj) {
	$(obj).removeClass("onMouseDown");
}
function deleteOnclick(obj) {
	var urlLi = $(obj).parent().parent().parent().parent();
	var urlId = parseInt($(urlLi).attr("urlId"));
	$.post("../../menu/deletUrl.json", {
		urlId : urlId
	}, function(data, status) {
		if (status == 'success') {
			updateMenuUrlUl();
			alert("删除成功");// TODO
		} else {
			alert("删除失败");// TODO
			// TODO
		}
	});
}
function urlLostFocus(obj){
	if(confirm("您正在编辑一条地址信息，是否放弃编辑？")){
		$(obj).prev().show();
		$(obj).remove();
	}else{
		obj.focus();
	}
	/*var activeObj = document.activeElement;
	var urlLi = $(obj).parent().parent().parent().parent();
	var lost = true;
	$(urlLi).children().each(function(){
		if(activeObj == this){
			lost = false;
			return false;
		}
	});
	if(lost){
		if(confirm("您正在编辑一条地址信息，是否放弃编辑？")){
			$(obj).prev().show();
			$(obj).remove();
		}else{
			obj.focus();
		}
	}*/
}

function saveUrl(obj) {
	var param = new Object();
	var urlLi = $(obj).parent().parent().parent().parent();
	param.id = parseInt($(urlLi).attr("urlId"));
	var ss = $(urlLi).find("li.urlName")[0];
	var pa = $(ss).children("input")[0];
	param.urlName = $(pa).val();
	param.menuId = currentViewMenuId;
	ss = $(urlLi).find("li.url")[0];
	pa = $(ss).children("input")[0];
	param.url = $(pa).val();
	ss = $(urlLi).find("li.channel")[0];
	pa = $(ss).children("input")[0];
	param.channel = $(pa).val();
	ss = $(urlLi).find("li.matchType")[0];
	pa = $(ss).children("input")[0];
	param.matchType = $(pa).val();
	ss = $(urlLi).find("li.authType")[0];
	pa = $(ss).children("input")[0];
	param.authType = $(pa).val();
	ss = $(urlLi).find("li.funcDesc")[0];
	pa = $(ss).children("input")[0];
	param.funcDesc = $(pa).val();
	$.post("../../menu/saveUrlInfo.json", param, function(data, status) {
		if (status == 'success') {
			if (data == true) {
				updateMenuUrlUl();
			} else {
				alert("false");
			}
		} else {
			alert("error");
		}
	});
}

function addUrl() {
	var editable = createEditableUrl();
	$("#urlDivHead").after(editable);
	var seri = $("#editableUrl").find("li.seri");
	$(seri).text(0);
}

function createEditableUrl(){
	var edit =  $("#editableUrl");
	if(edit.length > 0){
		if(confirm("您选择编辑下一条地址信息，但您当前地址信息还未保存，是否放弃编辑？")){
			$(edit).prev().show();
			$(edit).remove();
		}else{
			return;
		}
	}
	var editable = '<li id="editableUrl" seri="0" class="urlDiv">'
		+ '<div>'
		+ '<ul class="urlContent">'
		+ '<li class="editable seri"></li> '
		+ '<li class="editable urlName"><input class="editable" value=""/></li>'
		+ '<li class="editable matchType">' + createSelectFromObj(matchTypeDataObj, 'editable') + '</li>'
		+ '<li class="editable url"><input class="editable" value=""/></li>'
		+ '<li class="editable channel">' + createSelectFromObj(channelDataObj, 'editable') + '</li>'
		+ '<li class="editable funcDesc"><input class="editable" value=""/></li>'
		+ '<li class="editable authType">'+ createSelectFromObj(authTypeDataObj,'editable') + '</li>'
		+ '<li class="editable operate"><span class="urlOperator saveUrlButton mouseNotOn" onMouseOver="buttonMouseOver(this)" onMouseOut="buttonMouseOut(this)" onMouseDown="buttonMouseDown(this)" onMouseUp="buttonMouseUp(this)" onClick="saveUrl(this)"/></li>'
		+ '</ul>' + '</div>' + '</li>';
	return editable;
}