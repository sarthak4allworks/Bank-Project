package com.tcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;

import com.tcs.factory.BankDaoAbstractClass;
import com.tcs.interfaces.ConstantsInterface;
import com.tcs.util.DatabaseUtil;

public class BankDAO extends BankDaoAbstractClass implements ConstantsInterface {
	
	private static Logger logger = Logger.getLogger(BankDAO.class);

	/*
	 * This method is used for authenticate the employee and decided their role
	 * @see com.tcs.interfaces.DaoInterface#authenticateEmployee(java.lang.String, java.lang.String)
	 */
	public int authenticateEmployee(String employeeId, String password) throws SQLException {
		logger.info("Enter authenticateEmployee DAO");
		int i = 0;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try
		{
			con = DatabaseUtil.getConnection();
			String query = UPDATETIMESTAMP;
			pst = con.prepareStatement(query);
			pst.setString(1, employeeId);
			pst.setString(2, password);
			logger.debug("Employee id is "+employeeId+" & password is"+password);
			i = pst.executeUpdate();
		}
		finally
		{
			logger.info("Close all the connections of authenticateEmployee Method");
			DatabaseUtil.closeResultSet(rs);
			DatabaseUtil.closePreparedStatement(pst);
			DatabaseUtil.closeConnection(con);
		}
		logger.info("Exit Authenticate employee dao");
		return i;
	}
	
	/*
	 * This method is used for selecting the role of the logged in employee
	 * (non-Javadoc)
	 * @see com.tcs.interfaces.DaoInterface#selectRoleOfEmployee(java.lang.String, java.lang.String)
	 */
	public int selectRoleOfEmployee(String employeeId, String password) throws SQLException
	{
		logger.info("Enter the select role of employee of bank dao");
		int i = 0;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try
		{
			con = DatabaseUtil.getConnection();
			String query = SELECTROLE;
			pst = con.prepareStatement(query);
			pst.setString(1, employeeId);
			pst.setString(2, password);
			logger.debug(employeeId+" "+password);
			rs = pst.executeQuery();
			while(rs.next())
			{
				i = rs.getInt(1);
			}
		}
		finally
		{
			logger.info("Close all the connections of selectRoleOfEmployee Method");
			DatabaseUtil.closeResultSet(rs);
			DatabaseUtil.closePreparedStatement(pst);
			DatabaseUtil.closeConnection(con);
		}
		logger.info("Exit SelectRoleOfEmployee nof BankDao");
		return i;
	}
}
