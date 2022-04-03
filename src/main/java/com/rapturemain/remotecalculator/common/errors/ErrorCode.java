package com.rapturemain.remotecalculator.common.errors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    MISSED_OPERAND,
    EXTRA_OPERAND,
    WRONG_OPERAND_FORMAT,
    DIVISION_BY_ZERO,
    SQRT_OF_NEGATIVE,
    FACTORIAL_OF_NEGATIVE_OR_FLOAT,
    UNKNOWN_OPERATOR,
}
