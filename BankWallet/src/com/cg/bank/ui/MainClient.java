package com.cg.bank.ui;

import java.util.Scanner;

import com.cg.bank.dto.Customer;
import com.cg.bank.exception.BankAccException;
import com.cg.bank.service.BankAccServiceImpl;

public class MainClient {
	public static void main(String args[]) throws BankAccException{
		
		BankAccServiceImpl service = new BankAccServiceImpl();
		
		Scanner sc = new Scanner(System.in);
		
		String name,mobileNo;
		float age;
		double amount;
		int ch = 0;
		do{
			System.out.println("*********Welcome to Bank Wallet*********\n");
			System.out.println("1.Customer Creation\n2.Deposit Amount in Your Account\n3.Withdraw Amount from Your Account\n4.Fund Transfer\n5.Check Balance in Your Account\n6.Exit\n");
			System.out.println("Enter your choice : ");
			ch = sc.nextInt();
			Customer customer;
			switch(ch){
				case 1 :
						customer = new Customer();						
					
						do{
							System.out.println("Enter Customer Name : ");
							name = sc.next();
							if(!service.validateName(name))
								System.err.println("Invalid Name!");
							else
								break;
						}while(true);
						do{
							System.out.println("Enter Mobile No. :");
							mobileNo = sc.next();
							if(!service.validateMoileNo(mobileNo))
								System.err.println("Invalid Mobile Number");
							else if(service.validateAccount(mobileNo))
								System.err.println("Account already exist with this number!");
							else
								break;								
						}while(true);
						do{
							System.out.println("Enter age : ");
							age = sc.nextFloat();
							if(service.validateAge(age))
								break;
						}while(true);
						do{
							System.out.println("Enter Initial Amount : ");
							amount = sc.nextDouble();
							if(!service.validateAmount(amount))
								System.err.println("Invalid Amount!");
							else
								break;							
						}while(true);
						
						
						
						customer.setName(name);
						customer.setMobileNo(mobileNo);
						customer.setAge(age);
						customer.setInitialBalance(amount);
						
						service.createAccount(customer);
						
						System.out.println("****Customer's Account Created Successfully****\n");
					
					break;
					
				case 2 :
						do{
							System.out.println("Enter Your Mobile Number : ");
							mobileNo = sc.next();
							
							System.out.println("Enter the amount you want to deposit");
							amount = sc.nextDouble();
							if(service.validateMoileNo(mobileNo)&& service.validateAmount(amount)){
								if(service.validateAccount(mobileNo))
									break;
							}
						}while(true);
						
						service.deposit(mobileNo, amount);
						System.out.println("Your Updated Balance is Rs."+service.checkBalance(mobileNo));
						
						
						
					
					break;
					
				case 3 :
						do{
							System.out.println("Enter Your Mobile Number : ");
							mobileNo = sc.next();
							
							System.out.println("Enter Amount You Want to Withdraw : ");
							amount = sc.nextDouble();
							if(service.validateMoileNo(mobileNo) && service.validateAmount(amount)){
								if(service.validateAccount(mobileNo))
									break;
							}
						}while(true);
						
						service.withdraw(mobileNo, amount);
						System.out.println("Your Updated Balance is Rs."+service.checkBalance(mobileNo));
						
					break;
				
				case 4 :
						String mobileNoReciever;
						do{
							System.out.println("Enter Sender's Mobile Number : ");
							mobileNo = sc.next();
							
							System.out.println("Enter The Amount You Want To Transfer : ");
							amount = sc.nextDouble();
							
							System.out.println("Enter Receiver's Mobile Number : ");
							mobileNoReciever = sc.next();
							if(mobileNo.equals(mobileNoReciever)){								
								System.out.println("Both Numbers Are Same!");
								continue;
							}
							if(service.validateMoileNo(mobileNo) && service.validateMoileNo(mobileNoReciever) && service.validateAmount(amount)){
								if(service.validateAccount(mobileNoReciever) && service.validateAccount(mobileNo))
									break;
							}
						}while(true);
						service.fundTransfer(mobileNo, mobileNoReciever, amount);
						System.out.println("Current Amount is Rs."+service.checkBalance(mobileNo));
											
					break;
					
				case 5 :
						do{
							System.out.println("Enter Moible To Check Balance:");
							mobileNo = sc.next();
							if(service.validateAccount(mobileNo)){
								
								if(service.validateMoileNo(mobileNo))									
									break;
							}
							
							else
							{
								System.err.println("Plese Enter a Valid No.");
							}
						}while(true);
						
						System.out.println("Current Amount is Rs."+service.checkBalance(mobileNo));
						
					break;
					
				case 6 :
						System.out.println("ThankYou For Banking with us.");
					break;
				default : System.err.println("Please Choose Only 1-6");
			}
			
		}while(ch != 6);
		
	}
}
