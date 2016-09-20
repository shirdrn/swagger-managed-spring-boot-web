package org.shirdrnm.platform.rest.common.exceptions;

import org.springframework.http.HttpStatus;

public class InternalServerException extends ApiException {

	private static final long serialVersionUID = 1L;

	public InternalServerException(String msg) {
		super(HttpStatus.INTERNAL_SERVER_ERROR, msg);
	}
}
