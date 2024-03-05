package com.studentdata.service;

import com.studentdata.model.StudentDetailsModel;

import jakarta.validation.Valid;

public interface StudentService {

	StudentDetailsModel saveStudentDetails(@Valid StudentDetailsModel studentDetailsModel);

	StudentDetailsModel getStudentDetails(Long studentId);

	void updateStudentDetails(Long studentId, StudentDetailsModel detailsModel);

	void deleteStudentDetails(Long studentId);

}
