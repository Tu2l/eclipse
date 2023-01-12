package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.CustomerRepo;
import com.cg.entity.Account;
import com.cg.entity.Customer;
import com.cg.exception.NoSuchCustomerFoundException;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	@Transactional
	public Customer addCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	@Override
	public List<Customer> findAllCustomer() {
		return customerRepo.findAll();
	}

	@Override
	public Customer findCustomerByAccNum(long acc) throws NoSuchCustomerFoundException {
		Customer cust = customerRepo.findCustomerByAccNum(acc);
//		System.out.println(cust);
		if(cust == null)
			throw new NoSuchCustomerFoundException("Invalid id");
//		
		return cust;
	}

	@Override
	public Customer findCustomerById(int id) throws NoSuchCustomerFoundException {
		Optional<Customer> cust = customerRepo.findById(id);
		if(cust.isEmpty())
			throw new NoSuchCustomerFoundException("Invalid id");
		
		return cust.get();
	}

	@Override
	public Customer updateCustomer(Customer customer, int id) throws NoSuchCustomerFoundException {
		Customer find = findCustomerById(id);
		Account acc = find.getBankAccount();
		acc.setType(customer.getBankAccount().getType());
		acc.setAccountNumber(customer.getBankAccount().getAccountNumber());
		find.setBankAccount(acc);
		find.setName(customer.getName());
		return customerRepo.save(find);
	}

	@Override
	public boolean removeCustomer(int id){
		customerRepo.deleteById(id);
		Optional<Customer> cust = customerRepo.findById(id);
	
		return !(cust.isEmpty());
	}

}
