package com.plj.common.constants;

/**
 * 系统中的常量字段枚举类型，每一个枚举代表一类合法的数据。
 * @author zhezhiren
 * @since 1.0
 * @version 1.0
 * 
 */
public class FieldEnum {

	/**
	 * 访问地址通道类型
	 * @author zhezhiren
	 * @since 1.0
	 * @version 1.0
	 * 
	 */
	public enum ChannelStatus implements DropdownType
	{
		http("http", true),//http通道
		https("https", true),//https通道
		none("无", true)//不强制通道
		;
		
		/**
		 * 下拉列表的名称
		 */
		private String value;
		
		/**
		 * 是否在列表中展示，
		 * 用来处理一些下拉项由后台自动生成，无需在编辑是显示。
		 */
		private boolean show;
		
		ChannelStatus(String value, boolean show)
		{
			this.value = value;
			this.show = show;
		}

		@Override
		public String getValue() 
		{
			return value;
		}

		@Override
		public boolean isShow() 
		{
			return show;
		}
	}
	
	public enum MatchType implements DropdownType
	{
		ant("ant", true),
		regix("正则表达式", true),
		none("无", true);
		
		MatchType(String value, boolean show)
		{
			this.value = value;
			this.show = show;
		}
		
		private String value;
		private boolean show;
		
		@Override
		public String getValue() 
		{
			return value;
		}

		@Override
		public boolean isShow()
		{
			return show;
		}
	}
	
	public enum AuthType implements DropdownType{
		all("全权限验证", true),
		rememberMe("记住用户密码验证", true),
		none("无验证", true);
		
		AuthType(String value, boolean show)
		{
			this.value = value;
			this.show = show;
		}
		
		private String value;
		private boolean show;
		
		@Override
		public String getValue()
		{
			return value;
		}

		@Override
		public boolean isShow()
		{
			return show;
		}
	}
}
