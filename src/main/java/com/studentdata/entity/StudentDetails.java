package com.studentdata.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "STUDENT_DETAILS")
public class StudentDetails {

	@Id
	@GeneratedValue(generator = "STD_SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName = "STD_SEQ", name = "STD_SEQ", initialValue = 1000)
	private Long studentId;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String mobileNumber;
	private String address;
	private String aadharNumber;
	private String department;
	@JsonFormat(pattern = "DD-MM-YYYY")
	private LocalDateTime createdDate;

}
