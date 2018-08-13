package com.tcs.bean;

import java.util.ArrayList;

public class Customer {
	private String customerId;
	private String ssnId;
	private String customerName;
	private int customerAge;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private ArrayList<Account> accountList = new ArrayList<>(2);
	public Customer(){}
	public Customer(String customerId, String ssnId, String customerName, int customerAge, String address1, String address2,
			String city, String state) {
		super();
		this.customerId = customerId;
		this.ssnId = ssnId;
		this.customerName = customerName;
		this.customerAge = customerAge;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCustomerAge() {
		return customerAge;
	}
	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public ArrayList<Account> getAccountList() {
		return accountList;
	}
	public void setAccountList(ArrayList<Account> accountList) {
		this.accountList = accountList;
	}
	public String getSsnId() {
		return ssnId;
	}
	public void setSsnId(String ssnId) {
		this.ssnId = ssnId;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", ssnId=" + ssnId + ", customerName=" + customerName
				+ ", customerAge=" + customerAge + ", address1=" + address1 + ", address2=" + address2 + ", city="
				+ city + ", state=" + state + ", accountList=" + accountList + "]";
	}	
}
