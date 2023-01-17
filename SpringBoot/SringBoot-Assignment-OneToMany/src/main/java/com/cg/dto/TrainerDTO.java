package com.cg.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TrainerDTO {
	private int tId;

	// @Min or
	// @Max annotation is used to limit the value of a field.
	// In the below code, the tName field can have the maximum value of 5.
	@NotNull
	// @Min(value = 2, message = "First Name should have atleast 3 characters")
	private String firstName;

	@NotNull(message = "Last Name is required")
	private String lastName;

	@NotEmpty
	@Email(message = "wrong email")
	private String email;

	@Past(message = "date must be past date")
	private LocalDate joiningDate;

	/*
	 * @Size annotation is used to restrict the filed length to a specified value.
	 * It has attributes such as max and min which are used to set the maximum and
	 * minimum values respectively. The message attribute in this annotation is used
	 * to display a default message on validation failure.
	 */

	@NotNull
	@Column(precision = 3)
	private String compName;

	@NotNull
	private String subject;

}
