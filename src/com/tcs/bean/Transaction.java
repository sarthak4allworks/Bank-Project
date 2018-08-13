package com.tcs.bean;

import java.util.Date;

public class Transaction {
	private String transactionId;
	private String status;
	private String sourceAccount;
	private String destinationAccount;
	private long amount;
	private Date transactionDate;
	public Transaction(){}
	public Transaction(String transactionId, String status, String sourceAccount, String destinationAccount,
			long amount, Date transactionDate) {
		super();
		this.transactionId = transactionId;
		this.status = status;
		this.sourceAccount = sourceAccount;
		this.destinationAccount = destinationAccount;
		this.amount = amount;
		this.transactionDate = transactionDate;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSourceAccount() {
		return sourceAccount;
	}
	public void setSourceAccount(String sourceAccount) {
		this.sourceAccount = sourceAccount;
	}
	public String getDestinationAccount() {
		return destinationAccount;
	}
	public void setDestinationAccount(String destinationAccount) {
		this.destinationAccount = destinationAccount;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", status=" + status + ", sourceAccount=" + sourceAccount
				+ ", destinationAccount=" + destinationAccount + ", amount=" + amount + ", transactionDate="
				+ transactionDate + "]";
	}
}
