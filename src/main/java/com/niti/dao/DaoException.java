package com.niti.dao;

public class DaoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public DaoException(String message) {
		super(message);
	}
	
	public DaoException(String message, Throwable e) {
		super(message, e);
	}
	
	public DaoException(Throwable e) {
		super(e);
	}
}
