package com.lian.marketing.paymentmicroservice.infrastructure.driving.http.exceptionhandler;

import com.lian.marketing.paymentmicroservice.domain.exception.RemainingAmountIsOverTheLimitException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DebtControllerAdvisor {
    @ExceptionHandler(RemainingAmountIsOverTheLimitException.class)
    public ResponseEntity<ExceptionResponse> handleRemainingAmountIsOverTheLimitException(RemainingAmountIsOverTheLimitException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(
                        HttpStatus.BAD_REQUEST.toString(),
                        HttpStatus.BAD_REQUEST.value(),
                        exception.getMessage(),
                        java.time.LocalDateTime.now(),
                        "REMAINING_AMOUNT_IS_OVER_THE_LIMIT"
                ));
    }
}
