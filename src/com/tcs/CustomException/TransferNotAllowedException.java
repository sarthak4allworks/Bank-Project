package com.tcs.CustomException;

@SuppressWarnings("serial")
public class TransferNotAllowedException extends Exception
{
	public TransferNotAllowedException(String str)
	{
		super(str);
	}
}
