package com.plj.domain.decorate.admin.sys;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.plj.domain.base.admin.sys.BaseUser;


public class User extends BaseUser implements UserDetails, CredentialsContainer
{
	private static final long serialVersionUID = 942760465147476805L;
	
	private List<Integer> roleIds; 
	
	private List<GrantedAuthority> authority;
	
	@Override
	public void eraseCredentials()
	{
		setPassword(null);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		if(authority != null)
		{
			return authority;
		}else
		{
			if(roleIds == null)
			{
				return null;
			}else
			{
				authority = new ArrayList<GrantedAuthority>(roleIds.size());
				for(int i = 0; i < roleIds.size(); i++)
				{
					authority.add(new SimpleGrantedAuthority(String.valueOf(roleIds.get(i))));
				}
				return authority;
			}
		}
	}

	@Override
	public boolean isAccountNonExpired()
	{
		return true;
	}

	@Override
	public boolean isAccountNonLocked()
	{
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired()
	{
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled()
	{
		return true;
	}

	public List<Integer> getRoleIds() 
	{
		return roleIds;
	}

	public void setRoleIds(List<Integer> roleIds)
	{
		this.roleIds = roleIds;
	}
	
	public void initUserDetails()
	{
		//TODO
	}
	
}
