package com.niti.controller.exception;

import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.ImmutableMap;
import com.niti.service.exception.ServiceBusinessException;
import com.niti.service.exception.ServiceException;

@ControllerAdvice
public class ControllerExceptionHandler {

	private static final Map<ServiceException.ErrorCode, ExceptionMapping> EXCEPTIONMAPPING = ImmutableMap.<ServiceException.ErrorCode, ExceptionMapping>builder()
			.put(ServiceException.ErrorCode.TECHNICAL_ERROR, createExceptionMapping(500, 1))
			.put(ServiceException.ErrorCode.DATA_ALREADY_EXISTS, createExceptionMapping(400, 2))
			.put(ServiceException.ErrorCode.DATA_NOT_FOUND_EXCEPTION, createExceptionMapping(402, 3))
			.put(ServiceException.ErrorCode.NULL_OBJECT_REFERENCE, createExceptionMapping(400, 4))
			.put(ServiceException.ErrorCode.NULL_EMAIL_ADDRESS, createExceptionMapping(400, 5))
			.put(ServiceException.ErrorCode.USER_ALREADY_EXISTS, createExceptionMapping(400, 6))
			.put(ServiceException.ErrorCode.BLANK_PASSWORD, createExceptionMapping(400, 7))
			.put(ServiceException.ErrorCode.PASSWORD_CONFIRM_PASSWORD_NOT_MATCH, createExceptionMapping(400, 8))
			.put(ServiceException.ErrorCode.PASSWORD_VALIDATION_FAILED, createExceptionMapping(400, 9))
			.put(ServiceException.ErrorCode.INVALID_USER_ID_OR_PASSWORD,createExceptionMapping(400, 10))
			.build();

	@ResponseBody
	@ExceptionHandler
	ExceptionMapping handle(ServiceBusinessException e) {
		ExceptionMapping exceptionMapping = EXCEPTIONMAPPING.get(e.getErrorCode());
		String developerMessage = e.getMessage();
		exceptionMapping.developerMessage = developerMessage + " :: " + getdeveloperMessage(e);
		return exceptionMapping;
	}

	private String getdeveloperMessage(ServiceBusinessException e) {

		String devMessage = "";
		if (e.getStackTrace() != null && e.getStackTrace().length > 0) {
			StackTraceElement stackTraceElement = e.getStackTrace()[0];
			String className = stackTraceElement.getClassName();
			devMessage = className.substring(className.lastIndexOf('.') + 1) + "." + stackTraceElement.getMethodName()
					+ "()" + ":" + stackTraceElement.getLineNumber();
		} else {
			devMessage = e.toString();
		}
		return devMessage;
	}

	private static ExceptionMapping createExceptionMapping(Integer httpStatusCode, Integer errorCode) {

		ExceptionMapping exceptionMapping = new ExceptionMapping();
		exceptionMapping.httpStatusCode = httpStatusCode;
		exceptionMapping.errorCode = errorCode;
		return exceptionMapping;

	}

	private static class ExceptionMapping {

		public Integer httpStatusCode;
		public Integer errorCode;
		public String developerMessage;

	}

}
