package com.plj.action.admin.sys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.plj.common.error.Problem;
import com.plj.common.result.JsonResult;
import com.plj.domain.decorate.admin.sys.Menu;
import com.plj.domain.decorate.admin.sys.UrlInfo;
import com.plj.domain.request.admin.sys.MenuAdd;
import com.plj.service.admin.sys.MenuService;
import com.plj.service.admin.sys.UrlInfoService;

@Controller
@RequestMapping("/menu")
public class MenuAction 
{
	@Autowired
	@Qualifier("menuService")
	MenuService menuService;
	
	@Autowired
	@Qualifier("urlInfoService")
	UrlInfoService urlService;
	
	
	/**
	 * 可以构思下能否参数验证 通过设置不能为为空，无需手动构建验证函数，自动验证。
	 * 可以构思下对某些键的唯一认证进行自动验证，无需手动查询数据库判断后再返回。
	 * @param menu
	 * @return
	 */
	@RequestMapping("saveMenu.json")
	public Object saveMenu(MenuAdd menu){
		JsonResult result = new JsonResult();
		if(menu != null)
		{
			if(StringUtils.isBlank(menu.getName()))
			{
				result.addProblem(new Problem("", "菜单名称不能为空"));
			}
			if(result.isSuccess())
			{
				boolean i = false;
				if(menu.getId() == null || menu.getId() == 0)
				{
					i = menuService.addMenu(menu);
				}else{
					i = menuService.updatMenu(menu);
				}
				result.setData(i);
			}
		}
		return result;
	}
	
	@RequestMapping("/getMenus.json")
	@ResponseBody
	public Object getMenuTree()
	{
		List<Menu> nodes = new ArrayList<Menu>();
		Menu node0 = new Menu();
		node0.setId(0);
		node0.setName("菜单树");
		node0.setOpen(true);
		nodes.add(node0);
		List<Menu> menus = menuService.selectList(null);
		if(menus != null && menus.size() > 0)
		{
			nodes.addAll(menus);
		}
		return JSON.toJSON(nodes);
	}
	
	@RequestMapping("/deleteMenuById.json")
	@ResponseBody
	public Object deleteMenuById(Integer menuId	)
	{
		if(menuId != null && menuId != 0)
		{
			menuService.deleteMenu(menuId);
			return true;
		}else{
			return false;
		}
	}
	
	@RequestMapping("getMenuUrls.json")
	@ResponseBody
	public Object getMenuUrls(int menuId)
	{
		HashMap<String, Object> param = new HashMap<String, Object>(1);
		param.put("menuId", menuId);
		List<UrlInfo> urls = urlService.selectList(param);
		return JSON.toJSON(urls);
	}
	
	@RequestMapping("getAccessUrlByMenu.json")
	@ResponseBody
	public Object getAccessUrlByMenu(int menuId)
	{
		HashMap<String, Object> param = new HashMap<String, Object>(2);
		param.put("menuId", menuId);
		param.put("isAccess", true);
		List<UrlInfo> urls = urlService.selectList(param);
		if(urls.size() > 0)
		{
			return JSON.toJSON(urls.get(0));
		}
		return null;
	}
	
	
	@RequestMapping("deletUrl.json")
	@ResponseBody
	public Object deletUrl(int urlId)
	{
		List<Integer> ids = new ArrayList<Integer>(1);
		ids.add(urlId);
		int i = urlService.deleteByPrimaryKeys(ids);
		if(i >= 0)
		{
			return true;
		}else{
			return false;
		}
	}
	
	@RequestMapping("saveUrlInfo.json")
	@ResponseBody
	public Object saveUrl(UrlInfo url)
	{
		int i = 0; 
		if(null != url && url.getId() != null && url.getId() != 0)
		{
			//TODO
			url.setIsAccess(false);
			i =  urlService.updateByPrimaryKey(url);
		}else
		{
			i = urlService.insert(url);
		}
		if(i > 0)
		{
			return true;
		}else{
			return false;
		}
	}
}
