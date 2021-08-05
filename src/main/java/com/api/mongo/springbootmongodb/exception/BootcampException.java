package com.api.mongo.springbootmongodb.exception;

import org.springframework.http.HttpStatus;

public class BootcampException extends Exception {

	private static final long serialVersionUID = 1345809057356085924L;

	private final String[] values;
	private HttpStatus httpStatus;

	public BootcampException(final String message, final String[] dynamicValues, final HttpStatus status) {
		super(message);
		values = dynamicValues;
		httpStatus = status;
	}

	public String[] getValues() {
		return values;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

}
