package com.studentdata.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDetailsModel {
	
	private Long studentId;
	
	@NotBlank(message = "First Name can't be null/blank")
	private String firstName;
	
	@NotBlank(message = "Last Name can't be null/blank")
	private String lastName;
	
	@NotNull(message = "Date Of Birth can't be null/blank")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;
	
	@NotBlank(message = "Mobile Number can't be null/blank")
	private String mobileNumber;
	
	@NotBlank(message = "Address can't be null/blank")
	private String address;
	
	@NotEmpty(message = "Aadhar Number can't be null/blank")
	private String aadharNumber;
	
	@NotBlank(message = "Department can't be null/blank")
	private String department;

}
