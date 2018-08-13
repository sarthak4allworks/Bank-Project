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

public abstract class CashierServiceAbstractClass implements ServiceInterface {
	
	public int authenticateEmployee(String employeeId, String password) throws SQLException{return 0;}
	public String createCustomer(Customer customer) throws SQLException{return null;}
	public String createAccount(Account account, String customerId) throws SQLException{return null;}

	/*This method is used for transaction
	 * (non-Javadoc)
	 * @see com.tcs.interfaces.ServiceInterface#authenticateEmployee(java.lang.String, java.lang.String)
	 */
	public abstract ArrayList<Customer> doTransaction(long amount, String source, String target) throws SQLException, AccountNotCurrentException, AccountNotExistException, TransferNotAllowedException;
	
	/*This method is used for getting the transaction by date
	 * (non-Javadoc)
	 * @see com.tcs.interfaces.ServiceInterface#authenticateEmployee(java.lang.String, java.lang.String)
	 */
	public abstract ArrayList<Transaction> getTransactions(String accountId, String sdate, String edate, String number) throws SQLException, ParseException;
	
	/*This method is used for getting transaction by number
	 * (non-Javadoc)
	 * @see com.tcs.interfaces.ServiceInterface#authenticateEmployee(java.lang.String, java.lang.String)
	 */
	public abstract ArrayList<Transaction> getTransactions(String accountId, String number) throws SQLException;
	
}
