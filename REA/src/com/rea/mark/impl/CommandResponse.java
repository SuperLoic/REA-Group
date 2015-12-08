package com.rea.mark.impl;

/**
 * Command response
 * 
 * @author Mark
 *
 */
public class CommandResponse {
	// successfully executed status
	private boolean successfullyExecuted;
	// corresponding command class
	private Class<?> clazz;
	// response message
	private String message;
	// response code
	private int responseCode;

	public CommandResponse() {
	}

	public CommandResponse(boolean successfullyExecuted, Class<?> clazz, String message, int responseCode) {
		super();
		this.successfullyExecuted = successfullyExecuted;
		this.clazz = clazz;
		this.message = message;
		this.responseCode = responseCode;
	}

	public boolean isSuccessfullyExecuted() {
		return successfullyExecuted;
	}

	public void setSuccessfullyExecuted(boolean successfullyExecuted) {
		this.successfullyExecuted = successfullyExecuted;
	}

	public Class<?> getClazz() {
		return clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

}
