package com.tcs.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.tcs.CustomException.AccountNotCurrentException;
import com.tcs.CustomException.AccountNotExistException;
import com.tcs.CustomException.TransferNotAllowedException;
import com.tcs.bean.Customer;
import com.tcs.bean.Transaction;
import com.tcs.factory.AbstractFactory;
import com.tcs.factory.CashierServiceAbstractClass;
import com.tcs.factory.DaoInterface;
import com.tcs.factory.FactoryProducer;

public class CashierService extends CashierServiceAbstractClass {

	private static Logger logger = Logger.getLogger(CashierService.class);
	
	/*This method is used for transaction
	 * (non-Javadoc)
	 * @see com.tcs.interfaces.ServiceInterface#authenticateEmployee(java.lang.String, java.lang.String)
	 */
	public ArrayList<Customer> doTransaction(long amount, String source, String target) throws SQLException, AccountNotCurrentException, AccountNotExistException, TransferNotAllowedException {
		logger.info("Inside doTransaction Service");
		ArrayList<Customer> cList = new ArrayList<>();
		AbstractFactory bankDaoFactory = FactoryProducer.getFactory("DAO");
		DaoInterface dao = bankDaoFactory.getDao("cashierDao");
		long sourceBalance = 0;
		long targetBalance = 0;
		String accountType="";
		
		HashMap<String, Long> accountInformation = dao.getAccountInformation(source);
		for(Map.Entry<String, Long> map: accountInformation.entrySet())
		{
			accountType = map.getKey();
			sourceBalance = map.getValue();
		}
		if(accountType.equalsIgnoreCase("CURRENT"))
		{
			accountInformation = dao.getAccountInformation(target);
			if(accountInformation.size()>0)
			{
				for(Map.Entry<String, Long> map: accountInformation.entrySet())
				{
					targetBalance = map.getValue();
				}
				if((sourceBalance-amount)>=0)
				{
					Customer sourceCustomer = dao.getCustomer(source);
					Customer targetCustomer = dao.getCustomer(target);
					dao.insertTransaction(amount, source, target, "SUCCESS");
					cList.add(sourceCustomer);
					cList.add(targetCustomer);
					dao.updateAccount((sourceBalance-amount), source);
					dao.updateAccount((targetBalance+amount), target);
				}
				else
				{
					logger.error("Amount is too large to transfer");
					dao.insertTransaction(amount, source, target, "FAILED");
					throw new TransferNotAllowedException("Transfer not allowed, please choose smaller amount");
				}
			}
			else
			{
				logger.error("Target account is not exist");
				throw new AccountNotExistException("The Target Account is not Exist");
			}
		}
		else
		{
			logger.error("Source account is not the current account");
			throw new AccountNotCurrentException("The source account is not a current account");
		}
		logger.info("Inside doTransaction Service");
		return cList;
	}

	/*This method is used for getting the transaction by date
	 * (non-Javadoc)
	 * @see com.tcs.interfaces.ServiceInterface#authenticateEmployee(java.lang.String, java.lang.String)
	 */
	public ArrayList<Transaction> getTransactions(String accountId, String sdate, String edate, String number) throws SQLException, ParseException {
		logger.info("Inside getTransactions Service");
		ArrayList<Transaction> tList = new ArrayList<>();
		AbstractFactory bankDaoFactory = FactoryProducer.getFactory("DAO");
		DaoInterface dao = bankDaoFactory.getDao("cashierDao");
		tList = dao.getTransactions(accountId, sdate, edate, number);
		logger.info("Inside getTransactions Service");
		return tList;
	}
	
	/*This method is used for getting transaction by number
	 * (non-Javadoc)
	 * @see com.tcs.interfaces.ServiceInterface#authenticateEmployee(java.lang.String, java.lang.String)
	 */
	public ArrayList<Transaction> getTransactions(String accountId, String number) throws SQLException
	{
		logger.info("Inside getTransactions Service");
		ArrayList<Transaction> tList = new ArrayList<>();
		AbstractFactory bankDaoFactory = FactoryProducer.getFactory("DAO");
		DaoInterface dao = bankDaoFactory.getDao("cashierDao");
		tList = dao.getTransactions(accountId, number);
		logger.info("Inside getTransactions Service");
		return tList;
	}
}
