package com.rapturemain.remotecalculator.operator;

import java.util.List;

public interface Operator {
    Operation processableOperator();
    boolean canProcess(Operation operator);
    OperationResult process(List<Number> operands);
}
