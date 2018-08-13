package com.tcs.factory;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import com.tcs.bean.Account;
import com.tcs.bean.Customer;
import com.tcs.bean.Transaction;

public abstract class CashierDaoAbstractClass implements DaoInterface {
	
	public int authenticateEmployee(String employeeId, String password) throws SQLException{return 0;}
	public int selectRoleOfEmployee(String employeeId, String password) throws SQLException{return 0;}
	
	public int insertCustomerInformation(Customer customer) throws SQLException{return 0;}
	public String retrieveCustomerId(Customer customer) throws SQLException{return null;}
	public String createCustomer(Customer customer) throws SQLException{return null;}
	public String createAccount(Account account, String customerId) throws SQLException{return null;}
	public boolean checkAccountExist(Account account, String customerId) throws SQLException{return false;}
	public String newAccount(Account account, String customerId) throws SQLException{return null;}
	
	public abstract HashMap<String, Long> getAccountInformation(String accountNo) throws SQLException;
	public abstract void insertTransaction(long amount, String source, String target, String status) throws SQLException;
	public abstract Customer getCustomer(String accountno)throws SQLException;
	public abstract void updateAccount(long balance, String accountNo) throws SQLException;
	public abstract ArrayList<Transaction> getTransactions(String accountId, String sdate, String edate, String number) throws SQLException, ParseException;
	public abstract ArrayList<Transaction> getTransactions(String accountId, String number) throws SQLException;

}
