package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.entity.Customer;
import com.cg.exception.NoSuchCustomerFoundException;
import com.cg.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService cService;
	
	@GetMapping("/get/all")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		try {
			return new ResponseEntity<>(cService.findAllCustomer(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get/byid/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int id){
		try {
			return new ResponseEntity<>(cService.findCustomerById(id),HttpStatus.OK);
		} catch (NoSuchCustomerFoundException ex) {
			return new ResponseEntity(ex.getMessage(),HttpStatus.NOT_FOUND);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get/byaccount/{acc}")
	public ResponseEntity<Customer> getCustomerByAccNum(@PathVariable("acc") long acc){
		try {
			return new ResponseEntity<>(cService.findCustomerByAccNum(acc),HttpStatus.OK);
		} catch (NoSuchCustomerFoundException ex) {
			return new ResponseEntity(ex.getMessage(),HttpStatus.NOT_FOUND);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer cust,@PathVariable("id") int id){
		try {
			return new ResponseEntity<>(cService.updateCustomer(cust,id),HttpStatus.ACCEPTED);
		} catch (NoSuchCustomerFoundException ex) {
			return new ResponseEntity(ex.getMessage(),HttpStatus.NOT_FOUND);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") int id){
		try {
			boolean success = cService.removeCustomer(id);
			if(success)
				return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
			else
				return new ResponseEntity<>("Failed to delete",HttpStatus.NOT_MODIFIED);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		try {
			return new ResponseEntity<>(cService.addCustomer(customer),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
