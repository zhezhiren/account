package com.plj.dao.admin.sys;

import org.springframework.stereotype.Repository;

import com.plj.dao.common.BaseDao;
import com.plj.domain.base.admin.sys.BaseUserLoginIp;
import com.plj.domain.decorate.admin.sys.UserLoginIp;

@Repository
public interface UserLoginIpDao extends BaseDao<UserLoginIp>{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_login_ip_t
     *
     * @mbggenerated
     */
    int insert(BaseUserLoginIp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_login_ip_t
     *
     * @mbggenerated
     */
    int insertSelective(BaseUserLoginIp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_login_ip_t
     *
     * @mbggenerated
     */
    BaseUserLoginIp selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_login_ip_t
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(BaseUserLoginIp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_login_ip_t
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(BaseUserLoginIp record);
}