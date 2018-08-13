package com.tcs.factory;

import com.tcs.dao.BankDAO;
import com.tcs.dao.CashierDAO;
import com.tcs.dao.ExecutiveDAO;

public class DaoFactory extends AbstractFactory {

	public DaoInterface getDao(String daoName)
	{
		if(daoName =="" || daoName==null)
		{
			return null;
		}
		else if(daoName.equalsIgnoreCase("bankDao"))
		{
			return new BankDAO();
		}
		else if(daoName.equalsIgnoreCase("executiveDao"))
		{
			return new ExecutiveDAO();
		}
		else if(daoName.equalsIgnoreCase("cashierDao"))
		{
			return new CashierDAO();
		}
		return null;
	}

	@Override
	public ServiceInterface getService(String service) {
		return null;
	}
}
