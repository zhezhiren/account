package com.plj.common.constants;

/**
 * ϵͳ�еĳ����ֶ�ö�����ͣ�ÿһ��ö�ٴ���һ��Ϸ������ݡ�
 * @author zhezhiren
 * @since 1.0
 * @version 1.0
 * 
 */
public class FieldEnum {

	/**
	 * ���ʵ�ַͨ������
	 * @author zhezhiren
	 * @since 1.0
	 * @version 1.0
	 * 
	 */
	public enum ChannelStatus implements DropdownType
	{
		http("http", true),//httpͨ��
		https("https", true),//httpsͨ��
		none("��", true)//��ǿ��ͨ��
		;
		
		/**
		 * �����б������
		 */
		private String value;
		
		/**
		 * �Ƿ����б���չʾ��
		 * ��������һЩ�������ɺ�̨�Զ����ɣ������ڱ༭����ʾ��
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
		regix("������ʽ", true),
		none("��", true);
		
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
		all("ȫȨ����֤", true),
		rememberMe("��ס�û�������֤", true),
		none("����֤", true);
		
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
