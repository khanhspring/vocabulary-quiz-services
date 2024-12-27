package com.elsa.vocab.infrastructure.configuration.exception;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ErrorResponse {
    private String code;
    private String message;
    private List<ErrorDetail> details;

    public static class ErrorDetail {
        private String field;
        private String message;
    }
}
