package com.tcs.service;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.tcs.factory.AbstractFactory;
import com.tcs.factory.BankServiceAbstractClass;
import com.tcs.factory.DaoInterface;
import com.tcs.factory.FactoryProducer;

public class BankService extends BankServiceAbstractClass {
	
	private static Logger logger = Logger.getLogger(BankService.class);
	
	/*This method is used for authenticate the employee
	 * (non-Javadoc)
	 * @see com.tcs.interfaces.ServiceInterface#authenticateEmployee(java.lang.String, java.lang.String)
	 */
	public int authenticateEmployee(String employeeId, String password) throws SQLException {
		logger.info("Inside authenticate Employee Service");
		AbstractFactory bankDaoFactory = FactoryProducer.getFactory("DAO");
		DaoInterface dao = bankDaoFactory.getDao("bankDao");
		int i = dao.authenticateEmployee(employeeId, password);
		if(i>0)
		{
			i = dao.selectRoleOfEmployee(employeeId, password);
		}
		else
		{
			logger.error("Employee is not authorize");
		}
		logger.info("Exit authenticate Employee Service");
		return i;
	}
}
