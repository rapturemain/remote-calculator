package com.rapturemain.remotecalculator.common.errors;

import com.rapturemain.remotecalculator.operator.Operation;

import java.util.Arrays;

public class UnknownOperatorError implements RequestHandlingError {
    private static final String MESSAGE_TEMPLATE =
            "Operator [%s] is unknown. Supported operators: " + Arrays.toString(Operation.values());

    private final String message;

    public UnknownOperatorError(String operator) {
        message = String.format(MESSAGE_TEMPLATE, operator);
    }

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.UNKNOWN_OPERATOR;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
