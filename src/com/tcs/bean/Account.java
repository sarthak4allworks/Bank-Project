package com.tcs.bean;

public class Account {
	private String accountNo;
	private long balance;
	private String status;
	private String type;
	public Account(){}
	public Account(String accountNo, long balance, String status, String type) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
		this.status = status;
		this.type = type;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", balance=" + balance + ", status=" + status + ", type=" + type
				+ "]";
	}
}
