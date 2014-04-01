package com.plj.common.exception;

/**
 * 数据库插入记录时，参数异常时抛出该错误。
 * @author zhezhiren
 *
 */
public class ParameterException extends Exception {

	private static final long serialVersionUID = -353801902075650381L;

	public ParameterException() 
	{
		// TODO Auto-generated constructor stub
	}

	public ParameterException(String message) 
	{
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ParameterException(Throwable cause) 
	{
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public ParameterException(String message, Throwable cause)
	{
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
