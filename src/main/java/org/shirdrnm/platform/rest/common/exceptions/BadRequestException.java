package org.shirdrnm.platform.rest.common.exceptions;

import org.springframework.http.HttpStatus;

public class BadRequestException extends ApiException {
	
	private static final long serialVersionUID = 1L;

	public BadRequestException(String msg) {
		super(HttpStatus.BAD_REQUEST, msg);
	}
}
