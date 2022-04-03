package com.rapturemain.remotecalculator.operator.impls;

import com.rapturemain.remotecalculator.common.errors.DivisionByZeroError;
import com.rapturemain.remotecalculator.common.errors.MissedOperandError;
import com.rapturemain.remotecalculator.operator.Number;
import com.rapturemain.remotecalculator.operator.Operation;
import com.rapturemain.remotecalculator.operator.OperationResult;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

@Component
public class DivisionOperator extends AbstractOperator {
    public DivisionOperator() {
        super(Operation.DIV);
    }

    @Override
    public OperationResult process(List<Number> operands) {
        if (operands.size() < 2) {
            return new OperationResult(new MissedOperandError(myOperator, 2, operands.size()));
        }

        for (int i = 1 ; i < operands.size() ; i++) {
            if (operands.get(i).getValue().signum() == 0) {
                return new OperationResult(new DivisionByZeroError());
            }
        }

        BigDecimal result = operands.get(0).getValue();

        for (int i = 1 ; i < operands.size() ; i++) {
            BigDecimal operand = operands.get(i).getValue();
            result = result.divide(operand, MathContext.DECIMAL128);
        }

        return new OperationResult(result);
    }
}
