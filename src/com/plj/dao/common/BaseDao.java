package com.plj.dao.common;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BaseDao<T>
{
	public int insert(T param);
	
	public int insertSelective(T record);
	
	public int insertList(List<T> param);
	
	public int updateByPrimaryKey(T param);
	
	public int updateByPrimaryKeySelective(T param);
	
	public int updateByExampleSelective(Map<String, T> param);
	
	public T selectByPrimaryKey(Object value); 
	
	public List<T> selectList(Map<String, ? extends Object> param);
	
	public int deleteByPrimaryKeys(@Param("keys") List<? extends Object> keys);
	
	public int deleteByKeys(Map<String, ? extends Object> params);
}
