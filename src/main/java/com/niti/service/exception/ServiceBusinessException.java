package com.niti.service.exception;


public class ServiceBusinessException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceBusinessException(String message, ErrorCode errorCode) {
		super(message, errorCode);
	}

}
