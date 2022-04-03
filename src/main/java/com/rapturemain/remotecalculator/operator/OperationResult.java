package com.rapturemain.remotecalculator.operator;

import com.rapturemain.remotecalculator.common.errors.RequestHandlingError;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OperationResult {
    private final BigDecimal result;
    private final RequestHandlingError error;

    public OperationResult(BigDecimal result) {
        this(result, null);
    }

    public OperationResult(RequestHandlingError error) {
        this(null, error);
    }
}
