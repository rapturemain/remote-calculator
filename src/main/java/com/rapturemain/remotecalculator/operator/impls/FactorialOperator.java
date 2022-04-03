package com.rapturemain.remotecalculator.operator.impls;

import com.rapturemain.remotecalculator.common.errors.ExtraOperandError;
import com.rapturemain.remotecalculator.common.errors.FactorialOfNegativeOrFloat;
import com.rapturemain.remotecalculator.common.errors.MissedOperandError;
import com.rapturemain.remotecalculator.common.errors.SqrtOfNegativeError;
import com.rapturemain.remotecalculator.operator.Number;
import com.rapturemain.remotecalculator.operator.Operation;
import com.rapturemain.remotecalculator.operator.OperationResult;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class FactorialOperator extends AbstractOperator {
    public FactorialOperator() {
        super(Operation.FACT);
    }

    @Override
    public OperationResult process(List<Number> operands) {
        if (operands.size() < 1) {
            return new OperationResult(new MissedOperandError(myOperator, 1, 0));
        } else if (operands.size() > 1) {
            return new OperationResult(new ExtraOperandError(myOperator, 1, operands.size()));
        }

        BigDecimal operand = operands.get(0).getValue();

        boolean isInteger = operand.signum() == 0 || operand.scale() <= 0 || operand.stripTrailingZeros().scale() <= 0;
        if (!isInteger || operand.signum() == -1) {
            return new OperationResult(new FactorialOfNegativeOrFloat());
        }

        BigDecimal result = BigDecimal.ONE;
        while (operand.signum() == 1) {
            result = result.multiply(operand);
            operand = operand.subtract(BigDecimal.ONE);
        }

        // Let's assume that it is a long operation
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new OperationResult(result);
    }
}
