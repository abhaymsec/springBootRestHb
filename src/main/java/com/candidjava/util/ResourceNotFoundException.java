package com.candidjava.util;

public class ResourceNotFoundException extends RuntimeException {
	private String errorCode;
	private String errorMsg;
	
	public ResourceNotFoundException(String errorMsg) {
		super(errorMsg);
	}
	
	public ResourceNotFoundException(String errorCode,String errorMsg) {
		super(errorMsg);
		this.errorCode = errorCode;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}

}
