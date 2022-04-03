package com.rapturemain.remotecalculator.operator;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.MathContext;

@Getter
public class Number {
    private final String rawValue;
    private final BigDecimal value;

    public Number(String rawValue) throws NumberFormatException {
        this.rawValue = rawValue;
        this.value = new BigDecimal(rawValue, MathContext.DECIMAL128);
    }
}
