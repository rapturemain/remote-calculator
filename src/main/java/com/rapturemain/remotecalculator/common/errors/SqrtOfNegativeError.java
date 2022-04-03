package com.rapturemain.remotecalculator.common.errors;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SqrtOfNegativeError implements RequestHandlingError {
    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.SQRT_OF_NEGATIVE;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
