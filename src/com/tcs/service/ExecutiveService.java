package com.tcs.service;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.tcs.bean.Account;
import com.tcs.bean.Customer;
import com.tcs.factory.AbstractFactory;
import com.tcs.factory.DaoInterface;
import com.tcs.factory.ExecutiveServiceAbstractClass;
import com.tcs.factory.FactoryProducer;

public class ExecutiveService extends ExecutiveServiceAbstractClass {

	private static Logger logger = Logger.getLogger(ExecutiveService.class);
	
	/*This method is used for create the customer
	 * (non-Javadoc)
	 * @see com.tcs.interfaces.ServiceInterface#authenticateEmployee(java.lang.String, java.lang.String)
	 */
	public String createCustomer(Customer customer) throws SQLException {
		logger.info("Inside createCustomer Service");
		String i = null;
		AbstractFactory bankDaoFactory = FactoryProducer.getFactory("DAO");
		DaoInterface dao = bankDaoFactory.getDao("executiveDao");
		i = dao.createCustomer(customer);
		System.out.println(i+" in bank service");
		if(i.equalsIgnoreCase(""))
		{
			int j = dao.insertCustomerInformation(customer);
			if(j>0)
			{
				i = dao.retrieveCustomerId(customer);
			}
		}
		else
		{
			logger.error("Customer Already Exist");
		}
		logger.info("Exit createCustomer Service");
		return i;
	}
	
	/*This method is used for create account for customer
	 * (non-Javadoc)
	 * @see com.tcs.interfaces.ServiceInterface#authenticateEmployee(java.lang.String, java.lang.String)
	 */
	public String createAccount(Account account, String customerId) throws SQLException {
		logger.info("Inside createAccount Service");
		String str = null;
		AbstractFactory bankDaoFactory = FactoryProducer.getFactory("DAO");
		DaoInterface dao = bankDaoFactory.getDao("executiveDao");
		str = dao.createAccount(account, customerId);
		if(str.equals("false"))
		{
			logger.error("Customer Does Not Exist");
			str = "CustomerDoesNotExist";
		}
		else
		{
			boolean flag = dao.checkAccountExist(account, customerId);
			if(flag == true)
			{
				logger.error("Account Already Exist");
				str = "AccountExist";
			}
			else
			{
				str = dao.newAccount(account, customerId);
			}
		}
		logger.info("Exit createAccount Service");
		return str;
	}

}
