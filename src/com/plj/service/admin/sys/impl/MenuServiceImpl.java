package com.plj.service.admin.sys.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plj.dao.admin.sys.MenuDao;
import com.plj.domain.decorate.admin.sys.Menu;
import com.plj.domain.decorate.admin.sys.UrlInfo;
import com.plj.domain.request.admin.sys.MenuAdd;
import com.plj.service.admin.sys.MenuService;
import com.plj.service.admin.sys.UrlInfoService;
import com.plj.service.common.impl.BaseServiceImpl;

@Service("menuService")
public class MenuServiceImpl extends BaseServiceImpl<Menu, MenuDao> 
		implements MenuService
{
	/**
	 * 增加菜单的rgt值与lft值
	 */
	private static final String ADD = "add";
	/**
	 * 减少菜单的rgt值与lft值
	 */
	private static final String REDUCE = "reduce";
	
	@Autowired
	MenuDao dao;
	
	@Autowired
	@Qualifier("urlInfoService")
	UrlInfoService urlService;
	
	@Override
	protected MenuDao getDao() 
	{
		return dao;
	}

	@Override
	@Transactional
	public boolean addMenu(MenuAdd menu)
	{
		if(menu.getPId() == null || menu.getPId() == 0)
		{
			menu.setPId(0);
			int maxRight = dao.selectMaxRight();
			menu.setLft(maxRight + 1);
			menu.setRgt(maxRight + 2);
		}else{
			Menu parent = new Menu();
			parent.setId(menu.getPId());
			parent = dao.selectByPrimaryKey(parent);
			menu.setLft(parent.getRgt());
			menu.setRgt(parent.getRgt() + 1);
			
			HashMap<String, Object> param = new HashMap<String, Object>();
			param.put(ADD, ADD);
			param.put("right", parent.getRgt());
			
			dao.updateRgt(param);
			dao.updateLft(param);
		}
		int i = this.insert(menu);
		
		if( i > 0 && StringUtils.isNotBlank(menu.getUrl()))
		{
			UrlInfo url = getUrlInfo(menu);
			urlService.insert(url);
		}
		return true;
	}
	
	@Override
	public boolean updatMenu(MenuAdd menu)
	{
		if(menu.getName() == null)
		{
			return false;
		}
		if(menu.getMenuDesc() == null)
		{
			menu.setMenuDesc("");
		}
		if(menu.getMenuType() == null)
		{
			menu.setMenuType("");
		}
		if(menu.getIcon() == null)//TODO 图标的处理有所不同，有待进一步修改。没上传图片，按理来说意味着不修改图标。
		{
			menu.setIcon("");
		}
		int i = dao.updateByPrimaryKeySelective(menu);
		if(i > 0)
		{
			HashMap<String, Object> param = new HashMap<String, Object>(2);
			param.put("menuId", menu.getId());
			param.put("isAccess", true);
			List<UrlInfo> urls = urlService.selectList(param);
			if(StringUtils.isNotBlank(menu.getUrl()))
			{
				UrlInfo url = getUrlInfo(menu);
				if(urls.size() > 0){
					url.setId(urls.get(0).getId());
					urlService.updateByPrimaryKey(url);
				}else{
					urlService.insert(url);
				}
			}else{
				if(urls.size() > 0)
				{
					List<Integer> ids = new ArrayList<Integer>(1);
					ids.add(urls.get(0).getId());
					urlService.deleteByPrimaryKeys(ids);
				}
			}
			return true;
		}
		return false;
	}
	
	public boolean deleteMenu(Integer id)
	{
		if(id == null || 0 == id){
			return false;
		}
		Menu menu = dao.selectByPrimaryKey(id);
		if(menu != null ){
			List<Integer> menuIds = new ArrayList<Integer>();
			menuIds.add(id);
			if(menu.getIsParent())
			{
				HashMap<String, Integer> map = new HashMap<String, Integer>(2);
				map.put("lft", menu.getLft());
				map.put("rgt", menu.getRgt());
				List<Menu> menus = dao.selectList(map);
				for(int i = 0; i < menus.size(); i++)
				{
					menuIds.add(menus.get(i).getId());
				}
			}
			urlService.deleteUrlInfoByMenuId(menuIds);
			dao.deleteByPrimaryKeys(menuIds);
			int width = menu.getRgt() - menu.getLft() + 1;
			HashMap<String, Object> param = new HashMap<String, Object>();
			param.put(REDUCE, REDUCE);
			param.put("width", width);
			param.put("right", menu.getRgt());
			dao.updateLft(param);
			dao.updateRgt(param);
			return true;
		}
		return false;
	}
	
	private UrlInfo getUrlInfo(MenuAdd menu)
	{
		UrlInfo url = null;
		if(StringUtils.isNotBlank(menu.getUrl()))
		{
			url = new UrlInfo();
			url.setUrl(menu.getUrl());
			url.setAuthType(menu.getAuthType());
			url.setChannel(menu.getChannel());
			url.setFuncDesc(menu.getName() + "菜单自动生成的入口URL信息。");
			url.setMatchType(menu.getMatchType());
			url.setMenuId(menu.getId());
			url.setUrlName(menu.getName() + "入口");
			url.setIsAccess(true);
		}
		return url;
	}
}
