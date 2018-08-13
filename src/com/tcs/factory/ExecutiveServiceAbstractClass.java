package com.tcs.factory;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import com.tcs.CustomException.AccountNotCurrentException;
import com.tcs.CustomException.AccountNotExistException;
import com.tcs.CustomException.TransferNotAllowedException;
import com.tcs.bean.Account;
import com.tcs.bean.Customer;
import com.tcs.bean.Transaction;

public abstract class ExecutiveServiceAbstractClass implements ServiceInterface {
	
	public int authenticateEmployee(String employeeId, String password) throws SQLException{return 0;}

	/*This method is used for create the customer
	 * (non-Javadoc)
	 * @see com.tcs.interfaces.ServiceInterface#authenticateEmployee(java.lang.String, java.lang.String)
	 */
	public abstract String createCustomer(Customer customer) throws SQLException;
	
	/*This method is used for create account for customer
	 * (non-Javadoc)
	 * @see com.tcs.interfaces.ServiceInterface#authenticateEmployee(java.lang.String, java.lang.String)
	 */
	public abstract String createAccount(Account account, String customerId) throws SQLException;
	
	public ArrayList<Customer> doTransaction(long amount, String source, String target) throws SQLException, AccountNotCurrentException, AccountNotExistException, TransferNotAllowedException{return null;}
	public ArrayList<Transaction> getTransactions(String accountId, String sdate, String edate, String number) throws SQLException, ParseException{return null;}
	public ArrayList<Transaction> getTransactions(String accountId, String number) throws SQLException{return null;}
	
}
