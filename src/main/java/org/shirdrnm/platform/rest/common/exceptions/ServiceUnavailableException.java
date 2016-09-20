package org.shirdrnm.platform.rest.common.exceptions;

import org.springframework.http.HttpStatus;

public class ServiceUnavailableException extends ApiException {
	
	private static final long serialVersionUID = 1L;

	public ServiceUnavailableException(String msg) {
		super(HttpStatus.SERVICE_UNAVAILABLE, msg);
	}
}
