package com.plj.service.admin.sys;

import java.util.List;

import com.plj.dao.admin.sys.UrlInfoDao;
import com.plj.domain.decorate.admin.sys.UrlInfo;
import com.plj.service.common.BaseService;

public interface UrlInfoService extends BaseService<UrlInfo, UrlInfoDao>{
	public Integer deleteUrlInfoByMenuId(List<Integer> menuIds);
}
