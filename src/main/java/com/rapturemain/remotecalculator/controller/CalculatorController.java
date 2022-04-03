package com.rapturemain.remotecalculator.controller;

import com.rapturemain.remotecalculator.model.CalculationRequest;
import com.rapturemain.remotecalculator.model.CalculationResponse;
import com.rapturemain.remotecalculator.operator.OperationResult;
import com.rapturemain.remotecalculator.service.CalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpClient;

@RestController
@RequestMapping("restapi")
@RequiredArgsConstructor
public class CalculatorController {
    private final CalculatorService calculatorService;

    @PostMapping("/calculate")
    public ResponseEntity<?> calculate(@RequestBody CalculationRequest request) {
        OperationResult result = calculatorService.process(request);

        if (result.getError() != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(result.getError());
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(new CalculationResponse(result.getResult().toPlainString()));
    }
}
