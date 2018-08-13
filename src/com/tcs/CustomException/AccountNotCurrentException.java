package com.tcs.CustomException;

@SuppressWarnings("serial")
public class AccountNotCurrentException extends Exception
{
	public AccountNotCurrentException(String str)
	{
		super(str); 
	}
}
