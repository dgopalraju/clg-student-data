package com.studentdata.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentdata.model.StudentDetailsModel;
import com.studentdata.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("student")
public class StudentController {

	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@PostMapping("create")
	public String saveStudentDetails(@Valid @RequestBody StudentDetailsModel studentDetailsModel) {
		StudentDetailsModel saveStudentDetails = studentService.saveStudentDetails(studentDetailsModel);
		return "Successfully Saved Student Details. Reference Student Id: " + saveStudentDetails.getStudentId();
	}

	@GetMapping("{studentId}")
	public StudentDetailsModel getStudentDetails(@PathVariable(required = true) Long studentId) {
		return studentService.getStudentDetails(studentId);
	}

	@PutMapping("{studentId}")
	public ResponseEntity<String> updateStudentDetails(@PathVariable Long studentId,
			@RequestBody StudentDetailsModel detailsModel) {
		studentService.updateStudentDetails(studentId, detailsModel);
		return new ResponseEntity<>("Updated student details successfully.", HttpStatus.OK);
	}

	@DeleteMapping("{studentId}")
	public ResponseEntity<String> deleteStudentDetails(@PathVariable Long studentId) {
		studentService.deleteStudentDetails(studentId);
		return new ResponseEntity<String>("StudentId deleted successfully.", HttpStatus.ACCEPTED);
	}

}
