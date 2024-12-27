package com.elsa.vocab.infrastructure.configuration.exception;

import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException {

    private String code;
    private String message;

    public ApplicationException(Error error) {
        super(error.getMessage());
        this.code = error.getCode();
        this.message = error.getMessage();
    }

    public ApplicationException(Error error, String customMessage) {
        super(error.getMessage());
        this.code = error.getCode();
        this.message = customMessage;
    }

    public ApplicationException(String message) {
        super(message);
        this.message = message;
        this.code = CommonError.SystemBusy.getCode();
    }

    public ApplicationException(Throwable throwable) {
        super(throwable);
        this.message = CommonError.SystemBusy.getMessage();
        this.code = CommonError.SystemBusy.getCode();
    }
}
