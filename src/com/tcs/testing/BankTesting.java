package com.tcs.testing;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.tcs.service.BankService;
import com.tcs.util.DatabaseUtil;

public class BankTesting {

	@Test
	public void testAuthenticateEmployee() throws SQLException {
		//fail("Not yet implemented");
		BankService bdao=new BankService();
		Connection con=DatabaseUtil.getConnection();
		con.setAutoCommit(false);
		try
		{
			int a=bdao.authenticateEmployee("UserTCS17","User1@1234");
			assertEquals(1,a);
			
		}
		finally
		{
			con.rollback();
			con.close();
		}
	}
	@Test
	public void testAuthenticateEmployee1() throws SQLException {
		//fail("Not yet implemented");
		BankService bdao=new BankService();
		Connection con=DatabaseUtil.getConnection();
		con.setAutoCommit(false);
		try
		{
			int a=bdao.authenticateEmployee("UserTCS90","User1@1234");
			assertEquals(1,a);
		}
		
		finally
		{
			con.rollback();
			con.close();
		}
	}
	

	
}
