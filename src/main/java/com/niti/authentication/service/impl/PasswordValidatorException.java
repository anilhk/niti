package com.niti.authentication.service.impl;

public class PasswordValidatorException  extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PasswordValidatorException(String message, Throwable e) {
		super(message);
	}
	
	public PasswordValidatorException(String message) {
		super(message);
	}
	
}
