package com.rapturemain.remotecalculator.common.errors;

public class WrongOperandFormatException implements RequestHandlingError {
    private static final String MESSAGE_TEMPLATE =
            "Operand with index [%s] has a wrong format, cannot be casted to a [%s]. Operand value: [%s]";

    private final String message;

    public WrongOperandFormatException(int index, String requiredType, String originalValue) {
        message = String.format(MESSAGE_TEMPLATE, index, requiredType, originalValue);
    }

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.WRONG_OPERAND_FORMAT;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
