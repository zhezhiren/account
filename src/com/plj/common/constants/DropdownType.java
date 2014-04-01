package com.plj.common.constants;

/**
 * 
 * @author zhezhiren
 * @since 1.0
 * @version 1.0
 *
 */
public interface DropdownType{
	
	/**
	 * 下拉列表的名称
	 */
	public String getValue();
	
	/**
	 * 是否在列表中展示，
	 * 用来处理一些下拉项由后台自动生成，无需在编辑是显示。
	 */
	public boolean isShow();
}