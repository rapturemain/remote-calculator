package com.rapturemain.remotecalculator.common.errors;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DivisionByZeroError implements RequestHandlingError {
    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.DIVISION_BY_ZERO;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
