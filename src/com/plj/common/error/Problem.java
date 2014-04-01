package com.plj.common.error;

import java.io.Serializable;

/**
 * 错误消息对象
 * @author zhengxing
 * @version 1.0
 * @date 2013.1.17
 */
public class Problem implements ErrorCode , ErrorMsg, Serializable
{
	public Problem()
	{
		
	}
	
	public Problem(String code, String msg)
	{
		this.problemCode = code;
		this.problemMsg = msg;
	}
	
	public String getProblemCode()
    {
    	return problemCode;
    }

	public void setProblemCode(String errorCode)
    {
    	this.problemCode = errorCode;
    }

	public String getProblemMsg()
    {
    	return problemMsg;
    }

	public void setProblemMsg(String errorMsg)
    {
    	this.problemMsg = errorMsg;
    }
	
	public int hashCode ()
	{
		if (Integer.MIN_VALUE == this.hashCode) 
		{
			if (null == this.problemCode)
			{
				return super.hashCode();
			}else
			{
				String hashStr = this.getClass().getName() + ":" + this.problemCode.hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}
	
	public boolean equals(Object obj)
	{
		if (null == obj)
		{ 
			return false;
		}
		if (!(obj instanceof Problem))
		{
			return false;
		}else
		{
			Problem error = (Problem) obj;
			if (null == this.problemCode || null == error.getProblemCode())
			{
				return false;
			}else
			{
				return (this.problemCode.equals(error.getProblemCode()));
			}
		}
	}
	
	private String problemCode;
	
	private String problemMsg;
	
	private static final long serialVersionUID = 8537290776237780557L;
	
	private int hashCode = Integer.MIN_VALUE;;
}
