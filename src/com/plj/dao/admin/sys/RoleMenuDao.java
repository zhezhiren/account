package com.plj.dao.admin.sys;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.plj.dao.common.BaseDao;
import com.plj.domain.bean.admin.sys.UrlRoleBean;
import com.plj.domain.decorate.admin.sys.RoleMenu;

@Repository
public interface RoleMenuDao extends BaseDao<RoleMenu>{
	@Override
    public int insert(RoleMenu record);

	public int insertSelective(RoleMenu record);

    @Override
    int updateByPrimaryKeySelective(RoleMenu record);

    @Override
    public int updateByPrimaryKey(RoleMenu record);
    
    public  List<UrlRoleBean> getUrlRoles();
    
}