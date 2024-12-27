package com.elsa.vocab.infrastructure.configuration.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommonError implements Error {

    SystemBusy("999", "Something went wrong"),
    Unauthorized("998", "Unauthorized"),
    Forbidden("997", "Forbidden"),
    MissingParams("996", "Missing parameters"),
    ResourceNotfound("995", "Resource not found"),
    Duplicated("994", "Duplicated"),
    InvalidParams("993", "Invalid parameters");

    private final String code;
    private final String message;

}
