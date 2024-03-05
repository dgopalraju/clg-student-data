package com.studentdata.exceptioncontroller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.studentdata.model.ResponseError;

@RestControllerAdvice
public class ContollerExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseError> exceptionMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
		FieldError fieldError = exception.getBindingResult().getFieldError();
		String message = fieldError.getDefaultMessage();
		ResponseError responseError = ResponseError.builder().error(message).status(HttpStatus.BAD_REQUEST)
				.timestamp(LocalDateTime.now()).build();
		return new ResponseEntity<ResponseError>(responseError, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<ResponseError> exceptionValidationException(ValidationException exception) {
		ResponseError responseError = ResponseError.builder().error(exception.getError())
				.status(HttpStatus.NOT_FOUND).timestamp(LocalDateTime.now()).build();
		return new ResponseEntity<>(responseError, HttpStatus.NOT_FOUND);
	}

}
