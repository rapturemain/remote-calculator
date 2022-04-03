package com.rapturemain.remotecalculator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CalculationRequest {
    private final List<String> operands;
    private final String operator;
}
