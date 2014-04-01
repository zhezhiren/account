package com.plj.service.admin.sys;

import java.util.List;

import com.plj.dao.admin.sys.RoleMenuDao;
import com.plj.domain.bean.admin.sys.UrlRoleBean;
import com.plj.domain.decorate.admin.sys.RoleMenu;
import com.plj.service.common.BaseService;

public interface RoleMenuService extends BaseService<RoleMenu, RoleMenuDao>
{
	public  List<UrlRoleBean> getUrlRoles();
}
