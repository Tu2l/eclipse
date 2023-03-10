package com.cg.entity;

import org.springframework.stereotype.Component;

@Component
public class Account {
	private long id;
	private String accType;
	private double accBalance;

	public Account() {
	}

	public Account(long id, String accType, double accBalance) {
		super();
		this.id = id;
		this.accType = accType;
		this.accBalance = accBalance;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public double getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accType=" + accType + ", accBalance=" + accBalance + "]";
	}

}
