package com.plj.domain.decorate.admin.sys;

import java.util.List;

import com.plj.common.tools.ztree.TreeNode;
import com.plj.domain.base.admin.sys.BaseMenu;

public class Menu extends BaseMenu 
{
	/**
	 * 是否打开
	 */
	private boolean open = true;
	
	/**
	 * 是否被勾选，true 表示节点的输入框被勾选，false 表示节点的输入框未勾选
	 */
	private boolean checked;
	
	/**
	 * 关闭时图标
	 */
	private String iconClose;
	
	/**
	 * 开启时图标
	 */
	private String iconOpen;
	
	/**
	 * 子节点
	 */
	private List<TreeNode> children;
	
	/**
	 * 设置点击节点内容后再何处打开url。同超链接 target 属性: "_blank", "_self" 或 其他指定窗口名称
	 * 省略此属性，则默认为 "_blank"
	 */
	private String target;
	
	/**
	 * 节点链接的目标 URL
	 */
	private String url;

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getIconClose() {
		return iconClose;
	}

	public void setIconClose(String iconClose) {
		this.iconClose = iconClose;
	}

	public String getIconOpen() {
		return iconOpen;
	}

	public void setIconOpen(String iconOpen) {
		this.iconOpen = iconOpen;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
