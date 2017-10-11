package com.niti.service.exception;


public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	private ErrorCode errorCode;
	
	public enum ErrorCode {
		
		TECHNICAL_ERROR,
		DATA_NOT_FOUND_EXCEPTION,
		NULL_OBJECT_REFERENCE,
		DATA_ALREADY_EXISTS;
		
	}
	
	public ServiceException(String message,ErrorCode errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
	
	public ServiceException(String message, Throwable e,ErrorCode errorCode) {
		super(message,e);
		this.errorCode = errorCode;
		
	}
	
	public ServiceException(Throwable e) {
		super(e);
	}

	
	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}
}
