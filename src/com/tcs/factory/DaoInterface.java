package com.tcs.factory;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import com.tcs.bean.Account;
import com.tcs.bean.Customer;
import com.tcs.bean.Transaction;

public interface DaoInterface {
	/*
	 * This method is used for authenticate the employee and decided their role
	 * @see com.tcs.interfaces.DaoInterface#authenticateEmployee(java.lang.String, java.lang.String)
	 */
	public int authenticateEmployee(String employeeId, String password) throws SQLException;
	
	/*
	 * This method is used for selecting the role of the logged in employee
	 */
	public int selectRoleOfEmployee(String employeeId, String password) throws SQLException;
	
	/*
	 * This method is used for insert the information of the new customer
	 */
	public int insertCustomerInformation(Customer customer) throws SQLException;
	
	/*
	 * This method is for retrive the customer id of the newly insert customer
	 */
	public String retrieveCustomerId(Customer customer) throws SQLException;
	
	/*
	 * This method is used for create new customer by the executive
	 * (non-Javadoc)
	 * @see com.tcs.interfaces.DaoInterface#createCustomer(com.tcs.bean.Customer)
	 */
	public String createCustomer(Customer customer) throws SQLException;
	
	/*
	 * This method is used for creating the account for the customer
	 * (non-Javadoc)
	 * @see com.tcs.interfaces.DaoInterface#createAccount(com.tcs.bean.Account, java.lang.String)
	 */
	public String createAccount(Account account, String customerId) throws SQLException;
	
	/*
	 * Used to check that account is exist or not for a particular customer
	 */
	public boolean checkAccountExist(Account account, String customerId) throws SQLException;
	
	/*
	 * Used to create a new account
	 */
	public String newAccount(Account account, String customerId) throws SQLException;
	
	/*
	 * This method is used to retrieve the account information
	 * Key contains the account number and long contains the amount in that account
	 */
	public HashMap<String, Long> getAccountInformation(String accountNo) throws SQLException;
	
	/*
	 * This is used to insert all the failed transactions
	 */
	public void insertTransaction(long amount, String source, String target, String status) throws SQLException;
	
	/*
	 * This is used to retrieve the account owner information
	 */
	public Customer getCustomer(String accountno)throws SQLException;
	
	/*
	 * This is used for update the account after every transaction
	 */
	public void updateAccount(long balance, String accountNo) throws SQLException;
	
	/*
	 * This method is used for getting the information about all the transactions in between the given dates
	 * (non-Javadoc)
	 * @see com.tcs.interfaces.DaoInterface#getTransactions(java.lang.String, java.lang.String, java.lang.String)
	 */
	public ArrayList<Transaction> getTransactions(String accountId, String sdate, String edate, String number) throws SQLException, ParseException;
	
	/*
	 * This method is used for getting the information about the transactions the number of transaction is given by the employee
	 * (non-Javadoc)
	 * @see com.tcs.interfaces.DaoInterface#getTransactions(java.lang.String, java.lang.String)
	 */
	public ArrayList<Transaction> getTransactions(String accountId, String number) throws SQLException;
}
