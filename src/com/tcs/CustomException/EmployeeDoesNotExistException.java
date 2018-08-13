package com.tcs.CustomException;

public class EmployeeDoesNotExistException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public EmployeeDoesNotExistException(String str)
	{
		super(str);
	}
}
