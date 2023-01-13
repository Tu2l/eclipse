package com.cg.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.dao.CustomerRepo;
import com.cg.entity.Account;
import com.cg.entity.Customer;
import com.cg.exception.NoSuchCustomerFoundException;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {
	@Mock
	private CustomerRepo repo;
	@InjectMocks
	private CustomerServiceImpl cService;

	private List<Customer> customerList;
	private Customer cus = null;

	private CustomerServiceImplTest() {
		cService = new CustomerServiceImpl();
		customerList = new ArrayList<>();
	}

	@BeforeEach
	private void initEach() {
		cus = new Customer();
		cus.setCustomerId(123);
		cus.setName("Test");
		Account acc = new Account();
		acc.setType("Savings");
		acc.setAccountNumber(12345);
		cus.setBankAccount(acc);

		customerList.add(cus);
	}

	@Test
	void addCustomerTest() {
		Mockito.when(cService.addCustomer(cus)).thenReturn(cus);
		assertEquals(cService.addCustomer(cus), cus);
		verify(repo, Mockito.times(1)).save(cus);
	}

	@Test
	void findAllCustomerTest() {
		Mockito.when(cService.findAllCustomer()).thenReturn(customerList);
		assertEquals(cService.findAllCustomer(), customerList);
	}

	@Test
	void findCustomerByAccNumTest() {
		try {
			Mockito.when(repo.findCustomerByAccNum(12345)).thenReturn(cus)
					.thenAnswer(i -> cService.findCustomerByAccNum(123));
			assertEquals(cus, cService.findCustomerByAccNum(12345));
		} catch (NoSuchCustomerFoundException e) {
			e.printStackTrace();
			fail("Exception not expected");
		}
	}

	@Test
	void findCustomerByIdTest() {
		try {
			Mockito.when(repo.findById(123)).thenReturn(Optional.of(cus))
					.thenAnswer(i -> cService.findCustomerById(123));
			Assertions.assertEquals(cus, cService.findCustomerById(123));
		} catch (NoSuchCustomerFoundException e) {
			e.printStackTrace();
			fail("Exception not expected");
		}
	}

	@Test
	void updateCustomerTest() {
		cus.setName("new name");
		try {
			Mockito.when(repo.findById(123)).thenReturn(Optional.of(cus));
			Mockito.when(cService.updateCustomer(cus, 123)).thenReturn(cus);
			Assertions.assertEquals(cus, cService.updateCustomer(cus, 123));
		} catch (NoSuchCustomerFoundException e) {
			e.printStackTrace();
			fail("Exception not expected");
		}
	}

	@Test
	void removeCustomerTest() {
		customerList.remove(0);

		Mockito.when(repo.findById(123)).thenReturn(Optional.of(cus)).thenAnswer(i -> cService.removeCustomer(123));

		Assertions.assertEquals(true, cService.removeCustomer(123));
		Assertions.assertEquals(customerList, cService.findAllCustomer());
	}
}
