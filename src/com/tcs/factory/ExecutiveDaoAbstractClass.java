package com.tcs.factory;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import com.tcs.bean.Account;
import com.tcs.bean.Customer;
import com.tcs.bean.Transaction;

public abstract class ExecutiveDaoAbstractClass implements DaoInterface {
	public int authenticateEmployee(String employeeId, String password) throws SQLException{return 0;}
	public int selectRoleOfEmployee(String employeeId, String password) throws SQLException{return 0;}
	
	
	public abstract int insertCustomerInformation(Customer customer) throws SQLException;
	public abstract String retrieveCustomerId(Customer customer) throws SQLException;
	public abstract String createCustomer(Customer customer) throws SQLException;
	public abstract String createAccount(Account account, String customerId) throws SQLException;
	public abstract boolean checkAccountExist(Account account, String customerId) throws SQLException;
	public abstract String newAccount(Account account, String customerId) throws SQLException;
	
	
	public HashMap<String, Long> getAccountInformation(String accountNo) throws SQLException{return null;}
	public void insertTransaction(long amount, String source, String target, String status) throws SQLException{}
	public Customer getCustomer(String accountno)throws SQLException{return null;}
	public void updateAccount(long balance, String accountNo) throws SQLException{}
	public ArrayList<Transaction> getTransactions(String accountId, String sdate, String edate, String number) throws SQLException, ParseException{return null;}
	public ArrayList<Transaction> getTransactions(String accountId, String number) throws SQLException{return null;}
}
