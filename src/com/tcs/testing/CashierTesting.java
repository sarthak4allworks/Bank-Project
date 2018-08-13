package com.tcs.testing;

import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import org.junit.Test;
import com.tcs.CustomException.AccountNotCurrentException;
import com.tcs.CustomException.AccountNotExistException;
import com.tcs.CustomException.TransferNotAllowedException;
import com.tcs.bean.Customer;
import com.tcs.bean.Transaction;
import com.tcs.service.CashierService;
import com.tcs.util.DatabaseUtil;

public class CashierTesting {

	@Test
	public void testDoTransaction() throws SQLException, AccountNotCurrentException, AccountNotExistException, TransferNotAllowedException {
		//fail("Not yet implemented");
		Connection con=DatabaseUtil.getConnection();
		CashierService bdao=new CashierService();
		con.setAutoCommit(false);
		try
		{
			ArrayList<Customer> tList1=new ArrayList<Customer>();
			tList1=bdao.doTransaction(1000,"19874563211","19874563210");
			assertEquals(2,tList1.size());

		}
		finally
		{
			con.rollback();
			con.close();
		}
		
	}
	@Test
	public void testDoTransaction1() throws SQLException, AccountNotCurrentException, AccountNotExistException, TransferNotAllowedException {
		//fail("Not yet implemented");
		Connection con=DatabaseUtil.getConnection();
		CashierService bdao=new CashierService();
		con.setAutoCommit(false);
		try
		{
			ArrayList<Customer> tList1=new ArrayList<Customer>();
			tList1=bdao.doTransaction(1000,"19874563211","19874563210");
			assertEquals(4,tList1.size());

		}
		finally
		{
			con.rollback();
			con.close();
		}
		
	}
		
	

	@Test
	public void testGetTransactionsStringStringStringString() throws SQLException, ParseException {
		//fail("Not yet implemented");
		Connection con=DatabaseUtil.getConnection();
		CashierService bdao=new CashierService();
		con.setAutoCommit(false);
		try
		{
			ArrayList<Transaction> tList1=new ArrayList<Transaction>();
			tList1=bdao.getTransactions("19874563212","2018-08-06","2018-08-09","2");
			assertEquals(2,tList1.size());

		}
		finally
		{
			con.rollback();
			con.close();
		}
		
	}
   @Test
	public void testGetTransactions1StringStringStringString() throws SQLException, ParseException {
		//fail("Not yet implemented");
		Connection con=DatabaseUtil.getConnection();
		CashierService bdao=new CashierService();
		con.setAutoCommit(false);
		try
		{
			ArrayList<Transaction> tList1=new ArrayList<Transaction>();
			tList1=bdao.getTransactions("19874563212","2018-08-06","2018-08-09","4");
			assertEquals(4,tList1.size());

		}
		finally
		{
			con.rollback();
			con.close();
		}
		
	}

	@Test
	public void testGetTransactionsStringString() throws SQLException {
		//fail("Not yet implemented");
		Connection con=DatabaseUtil.getConnection();
		CashierService bdao=new CashierService();
		con.setAutoCommit(false);
		try
		{
			ArrayList<Transaction> tList=new ArrayList<Transaction>();
			tList=bdao.getTransactions("19874563212","2");
			assertEquals(2,tList.size());

		}
		finally
		{
			con.rollback();
			con.close();
		}
		}
	@Test
	public void testGetTransactions1StringString() throws SQLException {
		//fail("Not yet implemented");
		Connection con=DatabaseUtil.getConnection();
		CashierService bdao=new CashierService();
		con.setAutoCommit(false);
		try
		{
			ArrayList<Transaction> tList=new ArrayList<Transaction>();
			tList=bdao.getTransactions("19874563212","4");
			assertEquals(4,tList.size());

		}
		finally
		{
			con.rollback();
			con.close();
		}
		}
	

}
