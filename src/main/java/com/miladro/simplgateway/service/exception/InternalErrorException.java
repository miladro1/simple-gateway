package com.miladro.simplgateway.service.exception;

import org.springframework.http.HttpStatus;

public class InternalErrorException extends CommonException {

    public InternalErrorException(Throwable cause) {
        super(HttpStatus.INTERNAL_SERVER_ERROR,"{common.error.internal}",cause);
    }

}
