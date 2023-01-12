package com.cg.app;

public class Customer2 {
	private String name;
	private Account2 bankAccount;
	
	public Customer2() {}

	public Customer2(String name, Account2 bankAccount) {
		super();
		this.name = name;
		this.bankAccount = bankAccount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account2 getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(Account2 bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + "]";
	}

}
