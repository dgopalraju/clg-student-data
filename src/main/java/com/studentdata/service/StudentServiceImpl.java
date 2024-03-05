package com.studentdata.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.studentdata.entity.StudentDetails;
import com.studentdata.exceptioncontroller.ValidationException;
import com.studentdata.model.StudentDetailsModel;
import com.studentdata.repositary.StudentRepositary;

import jakarta.validation.Valid;

@Service
public class StudentServiceImpl implements StudentService {

	private final StudentRepositary studentRepositary;

	public StudentServiceImpl(StudentRepositary studentRepositary) {
		super();
		this.studentRepositary = studentRepositary;
	}

	@Override
	public StudentDetailsModel saveStudentDetails(@Valid StudentDetailsModel studentDetailsModel) {
		StudentDetails studentDetails = new StudentDetails();
		studentDetails.setCreatedDate(LocalDateTime.now());
		BeanUtils.copyProperties(studentDetailsModel, studentDetails);
		studentDetails = studentRepositary.save(studentDetails);
		studentDetailsModel.setStudentId(studentDetails.getStudentId());
		return studentDetailsModel;
	}

	@Override
	public StudentDetailsModel getStudentDetails(Long studentId) {
		StudentDetails stdDetails = studentIdCheck(studentId);
		StudentDetailsModel studentDetailsModel = new StudentDetailsModel();
		BeanUtils.copyProperties(stdDetails, studentDetailsModel);
		return studentDetailsModel;
	}

	@Override
	public void updateStudentDetails(Long studentId, StudentDetailsModel detailsModel) {
		StudentDetails stdDetails = studentIdCheck(studentId);
		detailsModel.setStudentId(studentId);
		BeanUtils.copyProperties(detailsModel, stdDetails);
		studentRepositary.save(stdDetails);
	}

	@Override
	public void deleteStudentDetails(Long studentId) {
		studentIdCheck(studentId);
		studentRepositary.deleteById(studentId);
	}

	private StudentDetails studentIdCheck(Long studentId) {
		Optional<StudentDetails> stdDetails = studentRepositary.findById(studentId);
		if (stdDetails.isEmpty()) {
			throw new ValidationException("Sorry. Provided StudentId doesn't contain any details");
		}
		return stdDetails.get();
	}

}
