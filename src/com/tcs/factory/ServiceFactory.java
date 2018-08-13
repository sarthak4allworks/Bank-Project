package com.tcs.factory;

import com.tcs.service.BankService;
import com.tcs.service.CashierService;
import com.tcs.service.ExecutiveService;

public class ServiceFactory extends AbstractFactory {
	
	public ServiceInterface getService(String serviceName)
	{
		if(serviceName == null || serviceName=="")
		{
			return null;
		}
		else if(serviceName.equalsIgnoreCase("bankservice"))
		{
			return new BankService();
		}
		else if(serviceName.equalsIgnoreCase("executiveservice"))
		{
			return new ExecutiveService();
		}
		else if(serviceName.equalsIgnoreCase("cashierservice"))
		{
			return new CashierService();
		}
		return null;
	}

	@Override
	public DaoInterface getDao(String dao) {
		return null;
	}
	
}
