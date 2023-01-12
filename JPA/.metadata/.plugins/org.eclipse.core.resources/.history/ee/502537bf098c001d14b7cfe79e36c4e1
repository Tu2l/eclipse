package com.cg.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emp_map1")
public class Employee {

	@Id
	@Column(name = "e_id")
	private int empid;

	@Column(name = "e_name")
	private String name;

	@Column(name = "e_dept")
	private String dept;

	@Column(name = "e_salary")
	private double salary;
	
	@OneToOne (cascade = CascadeType.ALL)
	private Account account;

	public Employee() {
	}

	public Employee(int empid, String name, String dept, double salary, Account account) {
		super();
		this.empid = empid;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
		this.account = account;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", dept=" + dept + ", salary=" + salary + ", account="
				+ account.toString() + "]";
	}

	
	
	

}
