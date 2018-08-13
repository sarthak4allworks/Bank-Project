package com.tcs.interfaces;

public interface ConstantsInterface {
	
	public static final String DRIVERNAME = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String PASSWORD = "anandss3";
	public static final String USERNAME = "system";
	
	// Bank DAO Constants
	public static final String UPDATETIMESTAMP = "UPDATE LOGIN_GROUPD SET time_of_current_login=CURRENT_TIMESTAMP WHERE loginId=? AND password=?";
	public static final String SELECTROLE = "SELECT ROLE_ID FROM LOGIN_GROUPD WHERE loginId=? AND password=?";
	
	// Cashier DAO Constants
	public static final String SELECTACCOUNTTYPE = "SELECT account_type, deposit_amount FROM ACCOUNT_GROUPD WHERE account_no=?";
	public static final String INSERTTRANSACTION = "INSERT INTO TRANSACTION_GROUPD(transaction_id, status, source_account, destination_account, amount, transaction_time) VALUES('Trans' || to_char(TRANSACTIONID_GROUPD.nextval),?,?,?,?,CURRENT_TIMESTAMP)";
	public static final String GETCUSTOMERINFO = "SELECT c.customer_id, c.customer_name, a.account_type, a.deposit_amount FROM CUSTOMER_GROUPD c JOIN ACCOUNT_GROUPD a ON a.customer_id=c.customer_id AND a.account_no=?";
	public static final String UPDATEACCOUNT = "UPDATE ACCOUNT_GROUPD SET deposit_amount=? WHERE account_no=?";
	public static final String GETTRANSACTIONBYDATE = "SELECT transaction_id, status,source_account, destination_account, amount, CAST(transaction_time AS DATE) FROM TRANSACTION_GROUPD WHERE (source_account=? OR destination_account=?) AND CAST(transaction_time AS DATE)<=to_date(?, 'yyyy-mm-dd') AND CAST(transaction_time AS DATE)>=to_date(?, 'yyyy-mm-dd') AND ROWNUM<=? ORDER BY transaction_time DESC";
	public static final String GETTRANSACTIONBYNUMBER = "SELECT transaction_id, status,source_account, destination_account, amount, CAST(transaction_time AS DATE) FROM TRANSACTION_GROUPD WHERE ROWNUM<=? AND (source_account=? OR destination_account=?) ORDER BY transaction_time DESC";

	// Executive DAO constants
	public static final String CREATECUSTOMER = "SELECT customer_id FROM CUSTOMER_GROUPD WHERE customer_ssnID=?";
	public static final String INSERTCUSTOMERINFO = "INSERT INTO CUSTOMER_GROUPD(customer_id, customer_ssnID, customer_name, customer_age, address1, address2, city, state) VALUES('Customer' || to_char(CUSTOMERID_GROUPD.nextval), ?,?,?,?,?,?,?)";
	public static final String RETRIEVECUSTOMERID = "SELECT customer_id FROM CUSTOMER_GROUPD WHERE customer_ssnID=?";
	public static final String CREATEACCOUNT = "SELECT customer_ssnID FROM CUSTOMER_GROUPD WHERE customer_id=?";
	public static final String CHECKACCOUNTEXIST = "SELECT account_no FROM ACCOUNT_GROUPD WHERE customer_id=? AND account_type=?";
	public static final String NEWACCOUNT = "INSERT INTO ACCOUNT_GROUPD(account_no, customer_id, account_type, status, deposit_amount) VALUES('198745632' || to_char(ACCOUNTNO_GROUPD.nextval), ?,?,?,?)";
}
