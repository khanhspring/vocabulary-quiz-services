package com.elsa.vocab.infrastructure.configuration.exception;

public class DuplicatedException extends ApplicationException {

    public DuplicatedException() {
        super(CommonError.Duplicated);
    }
}
