package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.entity.Customer;
import com.cg.exception.NoSuchCustomerFoundException;

public interface CustomerService {
	Customer addCustomer(Customer customer);
	
	List<Customer> findAllCustomer();
	
	Customer findCustomerByAccNum(long acc)throws NoSuchCustomerFoundException;
	
	Customer findCustomerById(int id)throws NoSuchCustomerFoundException;
	
	Customer updateCustomer(Customer customer, int id) throws NoSuchCustomerFoundException;
	
	boolean removeCustomer(int id);
}
