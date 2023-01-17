package com.cg.dto;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class StudentDTO {
	private int id;
	@NotNull(message = "Name must not be null")
	@Size(min = 3, message = "Name must be atleast 3 character long")
	private String name;
	@Min(value = 1, message = "Roll number must be greater than 0")
	private int roll;
	private List<CourseDTO>courses;
}
