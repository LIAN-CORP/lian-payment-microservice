package com.lian.marketing.paymentmicroservice.infrastructure.driving.http.exceptionhandler;

import com.lian.marketing.paymentmicroservice.domain.exception.DebtDoNotExists;
import com.lian.marketing.paymentmicroservice.domain.exception.UserDoNoExists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PaymentControllerAdvisor {
    @ExceptionHandler(UserDoNoExists.class)
    public ResponseEntity<ExceptionResponse> handleUserDoNoExistsException(UserDoNoExists exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(
                        HttpStatus.BAD_REQUEST.toString(),
                        HttpStatus.BAD_REQUEST.value(),
                        exception.getMessage(),
                        java.time.LocalDateTime.now(),
                        "USER_DO_NOT_EXISTS"
                ));
    }

    @ExceptionHandler(DebtDoNotExists.class)
    public ResponseEntity<ExceptionResponse> handleDebtDoNotExistsException(DebtDoNotExists exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(
                        HttpStatus.BAD_REQUEST.toString(),
                        HttpStatus.BAD_REQUEST.value(),
                        exception.getMessage(),
                        java.time.LocalDateTime.now(),
                        "DEBT_DO_NOT_EXISTS"
                ));
    }
}
