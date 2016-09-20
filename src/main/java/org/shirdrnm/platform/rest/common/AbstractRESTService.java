package org.shirdrnm.platform.rest.common;

import org.shirdrnm.platform.rest.common.exceptions.BadRequestException;
import org.shirdrnm.platform.rest.common.exceptions.ConflictException;
import org.shirdrnm.platform.rest.common.exceptions.InternalServerException;
import org.shirdrnm.platform.rest.common.exceptions.NotFoundException;
import org.shirdrnm.platform.rest.common.exceptions.ServiceUnavailableException;
import org.shirdrnm.platform.rest.common.exceptions.TooManyRequestsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class AbstractRESTService {

    @CrossOrigin(allowedHeaders = "*", origins = "*")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public RESTApiResponse handleNotFoundException(NotFoundException e) {
        return new RESTApiResponse(HttpStatus.NOT_FOUND, e.getMessage());
    }
    
    @CrossOrigin(allowedHeaders = "*", origins = "*")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public RESTApiResponse handleBadRequestException(BadRequestException e) {
        return new RESTApiResponse(HttpStatus.BAD_REQUEST, e.getMessage());
    }
    
    @CrossOrigin(allowedHeaders = "*", origins = "*")
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(ConflictException.class)
    public RESTApiResponse handleConflictException(ConflictException e) {
        return new RESTApiResponse(HttpStatus.CONFLICT, e.getMessage());
    }
    
    @CrossOrigin(allowedHeaders = "*", origins = "*")
    @ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
    @ExceptionHandler(TooManyRequestsException.class)
    public RESTApiResponse handleTooManyRequestsException(TooManyRequestsException e) {
        return new RESTApiResponse(HttpStatus.TOO_MANY_REQUESTS, e.getMessage());
    }
    
    @CrossOrigin(allowedHeaders = "*", origins = "*")
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InternalServerException.class)
    public RESTApiResponse handleInternalServerException(InternalServerException e) {
        return new RESTApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
    
    @CrossOrigin(allowedHeaders = "*", origins = "*")
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(ServiceUnavailableException.class)
    public RESTApiResponse handleServiceUnavailableException(ServiceUnavailableException e) {
        return new RESTApiResponse(HttpStatus.SERVICE_UNAVAILABLE, e.getMessage());
    }
    
}
