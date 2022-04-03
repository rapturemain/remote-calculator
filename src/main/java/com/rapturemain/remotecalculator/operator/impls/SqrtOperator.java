package com.rapturemain.remotecalculator.operator.impls;

import com.rapturemain.remotecalculator.common.errors.ExtraOperandError;
import com.rapturemain.remotecalculator.common.errors.MissedOperandError;
import com.rapturemain.remotecalculator.common.errors.SqrtOfNegativeError;
import com.rapturemain.remotecalculator.operator.Number;
import com.rapturemain.remotecalculator.operator.Operation;
import com.rapturemain.remotecalculator.operator.OperationResult;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

@Component
public class SqrtOperator extends AbstractOperator {
    public SqrtOperator() {
        super(Operation.SQRT);
    }

    @Override
    public OperationResult process(List<Number> operands) {
        if (operands.size() < 1) {
            return new OperationResult(new MissedOperandError(myOperator, 1, 0));
        } else if (operands.size() > 1) {
            return new OperationResult(new ExtraOperandError(myOperator, 1, operands.size()));
        }

        if (operands.get(0).getValue().signum() == -1) {
            return new OperationResult(new SqrtOfNegativeError());
        }

        BigDecimal result = operands.get(0).getValue().sqrt(MathContext.DECIMAL128);

        // Let's assume that it is a long operation
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new OperationResult(result);
    }
}
