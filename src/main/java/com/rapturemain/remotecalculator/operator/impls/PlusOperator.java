package com.rapturemain.remotecalculator.operator.impls;

import com.rapturemain.remotecalculator.common.errors.MissedOperandError;
import com.rapturemain.remotecalculator.operator.Number;
import com.rapturemain.remotecalculator.operator.Operation;
import com.rapturemain.remotecalculator.operator.OperationResult;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class PlusOperator extends AbstractOperator {
    public PlusOperator() {
        super(Operation.PLUS);
    }

    @Override
    public OperationResult process(List<Number> operands) {
        if (operands.size() < 2) {
            return new OperationResult(new MissedOperandError(myOperator, 2, operands.size()));
        }

        BigDecimal result = operands.get(0).getValue();

        for (int i = 1; i < operands.size(); i++) {
            result = result.add(operands.get(i).getValue());
        }

        return new OperationResult(result);
    }
}
