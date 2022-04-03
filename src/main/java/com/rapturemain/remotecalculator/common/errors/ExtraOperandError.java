package com.rapturemain.remotecalculator.common.errors;

import com.rapturemain.remotecalculator.operator.Operation;

public class ExtraOperandError implements RequestHandlingError {
    private static final String MESSAGE_TEMPLATE =
            "Operation [%s] requires at most [%s] operands, but provided [%s]";

    private final String message;

    public ExtraOperandError(Operation operation, int requiredOperators, int providedOperators) {
        message = String.format(MESSAGE_TEMPLATE, operation, requiredOperators, providedOperators);
    }

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.EXTRA_OPERAND;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
