package com.cg.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "courses_sb_assignment")
@Scope("prototype")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course {
	@Id
	@Setter
	@Getter
	private int courseId;
	@Setter
	@Getter
	private String courseName;
	@Setter
	@Getter
	private double courseFees;
}
