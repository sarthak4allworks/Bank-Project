package com.tcs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.tcs.interfaces.ConstantsInterface;

public class DatabaseUtil implements ConstantsInterface {
	
	private static Logger logger = Logger.getLogger(DatabaseUtil.class);

	/*
	 * This method is used for making a connection with database and return the connection object
	 */
	public static Connection getConnection() {
		Connection con = null;
		try {
			//Registering Driver
			Class.forName(DRIVERNAME);  //throws ClassNotFoundException (Checked Exception)
			
			//Creating Connection
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD); //throws SQLException (Checked Exception)
		} catch (ClassNotFoundException ex) {
			logger.error("Connection is not stablish "+ex);
			System.out.println("connection not establisted" + ex);
		} catch (SQLException e) {
			logger.error("SQL Exception occured "+e);
			System.out.println(e);
		} catch (Exception e1) {
			logger.error("Some Exception occured "+e1);
			System.out.println(e1);
		}
		return con;
	}

	/*
	 * Close the connection from the database
	 */
	public static void closeConnection(Connection con) {

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				logger.error("SQL Exception occured "+e);
				System.out.println(e);
			} catch (Exception e1) {
				logger.error("Some Exception occured "+e1);
				System.out.println(e1);
			}
		}
	}

	
	public static void closeStatement(Statement smt) {

		if (smt != null) {
			try {
				smt.close();
			} catch (SQLException e) {
				logger.error("SQL Exception occured "+e);
				System.out.println(e);
			} catch (Exception e1) {
				logger.error("Some Exception occured "+e1);
				System.out.println(e1);
			}
		}
	}
	
	/*
	 * Close the prepared statement object
	 */
	public static void closePreparedStatement(PreparedStatement pst)
	{
		if(pst != null)
		{
			try {
				pst.close();
			} catch (SQLException e) {
				logger.error("SQL Exception occured "+e);
				e.printStackTrace();
			} catch (Exception e1) {
				logger.error("Some Exception occured "+e1);
				System.out.println(e1);
			}
		}
	}
	
	/*
	 * Close the resultSet
	 */
	public static void closeResultSet(ResultSet rs)
	{
		if(rs != null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error("SQL Exception occured "+e);
				e.printStackTrace();
			} catch (Exception e1) {
				logger.error("Some Exception occured "+e1);
				System.out.println(e1);
			}
		}
	}

}
