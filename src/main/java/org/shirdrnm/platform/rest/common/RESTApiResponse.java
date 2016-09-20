/**
 *  Copyright 2016 SmartBear Software
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.shirdrnm.platform.rest.common;

import javax.xml.bind.annotation.XmlTransient;

import org.springframework.http.HttpStatus;

@javax.xml.bind.annotation.XmlRootElement
public class RESTApiResponse {

	public static final int OK = 200;
	public static final int BAD_REQUEST = 400;
	public static final int NOT_FOUND = 404;
	public static final int CONFLICT = 409;
	public static final int INTERNAL_SERVER_ERROR = 500;
	public static final int SERVICE_UNAVAILABLE = 503;
	
	private int code;
	private String type;
	private String message;

	public RESTApiResponse(HttpStatus httpStatus, String message) {
		this.code = httpStatus.value();
		this.type = httpStatus.getReasonPhrase();
		switch (this.code) {
			case OK:
				break;
			case NOT_FOUND:
				break;
			case BAD_REQUEST:
				break;
			case INTERNAL_SERVER_ERROR:
				break;
			case CONFLICT:
				break;
			default:
				setType("unknown exception");
				break;
		}
		this.message = message;
	}

	@XmlTransient
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
