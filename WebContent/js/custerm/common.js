/**
 * 根据数组的属性生成下拉选项，并且可以现则给下拉框设置样式名与id值
 * @param arr
 * @param className
 * @returns
 */
function createSelectFromArr(arr, className, id){
	var selectObj = null;
	if(arr != null && "undefined" != typeof arr){
		
		selectObj = '<select ';
		if(id != null && "undefined" != typeof id){
			selectObj += 'id = "' + id + '" '; 
		}
		if(className != null && "undefined" != typeof className){
			selectObj += 'class = "' + className + '"';
		}
		selectObj += '>';
		for(var i = 0; i < arr.length; i++){
			var option = arr[i];
			selectObj += '<option value="';
			selectObj += option[0];
			selectObj += '">';
			selectObj += option[1];
			selectObj += "</option>";
		}
		selectObj += '</select>';
	}
	return selectObj;
}

/**
 * 根据对象的属性生成下拉选项，并且可以现则给下拉框设置样式名与id值
 * @param obj
 * @param className
 * @param id
 * @returns
 */
function createSelectFromObj(obj, className, id){
	var selectObj = null;
	if(obj != null && "undefined" != typeof obj){
		selectObj = '<select ';
		if(id != null && "undefined" != typeof id){
			selectObj += 'id = "' + id + '" '; 
		}
		if(className != null && "undefined" != typeof className){
			selectObj += 'class = "' + className + '" ';
		}
		selectObj += '>';
		selectObj +='<option value="">请选择</option>';
		for(var pro in obj){
			selectObj += '<option value="';
			selectObj += pro;
			selectObj += '">';
			selectObj += obj[pro];
			selectObj += "</option>";
		}
		selectObj += '</select>';
	}
	return selectObj;
}

//TODO 方法带填充完成
/**
 * 
 * @param obj
 * @param data
 * @param value
 */
function setSelectValue(obj, data, value){
	
}

/**
 * 获取对象的属性对应的值， 当属性未定义时，返回空字符串。
 * 目前仅用来获取 下拉选项的value对应的展示的值
 * @param obj
 * @param data
 * @returns
 */
function getObjValue(obj, data){
	var value = obj[data];
	if(typeof(value) == "undefined" || value == null){
		value = "";
	}
	return value;
}

function getRootPath(){
	var curWwwPath=window.document.location.href;
	var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    var localhostPaht=curWwwPath.substring(0,pos);
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return(localhostPaht+projectName);
}
