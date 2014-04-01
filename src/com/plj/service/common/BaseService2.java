package com.plj.service.common;

import java.util.List;
import java.util.Map;

import com.plj.dao.common.BaseDao;

public interface BaseService2<T, D extends BaseDao<T>> 
{
	public int insert(T param);
	
	public int insertList(List<T> param	);
	
	public int updateByPrimaryKey(T param);
	
	public int updateByPrimaryKeySelective(T param);
	
	public int updateByExampleSelective(T value, T param);
	
	public T selectByPrimaryKey(Object value); 
	
	public List<T> selectList(Map<String, ? extends Object> param);
	
	public int deleteByPrimaryKeys(List<? extends Object> keys);
	
	public int deleteByKeys(Map<String, ? extends Object> params);
}