package com.cg.bank.dao;

import java.util.ArrayList;
import java.util.Map;

import com.cg.bank.dto.Customer;
import com.cg.bank.exception.BankAccException;

public class BankAccDAOImpl implements BankAccDAO{
	
	Map<String,Customer> customerMap;
	
	public BankAccDAOImpl(){
		customerMap = Store.createCollection();
	}
	
	@Override
	public void createAccount(Customer customer) {
		// TODO Auto-generated method stub
		customerMap.put(customer.getMobileNo(),customer);
		
	}

	@Override
	public void deposit(String mobileNo, double amount) {
		// TODO Auto-generated method stub
		Customer customer = customerMap.get(mobileNo);
		if(customer != null){
			double updateAmount = customer.getInitialBalance();
			updateAmount += amount;
			String name = customer.getName();
			String newMobileNo = customer.getMobileNo();
			float age = customer.getAge();
			
			customer.setAge(age);
			customer.setInitialBalance(updateAmount);
			customer.setName(name);
			customer.setMobileNo(newMobileNo);
			
			customerMap.put(newMobileNo, customer);
			System.out.println("Amount deposited");
		}
		else{
			System.out.println("Mobile number not found, please enter valid mobile number!");
		}
	}

	@Override
	public void withdraw(String mobileNo, double withdrawAmount) {
		// TODO Auto-generated method stub
		Customer customer = customerMap.get(mobileNo);
		if(customer != null){
			double amount = customer.getInitialBalance();	
			
			String name = customer.getName();
			String newMobileNo = customer.getMobileNo();
			float age = customer.getAge();
			
			if(amount - withdrawAmount > 500)
				amount -= withdrawAmount;
			
			customer.setAge(age);
			customer.setInitialBalance(amount);
			customer.setName(name);
			customer.setMobileNo(newMobileNo);
			
			customerMap.put(newMobileNo, customer);
			System.out.println("Amount withdrawn");
		}
		else{
			System.out.println("Mobile number not found, please enter valid mobile number!");
		}
		
	}

	@Override
	public double checkBalance(String mobileNo) {
		// TODO Auto-generated method stub
		Customer custCheckBalance = customerMap.get(mobileNo);
		double amount = custCheckBalance.getInitialBalance();
		return amount;
		
	}

	@Override
	public void fundTransfer(String sender, String reciever, double amount) {
		// TODO Auto-generated method stub
		
		String name, newMobileNo;
		float age;
		double amountFund;
		
		Customer custSender =  customerMap.get(sender);
		Customer custReciever = customerMap.get(reciever);
		
		double recieverAmount = custReciever.getInitialBalance();
		double senderAmount = custSender.getInitialBalance();
		if(!(senderAmount - amount > 500)){
			System.err.println("Invalid Amount! \nEntered Amount exceeds the Balnce amount");
		}
		else{
			recieverAmount += amount;
			senderAmount -= amount;
			System.out.println("Fund Transferred");
		
		name = custSender.getName();
		newMobileNo = custSender.getMobileNo();
		age = custSender.getAge();
		amountFund = senderAmount;
		
		custSender.setAge(age);
		custSender.setInitialBalance(senderAmount);
		custSender.setMobileNo(newMobileNo);
		custSender.setName(name);
		
		customerMap.put(newMobileNo, custSender);
		
		name = custReciever.getName();
		newMobileNo = custReciever.getMobileNo();
		age = custReciever.getAge();
		amountFund = recieverAmount;
		
		custReciever.setAge(age);
		custReciever.setInitialBalance(recieverAmount);
		custReciever.setMobileNo(newMobileNo);
		custReciever.setName(name);
		
		customerMap.put(newMobileNo, custReciever);
		}
		
		
	}

	@Override
	public boolean validateAccount(String mobileNo) throws BankAccException {
		// TODO Auto-generated method stub
		Customer customer = customerMap.get(mobileNo);
		if(customer == null)
			return false;
		return true;
	}

}
