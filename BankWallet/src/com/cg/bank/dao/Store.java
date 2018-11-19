package com.cg.bank.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.bank.dto.Customer;

public class Store {
	private static Map<String, Customer> customer;
	static Map<String, Customer> createCollection(){
		if(customer == null)
			customer = new HashMap<>();		
		return customer;		
	}

}
