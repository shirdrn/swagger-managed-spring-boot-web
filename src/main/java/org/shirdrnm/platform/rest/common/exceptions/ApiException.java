package org.shirdrnm.platform.rest.common.exceptions;

import org.springframework.http.HttpStatus;

public class ApiException extends Exception {

	private static final long serialVersionUID = 302647183999823340L;
	protected final HttpStatus httpStatus;

	public ApiException(HttpStatus httpStatus, String msg) {
		super(msg);
		this.httpStatus = httpStatus;
	}
}
