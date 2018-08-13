package com.tcs.CustomException;

@SuppressWarnings("serial")
public class AccountNotExistException extends Exception
{
	public AccountNotExistException(String str)
	{
		super(str);
	}
}
