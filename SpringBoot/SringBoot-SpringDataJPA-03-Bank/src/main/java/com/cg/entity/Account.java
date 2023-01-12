package com.cg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;

@Entity
@Table(name = "accounts_sb")
@Scope("prototype")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accId;
	private long accountNumber;
	private String type;

	public Account() {
	}

	public Account(int accId, long accountNumber, String type) {
		super();
		this.accId = accId;
		this.accountNumber = accountNumber;
		this.type = type;
	}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Account [accId=" + accId + ", accountNumber=" + accountNumber + ", type=" + type + "]";
	}

}
