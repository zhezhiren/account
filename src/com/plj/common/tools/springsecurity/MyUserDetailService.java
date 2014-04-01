package com.plj.common.tools.springsecurity;


import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.plj.domain.decorate.admin.sys.User;
import com.plj.service.admin.sys.UserService;

public class MyUserDetailService implements UserDetailsService
{
	UserService userService;
	
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException 
    {
    	User user = userService.loadUserByName(username);
        return user;
    }

	public UserService getUserService()
	{
		return userService;
	}

	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}

}