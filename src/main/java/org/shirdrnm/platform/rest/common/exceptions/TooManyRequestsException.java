package org.shirdrnm.platform.rest.common.exceptions;

import org.springframework.http.HttpStatus;

public class TooManyRequestsException extends ApiException {
	
	private static final long serialVersionUID = 1L;

	public TooManyRequestsException(String msg) {
		super(HttpStatus.TOO_MANY_REQUESTS, msg);
	}
}
