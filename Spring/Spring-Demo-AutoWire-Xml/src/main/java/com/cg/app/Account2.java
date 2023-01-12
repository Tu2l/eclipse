package com.cg.app;

public class Account2 {
	private long accountNo;
	private String accountType;

	public Account2() {
	}

	public Account2(long accountNo, String accountType) {
		super();
		this.accountNo = accountNo;
		this.accountType = accountType;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", accountType=" + accountType + "]";
	}

}
