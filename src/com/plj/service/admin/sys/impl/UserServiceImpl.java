package com.plj.service.admin.sys.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plj.dao.admin.sys.UserDao;
import com.plj.domain.decorate.admin.sys.User;
import com.plj.service.admin.sys.UserService;
import com.plj.service.common.impl.BaseServiceImpl;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User, UserDao> implements UserService
{
	@Autowired
	UserDao dao;
	
	@Override
	protected UserDao getDao() 
	{
		return dao;
	}

	@Override
	public User loadUserByName(String username) 
	{
		return dao.loadUserByName(username);
	}
	
	

}
