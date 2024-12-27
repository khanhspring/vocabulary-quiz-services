package com.elsa.vocab.infrastructure.configuration.exception;

public class UnauthorizedException extends ApplicationException {

    public UnauthorizedException() {
        super(CommonError.Unauthorized);
    }
}
