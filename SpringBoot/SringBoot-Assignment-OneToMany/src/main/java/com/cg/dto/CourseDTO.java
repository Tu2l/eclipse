package com.cg.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CourseDTO {
	@Min(value = 1, message = "courseId must be greater than 0")
	private int courseId;
	@NotNull(message = "courseName must not be null")
	private String courseName;
	@Min(value = 1000, message = "courseFees must be greater than 1000")
	private double courseFees;
}
