package com.plj.service.admin.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plj.dao.admin.sys.UrlInfoDao;
import com.plj.domain.decorate.admin.sys.UrlInfo;
import com.plj.service.admin.sys.UrlInfoService;
import com.plj.service.common.impl.BaseServiceImpl;

@Service("urlInfoService")
public class UrlInfoServiceImpl extends BaseServiceImpl<UrlInfo, UrlInfoDao> implements UrlInfoService {

	@Autowired
	UrlInfoDao dao;
	
	@Override
	protected UrlInfoDao getDao() 
	{
		return dao;
	}
	
	public Integer deleteUrlInfoByMenuId(List<Integer> menuIds)
	{
		return dao.deleteUrlInfoByMenuIds(menuIds);
	}
	
	
	

}
