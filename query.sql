1- LogIn Table of Employee
	
	CREATE TABLE LOGIN_GROUPD
	(
		loginId VARCHAR2(15) CHECK(LENGTH(loginId)>7) PRIMARY KEY,
		password VARCHAR2(15) CHECK(LENGTH(password)>9),
		time_of_current_login TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
		ROLE_ID NUMBER(2) REFERENCES ROLE_GROUPD(Role_Id) 
	)
	
2- Make a sequence for LOGIN

	CREATE SEQUENCE LOGIN_SEQ START WITH 1 INCREMENT BY 1 NOCYCLE NOCACHE
	
3- INSERT INTO LOGIN_GROUPD(loginId, password, Role_ID) VALUES ('UserTCS' || to_char(LOGIN_SEQ.nextval), 'User1@1234', 1);
	
	INSERT INTO LOGIN_GROUPD(loginId, password, Role_ID) VALUES ('UserTCS' || to_char(LOGIN_SEQ.nextval), 'User1@4321', 2);
	
	INSERT INTO LOGIN_GROUPD(loginId, password, Role_ID) VALUES ('UserTCS' || to_char(LOGIN_SEQ.nextval), 'User1@1432', 2);
	
	INSERT INTO LOGIN_GROUPD(loginId, password, Role_ID) VALUES ('UserTCS' || to_char(LOGIN_SEQ.nextval), 'User1@3214', 2);

4- SELECT * FROM LOGIN_GROUPD

5- DELETE FROM LOGIN_GROUPD

6- DROP TABLE LOGIN_GROUPD

6- Role Table

	CREATE TABLE ROLE_GROUPD
	(
		Role_id NUMBER(2) PRIMARY KEY,
		Role_Name VARCHAR2(10)
	)
	
7- INSERT INTO ROLE_GROUPD(Role_Id, Role_Name) VALUES(1, 'Executive');
	INSERT INTO ROLE_GROUPD(Role_Id, Role_Name) VALUES(2, 'Cashier');	
	
8- SELECT * FROM ROLE_GROUPD
	
	DROP TABLE ROLE_GROUPD

9- table for customer
	
	CREATE TABLE CUSTOMER_GROUPD
	(
		customer_id VARCHAR2(20) PRIMARY KEY,
		customer_ssnID VARCHAR2(20) NOT NULL UNIQUE,
		customer_name VARCHAR2(20) NOT NULL,
		customer_age NUMBER(3) NOT NULL,
		address1 VARCHAR2(30) NOT NULL,
		address2 VARCHAR2(30),
		city VARCHAR2(15) NOT NULL,
		state VARCHAR2(15) NOT NULL
	)
	
	DELETE FROM CUSTOMER_GROUPD
	
	SELECT * FROM CUSTOMER_GROUPD
	
	CREATE SEQUENCE CUSTOMERID_GROUPD START WITH 1 INCREMENT BY 1 NOCYCLE NOCACHE
	
	DROP TABLE CUSTOMER_GROUPD
	
10- table for account
	
	CREATE TABLE ACCOUNT_GROUPD
	(
		account_no VARCHAR2(12) PRIMARY KEY,
		customer_id VARCHAR2(20) REFERENCES CUSTOMER_GROUPD(customer_id) NOT NULL,
		account_type VARCHAR2(10) CHECK(account_type IN('SAVING', 'CURRENT')),
		status VARCHAR2(10) DEFAULT 'PENDING',
		deposit_amount NUMBER(10) NOT NULL
	)
	
	DROP TABLE ACCOUNT_GROUPD
	
	SELECT * FROM ACCOUNT_GROUPD
	
11- sequence for generating account number

	CREATE SEQUENCE ACCOUNTNO_GROUPD START WITH 10 INCREMENT BY 1 NOCYCLE NOCACHE
	
12- table for transaction 

	CREATE TABLE TRANSACTION_GROUPD
	(
		transaction_id VARCHAR2(10) PRIMARY KEY,
		status VARCHAR2(10) CHECK(status IN('PENDING', 'SUCCESS', 'FAILED')),
		source_account VARCHAR2(12) REFERENCES ACCOUNT_GROUPD(account_no) NOT NULL,
		destination_account VARCHAR2(12) REFERENCES ACCOUNT_GROUPD(account_no) NOT NULL,
		amount NUMBER(10) NOT NULL,
		transaction_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
	)
	
	DROP TABLE TRANSACTION_GROUPD
	
	SELECT * FROM TRANSACTION_GROUPD
	
13- sequence for generating transaction id

	CREATE SEQUENCE TRANSACTIONID_GROUPD START WITH 1 INCREMENT BY 1 NOCYCLE NOCACHE 

3- CREATE SEQUENCE a_123 START WITH 1 INCREMENT BY 1

SELECT 'UserTCS' || to_char(a_123.nextval) FROM DUAL

DROP SEQUENCE a_123

4- SELECT transaction_id, status, amount, CAST(transaction_time AS DATE) FROM TRANSACTION_GROUPD WHERE (source_account='19874563211' OR destination_account='19874563210') AND
to_date(CAST(transaction_time AS DATE), 'yyyy-MM-dd')<=to_date('2018-08-01', 'yyyy-MM-dd') AND CAST(transaction_time AS DATE)>=to_date('2018-08-10', 'yyyy-mm-dd')



source_account='19874563211' OR destination_account='19874563210'

AND CAST(transaction_time AS DATE)<=to_date('2018-08-01', 'yyyy-mm-dd') 

AND CAST(transaction_time AS DATE)>=to_date('2018-08-10', 'yyyy-mm-dd')

SELECT transaction_id FROM TRANSACTION_GROUPD WHERE CAST(transaction_time AS DATE)

<to_date('2018-08-15', 'yyyy-mm-dd') AND CAST(transaction_time AS DATE)>to_date('2017-08-15', 'yyyy-mm-dd')

BETWEEN to_date('2018-08-15') AND to_date('2018-12-10')

AND to_char(CAST(transaction_time AS DATE))<'2018-12-10'


SELECT CAST(transaction_time AS DATE) DT FROM TRANSACTION_GROUPD;

 source_account='19874563212' OR destination_account='19874563212' AND 
 
 SELECT * FROM TRANSACTION_GROUPD WHERE ROWNUM < 5 AND (source_account='19874563212' OR destination_account='19874563212') ORDER BY transaction_time DESC;
 
 
 ==================================
 
 create table datess(
 val date)
 
 insert into datess values(TO_DATE('2017-05-05','YYYY-MM-DD'));
  insert into datess values(TO_DATE('2017-05-06','YYYY-MM-DD'));
   insert into datess values(TO_DATE('2017-05-07','YYYY-MM-DD'));
    insert into datess values(TO_DATE('2017-05-08','YYYY-MM-DD'));
     insert into datess values(TO_DATE('2017-05-09','YYYY-MM-DD'));
      insert into datess values(TO_DATE('2017-05-15','YYYY-MM-DD'));
 
      select * from datess where val > TO_DATE('2017-05-07','YYYY-MM-DD');
