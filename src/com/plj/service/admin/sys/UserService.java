package com.plj.service.admin.sys;

import com.plj.dao.admin.sys.UserDao;
import com.plj.domain.decorate.admin.sys.User;
import com.plj.service.common.BaseService;

public interface UserService extends BaseService<User, UserDao>
{
	public User loadUserByName(String username);
}
