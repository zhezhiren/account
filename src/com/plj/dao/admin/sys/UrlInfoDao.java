package com.plj.dao.admin.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.plj.dao.common.BaseDao;
import com.plj.domain.base.admin.sys.BaseUrlInfo;
import com.plj.domain.decorate.admin.sys.UrlInfo;

@Repository
public interface UrlInfoDao extends BaseDao<UrlInfo> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu_url_t
     *
     * @mbggenerated
     */
    int insert(BaseUrlInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu_url_t
     *
     * @mbggenerated
     */
    int insertSelective(BaseUrlInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu_url_t
     *
     * @mbggenerated
     */
    BaseUrlInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu_url_t
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(BaseUrlInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu_url_t
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(BaseUrlInfo record);
    
    Integer deleteUrlInfoByMenuIds(@Param("menuIds") List<Integer> menuIds);
}