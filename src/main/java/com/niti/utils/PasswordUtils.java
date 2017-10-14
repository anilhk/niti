package com.niti.utils;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public final class PasswordUtils {

	private static final Logger logger = LoggerFactory.getLogger(PasswordUtils.class);
	
	public static String hashPassword(String password) {
		
		String salt = BCrypt.gensalt();
		System.out.println("Salt " +salt);
		logger.debug("salt " +salt);
		String hashedPassword = BCrypt.hashpw(password, salt);
		System.out.println(" hashedPassword " +hashedPassword);
		logger.debug("hashed Password " +hashedPassword);
		return hashedPassword;
		
	}
	
	public static boolean checkPassword(String password, String hashedPassword) {
			return BCrypt.checkpw(password, hashedPassword);
	}
	
	
}
