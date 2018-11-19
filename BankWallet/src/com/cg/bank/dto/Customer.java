package com.cg.bank.dto;

public class Customer {
	private String custName;
	private String custMobileNo;
	private float  custAge;
	private double custInitialBalance;
	
	public String getName() {
		return custName;
	}
	public void setName(String name) {
		this.custName = name;
	}
	
	public String getMobileNo() {
		return custMobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.custMobileNo = mobileNo;
	}
	
	public float getAge() {
		return custAge;
	}
	public void setAge(float age) {
		this.custAge = age;
	}
	
	public double getInitialBalance() {
		return custInitialBalance;
	}
	public void setInitialBalance(double initialBalance) {
		this.custInitialBalance = initialBalance;
	}
	
	
}
