package com.elsa.vocab.infrastructure.configuration.exception;

public class ResourceNotFoundException extends ApplicationException {

    public ResourceNotFoundException() {
        super(CommonError.ResourceNotfound);
    }
}
