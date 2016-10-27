package com.norulesweb.springapp.api.common;

import org.springframework.validation.FieldError;

import javax.validation.ValidationException;
import java.util.List;

public class AppDataValidationException extends ValidationException {

	private static final long serialVersionUID = 9111014661644720446L;

	public AppDataValidationException() { super(); }

	public AppDataValidationException(String message) { super(message); }

	private List<FieldError> fieldErrors;

}
