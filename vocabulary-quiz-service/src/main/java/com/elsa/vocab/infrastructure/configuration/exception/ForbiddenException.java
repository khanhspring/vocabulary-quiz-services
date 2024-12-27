package com.elsa.vocab.infrastructure.configuration.exception;

public class ForbiddenException extends ApplicationException {

    public ForbiddenException() {
        super(CommonError.Forbidden);
    }
}
