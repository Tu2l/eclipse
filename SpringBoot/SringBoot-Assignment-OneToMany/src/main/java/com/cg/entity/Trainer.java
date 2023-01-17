package com.cg.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Trainer_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Trainer {

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private int tId;
	private String firstName;
	private String lastName;
	private LocalDate joiningDate;
	private String email;
	private String compName;
	private String subject;
}
