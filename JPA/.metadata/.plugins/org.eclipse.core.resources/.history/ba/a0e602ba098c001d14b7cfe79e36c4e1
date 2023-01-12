package com.cg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emails_map1")
public class EmailAddress {

	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	private long emailID;
	private String emailAddress;

	public long getEmailID() {
		return emailID;
	}

	public void setEmailID(long emailID) {
		this.emailID = emailID;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "EmailAddress [emailID=" + emailID + ", emailAddress=" + emailAddress + "]";
	}

}
