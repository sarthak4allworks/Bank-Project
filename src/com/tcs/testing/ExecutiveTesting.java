package com.tcs.testing;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.tcs.bean.Account;
import com.tcs.bean.Customer;
import com.tcs.service.ExecutiveService;
import com.tcs.util.DatabaseUtil;

public class ExecutiveTesting {

	@Test
	public void testCreateCustomer() throws SQLException {
		//fail("Not yet implemented");
		Connection con=DatabaseUtil.getConnection();
		ExecutiveService bdao=new ExecutiveService();

		con.setAutoCommit(false);
		try
		{
			Customer customer=new Customer("Customer1","1234567898","Shivank",22,"Scarlet","Circle","Trivandrum","Kerala");
			String a=bdao.createCustomer(customer);
			assertEquals("Exist",a);
		}
finally
{
	con.rollback();
	con.close();
}
	}
	@Test
	public void testCreateCustomer1() throws SQLException {
		//fail("Not yet implemented");
		Connection con=DatabaseUtil.getConnection();
		ExecutiveService bdao=new ExecutiveService();

		con.setAutoCommit(false);
		try
		{
			Customer customer=new Customer("","1673450105890","Chiku",82,"Scarlet","Circle","Trivandrum","Kerala");
			String a=bdao.createCustomer(customer);
			assertEquals("Exist",a);
		}
finally
{
	con.rollback();
	con.close();
}
	}

	@Test
	public void testCreateAccount() throws SQLException {
		//fail("Not yet implemented");
		
		Connection con=DatabaseUtil.getConnection();
		ExecutiveService bdao=new ExecutiveService();

		con.setAutoCommit(false);
		try
		{
			Account account=new Account("ACCOUNTNO_GROUPD.nextval",25000,"SUCCESS","SAVING");
			String a=bdao.createAccount(account,"CUSTOMERID_GROUPD.nextval");
			assertEquals("CustomerDoesNotExist",a);
		}
		finally
		{
			con.rollback();
			con.close();
		}
	}
	

	@Test
	public void testCreateAccount1() throws SQLException {
		//fail("Not yet implemented");
		
		Connection con=DatabaseUtil.getConnection();
		ExecutiveService bdao=new ExecutiveService();

		con.setAutoCommit(false);
		try
		{
			Account account=new Account("1234567898",12500,"SUCCESS","SAVING");
			String a=bdao.createAccount(account,"Customer1");
			assertEquals("CustomerDoesNotExist",a);
		}
		finally
		{
			con.rollback();
			con.close();
		}
	}

}
