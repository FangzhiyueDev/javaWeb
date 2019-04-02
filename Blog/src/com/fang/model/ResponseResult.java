package com.fang.model;

public class ResponseResult extends Error{

	private int errorCode;
	
	public ResponseResult(String errorCause,int errorCode) {
		super(errorCause);
		this.errorCode=errorCode;
	}
	
	public ResponseResult() {
		
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	@Override
	public String toString() {
		return "ResposneResult [errorCode=" + errorCode + ", errorCause=" + errorCause + "]";
	}
	
	
	
	
	

}
