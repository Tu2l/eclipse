package com.cg.entity;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "person_map1")
public class Person {
	@Id
	private int id;
	private String name;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name= "fk_person")
	private Collection<EmailAddress> mails = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<EmailAddress> getMails() {
		return mails;
	}

	public void setMails(Collection<EmailAddress> mails) {
		this.mails = mails;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", mails=" + mails + "]";
	}

	

}
