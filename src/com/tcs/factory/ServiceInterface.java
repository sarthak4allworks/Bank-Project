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

public interface ServiceInterface {
	public int authenticateEmployee(String employeeId, String password) throws SQLException;
	public String createCustomer(Customer customer) throws SQLException;
	public String createAccount(Account account, String customerId) throws SQLException;
	public ArrayList<Customer> doTransaction(long amount, String source, String target) throws SQLException, AccountNotCurrentException, AccountNotExistException, TransferNotAllowedException;
	public ArrayList<Transaction> getTransactions(String accountId, String sdate, String edate, String number) throws SQLException, ParseException;
	public ArrayList<Transaction> getTransactions(String accountId, String number) throws SQLException;
}
