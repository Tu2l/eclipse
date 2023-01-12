package com.cg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>  {
	@Query("Select c from Customer c where c.bankAccount.accountNumber =:accountNumber")
	Customer findCustomerByAccNum(@Param("accountNumber")long accountNumber);
	
}
