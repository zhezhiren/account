package com.plj.service.admin.sys;

import com.plj.dao.admin.sys.MenuDao;
import com.plj.domain.decorate.admin.sys.Menu;
import com.plj.domain.request.admin.sys.MenuAdd;
import com.plj.service.common.BaseService;

public interface MenuService extends BaseService<Menu, MenuDao>
{
	public boolean addMenu(MenuAdd menu);
	
	public boolean updatMenu(MenuAdd menu);
	
	public boolean deleteMenu(Integer id);
}
