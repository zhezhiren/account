package com.plj.domain.base.admin.sys;

import java.util.Date;

public class BaseUser {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user_t.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user_t.user_name
     *
     * @mbggenerated
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user_t.password
     *
     * @mbggenerated
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user_t.nickname
     *
     * @mbggenerated
     */
    private String nickname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user_t.real_name
     *
     * @mbggenerated
     */
    private String realName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user_t.email
     *
     * @mbggenerated
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user_t.status
     *
     * @mbggenerated
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user_t.register_time
     *
     * @mbggenerated
     */
    private Date registerTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user_t.register_ip
     *
     * @mbggenerated
     */
    private String registerIp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user_t.register_address
     *
     * @mbggenerated
     */
    private String registerAddress;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user_t.id
     *
     * @return the value of sys_user_t.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user_t.id
     *
     * @param id the value for sys_user_t.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user_t.user_name
     *
     * @return the value of sys_user_t.user_name
     *
     * @mbggenerated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user_t.user_name
     *
     * @param userName the value for sys_user_t.user_name
     *
     * @mbggenerated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user_t.password
     *
     * @return the value of sys_user_t.password
     *
     * @mbggenerated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user_t.password
     *
     * @param password the value for sys_user_t.password
     *
     * @mbggenerated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user_t.nickname
     *
     * @return the value of sys_user_t.nickname
     *
     * @mbggenerated
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user_t.nickname
     *
     * @param nickname the value for sys_user_t.nickname
     *
     * @mbggenerated
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user_t.real_name
     *
     * @return the value of sys_user_t.real_name
     *
     * @mbggenerated
     */
    public String getRealName() {
        return realName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user_t.real_name
     *
     * @param realName the value for sys_user_t.real_name
     *
     * @mbggenerated
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user_t.email
     *
     * @return the value of sys_user_t.email
     *
     * @mbggenerated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user_t.email
     *
     * @param email the value for sys_user_t.email
     *
     * @mbggenerated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user_t.status
     *
     * @return the value of sys_user_t.status
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user_t.status
     *
     * @param status the value for sys_user_t.status
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user_t.register_time
     *
     * @return the value of sys_user_t.register_time
     *
     * @mbggenerated
     */
    public Date getRegisterTime() {
        return registerTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user_t.register_time
     *
     * @param registerTime the value for sys_user_t.register_time
     *
     * @mbggenerated
     */
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user_t.register_ip
     *
     * @return the value of sys_user_t.register_ip
     *
     * @mbggenerated
     */
    public String getRegisterIp() {
        return registerIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user_t.register_ip
     *
     * @param registerIp the value for sys_user_t.register_ip
     *
     * @mbggenerated
     */
    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp == null ? null : registerIp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user_t.register_address
     *
     * @return the value of sys_user_t.register_address
     *
     * @mbggenerated
     */
    public String getRegisterAddress() {
        return registerAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user_t.register_address
     *
     * @param registerAddress the value for sys_user_t.register_address
     *
     * @mbggenerated
     */
    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress == null ? null : registerAddress.trim();
    }
}