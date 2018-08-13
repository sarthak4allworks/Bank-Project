package com.tcs.factory;

import java.sql.SQLException;

import com.tcs.bean.Account;
import com.tcs.bean.Customer;

public interface ExecutiveService {
	/*This method is used for create the customer
	 * (non-Javadoc)
	 * @see com.tcs.interfaces.ServiceInterface#authenticateEmployee(java.lang.String, java.lang.String)
	 */
	public String createCustomer(Customer customer) throws SQLException;
	
	/*This method is used for create account for customer
	 * (non-Javadoc)
	 * @see com.tcs.interfaces.ServiceInterface#authenticateEmployee(java.lang.String, java.lang.String)
	 */
	public String createAccount(Account account, String customerId) throws SQLException;
}
