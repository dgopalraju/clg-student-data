package com.studentdata.exceptioncontroller;

import lombok.Getter;

@Getter
public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String error;

	public ValidationException(String error) {
		super();
		this.error = error;
	}

	public ValidationException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ValidationException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ValidationException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
