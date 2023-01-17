package com.cg.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "students_sb_assignment")
@Scope("prototype")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Setter
	@Getter
	private int id;
	@Setter
	@Getter
	private int roll;
	@Setter
	@Getter
	private String name;
	@OneToMany
	@Setter
	@Getter
	private List<Course> courses = new ArrayList<>();
}
