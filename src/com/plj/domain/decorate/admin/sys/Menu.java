package com.plj.domain.decorate.admin.sys;

import java.util.List;

import com.plj.common.tools.ztree.TreeNode;
import com.plj.domain.base.admin.sys.BaseMenu;

public class Menu extends BaseMenu 
{
	/**
	 * �Ƿ��
	 */
	private boolean open = true;
	
	/**
	 * �Ƿ񱻹�ѡ��true ��ʾ�ڵ������򱻹�ѡ��false ��ʾ�ڵ�������δ��ѡ
	 */
	private boolean checked;
	
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
