package com.rapturemain.remotecalculator.common.errors;

import com.rapturemain.remotecalculator.operator.Operation;

public class MissedOperandError implements RequestHandlingError {
    private static final String MESSAGE_TEMPLATE =
            "Operation [%s] requires at least [%s] operands, but provided only [%s]";

    private final String message;

    public MissedOperandError(Operation operation, int requiredOperators, int providedOperators) {
        message = String.format(MESSAGE_TEMPLATE, operation, requiredOperators, providedOperators);
    }


    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.MISSED_OPERAND;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
