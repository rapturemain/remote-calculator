package com.rapturemain.remotecalculator.common.errors;

public interface RequestHandlingError {
    ErrorCode getErrorCode();
    String getMessage();
}
