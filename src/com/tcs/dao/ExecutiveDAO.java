package com.tcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.tcs.bean.Account;
import com.tcs.bean.Customer;
import com.tcs.factory.ExecutiveDaoAbstractClass;
import com.tcs.interfaces.ConstantsInterface;
import com.tcs.util.DatabaseUtil;

public class ExecutiveDAO extends ExecutiveDaoAbstractClass implements ConstantsInterface {

	private static Logger logger = Logger.getLogger(ExecutiveDAO.class);
	
	/*
	 * This method is used for create new customer by the executive
	 * (non-Javadoc)
	 * @see com.tcs.interfaces.DaoInterface#createCustomer(com.tcs.bean.Customer)
	 */
	public String createCustomer(Customer customer) throws SQLException {
		logger.info("Enter createCustomer DAO");
		String i = "";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try
		{
			con = DatabaseUtil.getConnection();
			String str = CREATECUSTOMER;
			pst= con.prepareStatement(str);
			pst.setString(1, customer.getSsnId());
			logger.debug(customer.getSsnId());
			rs = pst.executeQuery();
			while(rs.next())
			{
				logger.info("customer already esixt");
				i = "Exist";
				break;
			}
		}
		finally
		{
			logger.info("Close all the connections of createCustomer Method");
			DatabaseUtil.closeResultSet(rs);
			DatabaseUtil.closePreparedStatement(pst);
			DatabaseUtil.closeConnection(con);
		}
		logger.info("Exit createCustomer DAO");
		return i;
	}
	
	/*
	 * This method is used for insert the information of the new customer
	 */
	public int insertCustomerInformation(Customer customer) throws SQLException
	{
		logger.info("Enter insertCustomerInformation DAO");
		int j = 0;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try
		{
			con = DatabaseUtil.getConnection();
			String str = INSERTCUSTOMERINFO;
			pst = con.prepareStatement(str);
			pst.setString(1, customer.getSsnId());
			pst.setString(2, customer.getCustomerName());
			pst.setInt(3, customer.getCustomerAge());
			pst.setString(4, customer.getAddress1());
			pst.setString(5, customer.getAddress2());
			pst.setString(6, customer.getCity());
			logger.debug(customer);
			pst.setString(7, customer.getState());
			j = pst.executeUpdate();
		}
		finally
		{
			logger.info("Close all the connections of createCustomer Method");
			DatabaseUtil.closeResultSet(rs);
			DatabaseUtil.closePreparedStatement(pst);
			DatabaseUtil.closeConnection(con);
		}
		logger.info("Exit insertCustomerInformation DAO");
		return j;
	}
	
	/*
	 * This method is for retrive the customer id of the newly insert customer
	 */
	public String retrieveCustomerId(Customer customer) throws SQLException
	{
		logger.info("Enter retrieveCustomerId DAO");
		String i = "";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try
		{
			con = DatabaseUtil.getConnection();
			String str = RETRIEVECUSTOMERID;
			pst= con.prepareStatement(str);
			pst.setString(1, customer.getSsnId());
			logger.debug(customer.getSsnId());
			rs = pst.executeQuery();
			while(rs.next())
			{
				i = rs.getString(1);
				break;
			}
		}
		finally
		{
			logger.info("Close all the connections of retrieveCustomerId Method");
			DatabaseUtil.closeResultSet(rs);
			DatabaseUtil.closePreparedStatement(pst);
			DatabaseUtil.closeConnection(con);
		}
		logger.info("Exit retrieveCustomerId DAO");
		return i;
	}
	
	/*
	 * This method is used for creating the account for the customer
	 * (non-Javadoc)
	 * @see com.tcs.interfaces.DaoInterface#createAccount(com.tcs.bean.Account, java.lang.String)
	 */
	public String createAccount(Account account, String customerId) throws SQLException {
		logger.info("Enter createAccount DAO");
		String str = "false";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try
		{
			con = DatabaseUtil.getConnection();
			String query = CREATEACCOUNT;
			pst = con.prepareStatement(query);
			pst.setString(1, customerId);
			logger.debug(customerId);
			rs = pst.executeQuery();
			while(rs.next())
			{
				str = "true";
				break;
			}
		}
		finally
		{
			logger.info("Close all the connections of createAccount Method");
			DatabaseUtil.closeResultSet(rs);
			DatabaseUtil.closePreparedStatement(pst);
			DatabaseUtil.closeConnection(con);
		}
		logger.info("Exit createAccount DAO");
		return str;
	}
	
	/*
	 * This method is used to check that account is already exist or not for a particular customer
	 * (non-Javadoc)
	 * @see com.tcs.interfaces.DaoInterface#checkAccountExist(com.tcs.bean.Account, java.lang.String)
	 */
	public boolean checkAccountExist(Account account, String customerId) throws SQLException
	{
		logger.info("Enter checkAccountExist DAO");
		boolean flag = false;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try
		{
			con = DatabaseUtil.getConnection();
			String query = CHECKACCOUNTEXIST;
			pst = con.prepareStatement(query);
			pst.setString(1, customerId);
			pst.setString(2, account.getType());
			logger.debug(account.getType()+" "+customerId);
			rs = pst.executeQuery();
			while(rs.next())
			{
				flag = true;
				break;
			}
		}
		finally
		{
			logger.info("Close all the connections of checkAccountExist Method");
			DatabaseUtil.closeResultSet(rs);
			DatabaseUtil.closePreparedStatement(pst);
			DatabaseUtil.closeConnection(con);
		}
		logger.info("Exit checkAccountExist DAO");
		return flag;
	}
	
	/*
	 * If customer account is already not exist then create account for the customer
	 * (non-Javadoc)
	 * @see com.tcs.interfaces.DaoInterface#newAccount(com.tcs.bean.Account, java.lang.String)
	 */
	public String newAccount(Account account, String customerId) throws SQLException
	{
		logger.info("Enter newAccount DAO");
		String str = "";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try
		{
			con = DatabaseUtil.getConnection();
			String query = NEWACCOUNT;
			pst = con.prepareStatement(query);
			pst.setString(1, customerId);
			pst.setString(2, account.getType());
			pst.setString(3, account.getStatus());
			pst.setLong(4, account.getBalance());
			logger.debug(customerId+" "+account.getType()+" "+account.getStatus()+" "+account.getBalance());
			pst.executeUpdate();
			str = "SUCCESS";
		}
		finally
		{
			logger.info("Close all the connections of newAccount Method");
			DatabaseUtil.closeResultSet(rs);
			DatabaseUtil.closePreparedStatement(pst);
			DatabaseUtil.closeConnection(con);
		}
		logger.info("Exit newAccount DAO");
		return str;
	}
}
