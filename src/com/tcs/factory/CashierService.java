package com.tcs.factory;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import com.tcs.CustomException.AccountNotCurrentException;
import com.tcs.CustomException.AccountNotExistException;
import com.tcs.CustomException.TransferNotAllowedException;
import com.tcs.bean.Customer;
import com.tcs.bean.Transaction;

public interface CashierService {
	/*This method is used for transaction
	 * (non-Javadoc)
	 * @see com.tcs.interfaces.ServiceInterface#authenticateEmployee(java.lang.String, java.lang.String)
	 */
	public ArrayList<Customer> doTransaction(long amount, String source, String target) throws SQLException, AccountNotCurrentException, AccountNotExistException, TransferNotAllowedException;
	
	/*This method is used for getting the transaction by date
	 * (non-Javadoc)
	 * @see com.tcs.interfaces.ServiceInterface#authenticateEmployee(java.lang.String, java.lang.String)
	 */
	public ArrayList<Transaction> getTransactions(String accountId, String sdate, String edate) throws SQLException, ParseException;
	
	/*This method is used for getting transaction by number
	 * (non-Javadoc)
	 * @see com.tcs.interfaces.ServiceInterface#authenticateEmployee(java.lang.String, java.lang.String)
	 */
	public ArrayList<Transaction> getTransactions(String accountId, String number) throws SQLException;
}
