package com.plj.common.tools.ztree;

import java.util.List;

public class TreeNode 
{
	/**
	 * 节点id
	 */
	private int id;
	
	/**
	 * 当前节点的父节点id
	 */
	private int pId;
	
	/**
	 * 节点名称
	 */
	private String name;
	
	/**
	 * 是否是父节点， true为是，false为否。为父节点并不代表一定有子节点。
	 */
	private boolean isParent;
	
	/**
	 * 是否打开
	 */
	private boolean open;
	
	/**
	 * 是否被勾选，true 表示节点的输入框被勾选，false 表示节点的输入框未勾选
	 */
	private boolean checked;
	
	/**
	 * 图标路径
	 */
	private String icon;
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPId() {
		return pId;
	}

	public void setPId(int pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(boolean isParent) {
		this.isParent = isParent;
	}

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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
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
