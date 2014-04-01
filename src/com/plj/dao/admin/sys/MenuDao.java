package com.plj.dao.admin.sys;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.plj.dao.common.BaseDao;
import com.plj.domain.base.admin.sys.BaseMenu;
import com.plj.domain.decorate.admin.sys.Menu;

@Repository
public interface MenuDao extends BaseDao<Menu>
{
    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    
    int selectMaxRight();
    
    int updateRgt(Map<String, Object> param);
    
    int updateLft(Map<String, Object> param);
}