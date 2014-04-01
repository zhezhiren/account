package com.plj.common.tools.springsecurity;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
//import org.springframework.security.web.util.AntUrlPathMatcher;
//import org.springframework.security.web.util.UrlMatcher;

import com.plj.domain.bean.admin.sys.UrlRoleBean;
import com.plj.service.admin.sys.RoleMenuService;

/**
 * 
 * 此类在初始化时，应该取到所有资源及其对应角色的定义
 * 
 * @author Robin
 * 
 */
public class MyInvocationSecurityMetadataSource 
        implements FilterInvocationSecurityMetadataSource 
{
    //private UrlMatcher urlMatcher = new AntPathRequestMatcher();;
    private static Map<String, Set<ConfigAttribute>> resourceMap = new HashMap<String, Set<ConfigAttribute>>();;
    
    private RoleMenuService roleMenuService;
    
    public MyInvocationSecurityMetadataSource(RoleMenuService roleMenuService)
    {
    	setRoleMenuService(roleMenuService);
        loadResourceDefine();
    }
    
    private void loadResourceDefine() 
    {
    	List<UrlRoleBean> urlRoles = roleMenuService.getUrlRoles();
    	if(null != urlRoles && urlRoles.size() > 0)
    	{
    		for(int i = 0; i < urlRoles.size(); i++)
    		{
    			UrlRoleBean url = urlRoles.get(i);
    			Set<ConfigAttribute> roles = resourceMap.get(urlRoles.get(i).getUrl());
    			if(roles == null)
    			{
    				roles = new HashSet<ConfigAttribute>();
    			}
    			SecurityConfig config = new SecurityConfig(String.valueOf(url.getRoleId()));
    			roles.add(config);
    			resourceMap.put(url.getUrl(), roles);
    		}
    	}
    }

    public Collection<ConfigAttribute> getAttributes(Object object)
            throws IllegalArgumentException 
    {
        String url = ((FilterInvocation)object).getRequestUrl();
        return resourceMap.get(url);
    }

    public boolean supports(Class<?> clazz) 
    {
    	return FilterInvocation.class.isAssignableFrom(clazz);
    }
    
    public Collection<ConfigAttribute> getAllConfigAttributes()
    {
    	Set<ConfigAttribute> allAttributes = new HashSet<ConfigAttribute>();
        for (Map.Entry<String, Set<ConfigAttribute>> entry : resourceMap.entrySet()) 
        {
            allAttributes.addAll(entry.getValue());
        }
        return allAttributes;
    }

	public void setRoleMenuService(RoleMenuService roleMenuService)
	{
		this.roleMenuService = roleMenuService;
	}

}