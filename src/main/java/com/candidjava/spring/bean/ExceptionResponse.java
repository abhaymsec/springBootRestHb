package com.candidjava.spring.bean;

public class ExceptionResponse {
	private String errorCode;
	private String errorMsg;
	
	public ExceptionResponse() {
		// TODO Auto-generated constructor stub
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
