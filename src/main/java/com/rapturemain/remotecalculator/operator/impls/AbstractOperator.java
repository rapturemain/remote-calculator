package com.rapturemain.remotecalculator.operator.impls;

import com.rapturemain.remotecalculator.operator.Operation;
import com.rapturemain.remotecalculator.operator.Operator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
abstract class AbstractOperator implements Operator {
    protected final Operation myOperator;

    @Override
    public boolean canProcess(Operation operator) {
        return myOperator == operator;
    }

    @Override
    public Operation processableOperator() {
        return myOperator;
    }
}
