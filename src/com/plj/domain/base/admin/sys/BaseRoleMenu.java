package com.plj.domain.base.admin.sys;

public class BaseRoleMenu {
	
	
	private Integer RoleId;
	
	
	private Integer MenuId;
	
	
    public Integer getRoleId() {
		return RoleId;
	}

	public void setRoleId(Integer roleId) {
		RoleId = roleId;
	}

	public Integer getMenuId() {
		return MenuId;
	}

	public void setMenuId(Integer menuId) {
		MenuId = menuId;
	}

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_menu_m.is_all
     *
     * @mbggenerated
     */
    private Boolean isAll;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role_menu_m.is_all
     *
     * @return the value of sys_role_menu_m.is_all
     *
     * @mbggenerated
     */
    public Boolean getIsAll() {
        return isAll;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role_menu_m.is_all
     *
     * @param isAll the value for sys_role_menu_m.is_all
     *
     * @mbggenerated
     */
    public void setIsAll(Boolean isAll) {
        this.isAll = isAll;
    }
    
    
}