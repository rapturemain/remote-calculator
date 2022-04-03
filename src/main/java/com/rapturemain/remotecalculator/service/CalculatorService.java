package com.rapturemain.remotecalculator.service;

import com.rapturemain.remotecalculator.common.errors.UnknownOperatorError;
import com.rapturemain.remotecalculator.common.errors.WrongOperandFormatException;
import com.rapturemain.remotecalculator.model.CalculationRequest;
import com.rapturemain.remotecalculator.operator.Number;
import com.rapturemain.remotecalculator.operator.Operation;
import com.rapturemain.remotecalculator.operator.OperationResult;
import com.rapturemain.remotecalculator.operator.Operator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CalculatorService {
    private final List<Operator> operators;

    private final Map<String, Operator> stringOperatorMap = new HashMap<>();

    @PostConstruct
    public void init() {
        for (Operator operator : operators) {
            stringOperatorMap.put(operator.processableOperator().toString(), operator);
        }
    }

    public OperationResult process(CalculationRequest request) {
        if (!stringOperatorMap.containsKey(request.getOperator())) {
            return new OperationResult(new UnknownOperatorError(request.getOperator()));
        }

        List<Number> numbers = new ArrayList<>();

        List<String> operands = request.getOperands();
        for (int i = 0; i < operands.size(); i++) {
            try {
                numbers.add(new Number(operands.get(i)));
            } catch (NumberFormatException e) {
                return new OperationResult(new WrongOperandFormatException(i, "BigDecimal", operands.get(i)));
            }
        }

        return stringOperatorMap.get(request.getOperator()).process(numbers);
    }
}
