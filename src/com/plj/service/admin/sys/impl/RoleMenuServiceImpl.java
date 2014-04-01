package com.plj.service.admin.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plj.dao.admin.sys.RoleMenuDao;
import com.plj.domain.bean.admin.sys.UrlRoleBean;
import com.plj.domain.decorate.admin.sys.RoleMenu;
import com.plj.service.admin.sys.RoleMenuService;
import com.plj.service.common.impl.BaseServiceImpl;

@Service("roleMenuService")
public class RoleMenuServiceImpl extends BaseServiceImpl<RoleMenu, RoleMenuDao> 
		implements RoleMenuService 
{
	@Autowired
	private RoleMenuDao dao;

	@Override
	public List<UrlRoleBean> getUrlRoles() 
	{
		return dao.getUrlRoles();
	}
	
	@Override
	protected RoleMenuDao getDao() 
	{
		return this.dao;
	}
}
