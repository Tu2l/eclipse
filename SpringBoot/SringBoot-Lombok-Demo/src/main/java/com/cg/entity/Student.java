package com.cg.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
	@Id
	@Getter
	@Setter
	private int roll;
	@Getter
	@Setter
	private String name;
}
