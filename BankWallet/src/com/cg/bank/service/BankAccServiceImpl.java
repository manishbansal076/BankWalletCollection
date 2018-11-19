package com.cg.bank.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.bank.dao.BankAccDAO;
import com.cg.bank.dao.BankAccDAOImpl;
import com.cg.bank.dto.Customer;
import com.cg.bank.exception.BankAccException;


public class BankAccServiceImpl implements IBankAccService{

	BankAccDAO dao  = new BankAccDAOImpl();
	
	
	@Override
	public void createAccount(Customer customer) {
		// TODO Auto-generated method stub
		dao.createAccount(customer);		
	}

	@Override
	public void deposit(String mobileNo, double amount) {
		// TODO Auto-generated method stub
		dao.deposit(mobileNo, amount);
		
	}

	@Override
	public void withdraw(String mobileNo, double amount) {
		// TODO Auto-generated method stub
		dao.withdraw(mobileNo, amount);
		
	}

	@Override
	public double checkBalance(String mobileNo) {
		// TODO Auto-generated method stub
		return dao.checkBalance(mobileNo);
	}

	@Override
	public void fundTransfer(String sender, String reciever, double amount) {
		// TODO Auto-generated method stub
		dao.fundTransfer(sender, reciever, amount);
		
	}

	@Override
	public boolean validateName(String name) throws BankAccException {
		// TODO Auto-generated method stub
		if(name == null)
			throw new BankAccException("Null value found");
		Pattern p = Pattern.compile("[A-Z]{1}[a-z]{3,10}");
		Matcher m = p.matcher(name); 
		if(!m.matches())
			System.err.println("Name's First Letter Should be Capital and Should be 4 digit ");
		return m.matches();
		
	}

	@Override
	public boolean validateAge(float age)  throws BankAccException {
		try{
			// TODO Auto-generated method stub
			if(age == 0)
			{
				System.err.println("Age Cannot be  null");
				throw new BankAccException("Age cannot be  null");
			}
			else if(age >100)
			{
				System.err.println("Age cannot be  greater than 100");
			
				throw new BankAccException("Age cannot be  greater than 100");
			}
			else if(age < 0)
			{
				System.err.println("Age cannot be a negative number");
				throw new BankAccException("Age cannot be a negative number");
			}
			else if(0<age && age<18)
			{
				System.err.println("Age Should be 18 above");
				throw new BankAccException("Age Should be 18 above");
			}
			else if(age>17)
				return true;
			
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return false;
	}

	@Override
	public boolean validateMoileNo(String mobileNo) throws BankAccException{
		try{
			// TODO Auto-generated method stub
			if(mobileNo == null)
				throw new BankAccException("Null value found");
			Pattern p = Pattern.compile("[6789][0-9]{9}");
			Matcher m = p.matcher(mobileNo);
			if(!m.matches())
				System.err.println("Mobile Number Should be 10 digits");
			return m.matches();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return false;
	}

	@Override
	public boolean validateAmount(double amount) throws BankAccException {
		// TODO Auto-generated method stub
		if(amount == 0)
			throw new BankAccException("Null value found");
		String am = String.valueOf(amount);
		if(!am.matches("\\d{3,9}\\.\\d{0,4}"))
			System.err.println("Amount Should be in 3 to 7 digits and after decimal point 4 digits are possible");
		return (am.matches("\\d{3,9}\\.\\d{0,4}"));
	}

	@Override
	public boolean validateAccount(String mobileNo) throws BankAccException {
		// TODO Auto-generated method stub
		
		return dao.validateAccount(mobileNo);
	}

}
