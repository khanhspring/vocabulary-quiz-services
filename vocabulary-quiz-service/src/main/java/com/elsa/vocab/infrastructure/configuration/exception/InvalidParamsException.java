package com.elsa.vocab.infrastructure.configuration.exception;

public class InvalidParamsException extends ApplicationException {

    public InvalidParamsException() {
        super(CommonError.InvalidParams);
    }

    public InvalidParamsException(String message) {
        super(CommonError.InvalidParams, message);
    }
}
