package com.rapturemain.remotecalculator.common.errors;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FactorialOfNegativeOrFloat implements RequestHandlingError {
    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.FACTORIAL_OF_NEGATIVE_OR_FLOAT;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
