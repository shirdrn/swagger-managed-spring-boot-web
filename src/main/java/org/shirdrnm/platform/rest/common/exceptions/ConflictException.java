package org.shirdrnm.platform.rest.common.exceptions;

import org.springframework.http.HttpStatus;

public class ConflictException extends ApiException {

	private static final long serialVersionUID = 1L;

	public ConflictException(String msg) {
		super(HttpStatus.CONFLICT, msg);
	}
}
