package com.elsa.vocab.infrastructure.configuration.exception;

public class MissingParamsException extends ApplicationException {

    public MissingParamsException() {
        super(CommonError.MissingParams);
    }
}
