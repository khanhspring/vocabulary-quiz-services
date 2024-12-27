package com.elsa.authserver.infrastructure.common.exception;

import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException {

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(Throwable throwable) {
        super(throwable);
    }
}
