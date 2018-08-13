package com.tcs.factory;

import java.sql.SQLException;

public interface BankService  {
	/*This method is used for authenticate the employee
	 * (non-Javadoc)
	 * @see com.tcs.interfaces.ServiceInterface#authenticateEmployee(java.lang.String, java.lang.String)
	 */
	public int authenticateEmployee(String employeeId, String password) throws SQLException;
}
