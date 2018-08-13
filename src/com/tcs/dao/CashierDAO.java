package com.tcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.tcs.bean.Account;
import com.tcs.bean.Customer;
import com.tcs.bean.Transaction;
import com.tcs.factory.CashierDaoAbstractClass;
import com.tcs.interfaces.ConstantsInterface;
import com.tcs.util.DatabaseUtil;

public class CashierDAO extends CashierDaoAbstractClass implements ConstantsInterface {

	private static Logger logger = Logger.getLogger(CashierDAO.class);
	
	/*
	 * This method handles all the transactions
	 * (non-Javadoc)
	 * @see com.tcs.interfaces.DaoInterface#doTransaction(long, java.lang.String, java.lang.String)
	 */
	public HashMap<String, Long> getAccountInformation(String accountNo) throws SQLException
	{
		logger.info("Enter getAcoountInformation DAO");
		HashMap<String, Long> account = new HashMap<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try
		{
			con = DatabaseUtil.getConnection();
			String query = SELECTACCOUNTTYPE;
			pst = con.prepareStatement(query);
			pst.setString(1, accountNo);
			logger.debug(accountNo);
			rs = pst.executeQuery();
			while(rs.next())
			{
				account.put(rs.getString(1), rs.getLong(2));
				break;
			}
		}
		finally
		{
			logger.info("Close all the connections of getAccountInformation Method");
			DatabaseUtil.closeResultSet(rs);
			DatabaseUtil.closePreparedStatement(pst);
			DatabaseUtil.closeConnection(con);
		}
		logger.info("Exit getAccountInformation DAO");
		return account;
	}
	/*
	 * This method is used for inserting the failed transactions
	 * (non-Javadoc)
	 * @see com.tcs.interfaces.DaoInterface#insertFailedTransaction(long, java.lang.String, java.lang.String)
	 */
	public void insertTransaction(long amount, String source, String target, String status) throws SQLException
	{
		logger.info("Enter insertTransaction DAO");
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try
		{
			logger.info("Failed transaction");
			con = DatabaseUtil.getConnection();
			String query = INSERTTRANSACTION;
			pst = con.prepareStatement(query);
			pst.setString(1, status);
			pst.setString(2, source);
			pst.setString(3, target);
			pst.setLong(4, amount);
			logger.debug(status+" "+source+" "+target+" "+amount);
			pst.executeUpdate();
		}
		finally
		{
			logger.info("Close all the connections of insertTransaction Method");
			DatabaseUtil.closeResultSet(rs);
			DatabaseUtil.closePreparedStatement(pst);
			DatabaseUtil.closeConnection(con);
		}
		logger.info("Exit insertTransaction DAO");
	}
	
	/*
	 * This methos is used for retrieving the customer information with their account details
	 * (non-Javadoc)
	 * @see com.tcs.interfaces.DaoInterface#getCustomer(java.lang.String)
	 */
	public Customer getCustomer(String accountno)throws SQLException
	{
		logger.info("Enter getCustomer DAO");
		Customer customer = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try
		{
			con = DatabaseUtil.getConnection();
			String query = GETCUSTOMERINFO;
			pst = con.prepareStatement(query);
			pst.setString(1, accountno);
			rs = pst.executeQuery();
			while(rs.next())
			{
				logger.debug(accountno);
				customer = new Customer();
				customer.setCustomerId(rs.getString(1));
				customer.setCustomerName(rs.getString(2));
				Account account = new Account();
				account.setAccountNo(accountno);
				account.setBalance(rs.getLong(4));
				account.setType(rs.getString(3));
				ArrayList<Account> accountList = new ArrayList<>();
				accountList.add(account);
				customer.setAccountList(accountList);
			}
		}
		finally
		{
			logger.info("Close all the connections of getCustomer Method");
			DatabaseUtil.closeResultSet(rs);
			DatabaseUtil.closePreparedStatement(pst);
			DatabaseUtil.closeConnection(con);
		}
		logger.info("Exit getCustomer DAO");
		return customer;
	}
	
	/*
	 * This method is used for updating te account after any transaction
	 * (non-Javadoc)
	 * @see com.tcs.interfaces.DaoInterface#updateAccount(long, java.lang.String)
	 */
	public void updateAccount(long balance, String accountNo) throws SQLException
	{
		logger.info("Enter updateAccount DAO");
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try
		{
			con = DatabaseUtil.getConnection();
			String query = UPDATEACCOUNT;
			pst = con.prepareStatement(query);
			pst.setLong(1, balance);
			pst.setString(2, accountNo);
			logger.debug(balance+" "+accountNo);
			pst.executeUpdate();
		}
		finally
		{
			logger.info("Close all the connections of updateAccount Method");
			DatabaseUtil.closeResultSet(rs);
			DatabaseUtil.closePreparedStatement(pst);
			DatabaseUtil.closeConnection(con);
		}
		logger.info("Exit updateAccount DAO");
	}
	
	/*
	 * This method is used for getting the information about all the transactions in between the given dates
	 * (non-Javadoc)
	 * @see com.tcs.interfaces.DaoInterface#getTransactions(java.lang.String, java.lang.String, java.lang.String)
	 */
	public ArrayList<Transaction> getTransactions(String accountId, String sdate, String edate, String number) throws SQLException, ParseException {
		logger.info("Enter getTransactions DAO");
		ArrayList<Transaction> transactionList = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try
		{
			con = DatabaseUtil.getConnection();
			String str = GETTRANSACTIONBYDATE;
			pst = con.prepareStatement(str);
			pst.setString(1, accountId);
			pst.setString(2, accountId);
			pst.setString(3, edate);
			pst.setString(4, sdate);
			logger.debug(accountId+" "+sdate+" "+edate+" "+number+1);
			pst.setInt(5, Integer.parseInt(number)+1);
			rs = pst.executeQuery();
			while(rs.next())
			{
				Transaction transaction = new Transaction();
				transaction.setTransactionId(rs.getString(1));
				transaction.setStatus(rs.getString(2));
				transaction.setSourceAccount(rs.getString(3));
				transaction.setDestinationAccount(rs.getString(4));
				transaction.setAmount(rs.getLong(5));
				transaction.setTransactionDate(rs.getDate(6));
				transactionList.add(transaction);
			}
		}
		finally
		{
			logger.info("Close all the connections of getTransactions Method");
			DatabaseUtil.closeResultSet(rs);
			DatabaseUtil.closePreparedStatement(pst);
			DatabaseUtil.closeConnection(con);
		}
		logger.info("Exit getTransactions DAO");
		return transactionList;
	}

	/*
	 * This method is used for getting the information about the transactions the number of transaction is given by the employee
	 * (non-Javadoc)
	 * @see com.tcs.interfaces.DaoInterface#getTransactions(java.lang.String, java.lang.String)
	 */
	public ArrayList<Transaction> getTransactions(String accountId, String number) throws SQLException {
		logger.info("Enter getTransactions DAO");
		ArrayList<Transaction> transactionList = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try
		{
			con = DatabaseUtil.getConnection();
			String str = GETTRANSACTIONBYNUMBER;
			pst = con.prepareStatement(str);
			pst.setString(2, accountId);
			pst.setString(3, accountId);
			logger.debug(accountId+" "+number+1);
			pst.setInt(1, Integer.parseInt(number)+1);
			rs = pst.executeQuery();
			while(rs.next())
			{
				Transaction transaction = new Transaction();
				transaction.setTransactionId(rs.getString(1));
				transaction.setStatus(rs.getString(2));
				transaction.setSourceAccount(rs.getString(3));
				transaction.setDestinationAccount(rs.getString(4));
				transaction.setAmount(rs.getLong(5));
				transaction.setTransactionDate(rs.getDate(6));
				transactionList.add(transaction);
			}
		}
		finally
		{
			logger.info("Close all the connections of getTransactions Method");
			DatabaseUtil.closeResultSet(rs);
			DatabaseUtil.closePreparedStatement(pst);
			DatabaseUtil.closeConnection(con);
		}
		logger.info("Exit getTransactions DAO");
		return transactionList;
	}
}
