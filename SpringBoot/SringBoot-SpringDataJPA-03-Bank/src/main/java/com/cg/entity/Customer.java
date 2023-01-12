package com.cg.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;

@Entity
@Table(name = "customers_sb")
@Scope("prototype")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int customerId;
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_account",referencedColumnName = "accId")
	private Account bankAccount;

	public Customer() {
	}

	public Customer(int customerId, String name, Account bankAccount) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.bankAccount = bankAccount;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(Account bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", bankAccount=" + bankAccount + "]";
	}

}
