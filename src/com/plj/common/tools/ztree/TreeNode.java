package com.plj.common.tools.ztree;

import java.util.List;

public class TreeNode 
{
	/**
	 * �ڵ�id
	 */
	private int id;
	
	/**
	 * ��ǰ�ڵ�ĸ��ڵ�id
	 */
	private int pId;
	
	/**
	 * �ڵ�����
	 */
	private String name;
	
	/**
	 * �Ƿ��Ǹ��ڵ㣬 trueΪ�ǣ�falseΪ��Ϊ���ڵ㲢������һ�����ӽڵ㡣
	 */
	private boolean isParent;
	
	/**
	 * �Ƿ��
	 */
	private boolean open;
	
	/**
	 * �Ƿ񱻹�ѡ��true ��ʾ�ڵ������򱻹�ѡ��false ��ʾ�ڵ�������δ��ѡ
	 */
	private boolean checked;
	
	/**
	 * ͼ��·��
	 */
	private String icon;
	
	/**
	 * �ر�ʱͼ��
	 */
	private String iconClose;
	
	/**
	 * ����ʱͼ��
	 */
	private String iconOpen;
	
	/**
	 * �ӽڵ�
	 */
	private List<TreeNode> children;
	
	/**
	 * ���õ���ڵ����ݺ��ٺδ���url��ͬ������ target ����: "_blank", "_self" �� ����ָ����������
	 * ʡ�Դ����ԣ���Ĭ��Ϊ "_blank"
	 */
	private String target;
	
	/**
	 * �ڵ����ӵ�Ŀ�� URL
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
